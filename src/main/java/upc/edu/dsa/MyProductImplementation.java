package upc.edu.dsa;

import org.apache.log4j.Logger;
import sun.awt.image.ImageWatched;

import java.util.*;

public class MyProductImplementation implements MyProduct{
    private final static Logger log = Logger.getLogger(MyProductImplementation.class.getName());

    //Singletone
    private static MyProductImplementation instance;
    private LinkedList<Producto> productos;
    private LinkedList<Pedido> pedidos;
    private HashMap<String, User> users;
    //constructor privado
    private MyProductImplementation(){
       productos = new LinkedList<>();
        pedidos = new LinkedList<>();
        users = new HashMap<>();

    }
    public static MyProduct getInstance(){
        if(instance==null) instance = new MyProductImplementation();
        return instance;
    }
    @Override
    public List<Producto> ProductosOrdenadosPorPrecio() throws ProductoNotFoundException {
        List<Producto> lista = new LinkedList<>();
        lista.addAll(this.productos);
        //ahora hay que ordenarlos
        Collections.sort(lista, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return (int)(o1.getPrecio() - o2.getPrecio());
            }
        });
        log.info("Lista ordenada: " + lista );
        return lista;
    }

    @Override
    public List<Pedido> PedidosOrdenados(String user) throws UserNotFoundException {
        List<Pedido> pedidos = new LinkedList<>();
        User usuario = this.users.get(user);
        if (usuario != null){
            log.info("El usuario es: " + usuario);
            pedidos = usuario.getPedidos();
        } else {
            throw new UserNotFoundException();
        }
        log.info("Historial de pedidos: " + pedidos);
        return pedidos;



    }

    @Override
    public List<Producto> ProductosOrdenadosPorVenta() throws ProductoNotFoundException {
        List<Producto> productos = new LinkedList<>();
        productos.addAll(this.productos);
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return (-1)*(o1.getVentas() - o2.getVentas());
            }
        });
        log.info("Lista de productos ordenados por ventas" + productos);
        return productos;
    }



   @Override
  public Pedido serveAnOrder() {

        Pedido p = this.pedidos.pop();
        log.info("Order served: " +p);
        proces(p);
        User usuario = p.getUser();
        usuario.addPedido(p);
        return p;
    }

    private void proces(Pedido p) {
        LinkedList <LProducto> l  = p.getProductos();
        Producto producto;
        for (LProducto lp : l){
            producto = this.getProducto(lp.producto);
            producto.addVentas(lp.c);
            log.info("Ventas de el producto: " + producto.getVentas());


        }







    }

    private Producto getProducto(String producto) {
        log.info("I'm in");
        Producto p = null;
        for(int i = 0; i< this.productos.size(); i++) {
            if(producto.equals(this.productos.get(i).getNombreProducto())){
                p = this.productos.get(i);
            }
        }
        return p;
    }

    @Override
    public void HacerUnPedido(String idUser, Pedido p) throws UserNotFoundException {
        User usuario = this.users.get(idUser);
        log.info("USUARIO OBTENIDO: " + usuario);

        if(usuario != null){
            p.setUser(usuario);
            this.pedidos.add(p);
            log.info("Lista de pedidos: " + pedidos);

        }else {
            throw new UserNotFoundException();
        }



    }

    @Override
    public void addUser(int idUser, String user ) {
        users.put(user,new User(idUser,user));

    }

    @Override
    public void addProducto (String nombreProducto, double precio) {
     Producto p = new Producto(nombreProducto, precio);
     this.productos.add(p);

    }

    @Override
    public HashMap<String, User> allUsers() {
        HashMap<String, User> ret = new HashMap<>();
        ret.putAll(this.users);

        return ret;
    }

    public List<Producto> allProducts(){
        List<Producto> ret = new ArrayList<>();
        ret.addAll(this.productos);

        return ret;
    }

    @Override
    public int size() {
        log.info("Tamaño: " + this.productos.size());
        return this.productos.size();
    }
    @Override
    public void clear() {
        instance = null;
        this.productos= null;
        this.pedidos = null;
        this.users = null;
        log.info("Data cleared");
    }
}
