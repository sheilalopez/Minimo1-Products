package upc.edu.dsa;

import org.apache.log4j.Logger;

import java.util.*;

public class MyProductImplementation implements MyProduct{
    private final static Logger log = Logger.getLogger(MyProductImplementation.class.getName());

    //Singletone
    private static MyProductImplementation instance;
    private List<Producto> productos;
    private int numProductos;
    private LinkedList<Pedido> pedidos;
    private HashMap<String, User> users;
    //constructor privado
    private MyProductImplementation(){
        productos = new LinkedList<>();
        pedidos = new LinkedList<>();
        users = new HashMap<>();
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
        //si servimos un pedido, tenemos que eliminarlo de la lista de pedidos "pendientes"
        Pedido p = this.pedidos.pop(); //que hace exactamente el pop? es para listas solamente?
        log.info("Order served: " +p); //supongo que coge el último pedido de la lista
        procces(p);



    }

    private void procces(Pedido p) {
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
    public void addProducto(Producto p) {
        this.productos.add(p);

    }

    @Override
    public HashMap<String, User> allUsers() {
        HashMap<String, User> ret = new HashMap<>();
        ret.putAll(this.users);

        return ret;
    }

    @Override
    public int size() {
        log.info("Tamaño: " + this.productos.size());
        return this.productos.size();
    }
}
