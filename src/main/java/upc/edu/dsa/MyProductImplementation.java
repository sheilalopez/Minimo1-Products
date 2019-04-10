package upc.edu.dsa;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MyProductImplementation implements MyProduct{
    private final static Logger log = Logger.getLogger(MyProductImplementation.class.getName());

    //Singletone
    private static MyProductImplementation instance;
    private List<Producto> productos;
    private LinkedList<Pedido> pedidos;
    private HashMap<String, User> users;
    //constructor privado
    private MyProductImplementation(){
        productos = new LinkedList<>();
        pedidos = new LinkedList<>();
        users = new HashMap<>();
    }
    @Override
    public List<Producto> ProductosOrdenadosPorPrecio(int idProducto) throws ProductoNotFoundException {
        return null;
    }

    @Override
    public List<Pedido> PedidosOrdenados(int idPedido) throws PedidoNotFoundException {
        return null;
    }

    @Override
    public List<Producto> ProductosOrdenadosPorVenta(int idProducto) throws ProductoNotFoundException {
        return null;
    }

    @Override
    public Pedido serveAnOrder() {
        return null;
    }

    @Override
    public void HacerUnPedido(String idUser, Pedido pedido) throws UserNotFoundException {

    }

    @Override
    public void addUser(String user) {

    }

    @Override
    public void addProducto(Producto p) {

    }

    @Override
    public HashMap<String, User> allUsers() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
