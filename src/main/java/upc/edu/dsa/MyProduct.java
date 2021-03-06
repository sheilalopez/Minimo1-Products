package upc.edu.dsa;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.List;

public interface MyProduct {


    public List<Producto> ProductosOrdenadosPorPrecio () throws ProductoNotFoundException;
    public List<Pedido> PedidosOrdenados (String User) throws UserNotFoundException;
    public List<Producto> ProductosOrdenadosPorVenta ()throws ProductoNotFoundException;
    Pedido serveAnOrder();
    public void HacerUnPedido (String idUser, Pedido pedido) throws UserNotFoundException;


    void addUser(int idUser, String user);
    void addProducto(String nombreProducto, double precio);
    HashMap<String, User> allUsers();
    int size();

    void clear();


}
