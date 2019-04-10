package upc.edu.dsa;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.List;

public interface MyProduct {
    public List<Producto> ProductosOrdenadosPorPrecio (int idProducto) throws ProductoNotFoundException;
    public List<Pedido> PedidosOrdenados (int idPedido) throws PedidoNotFoundException;
    public List<Producto> ProductosOrdenadosPorVenta (int idProducto ) throws ProductoNotFoundException;
    Pedido serveAnOrder();
    public void HacerUnPedido (String idUser, Pedido pedido) throws UserNotFoundException;


    void addUser(String user);
    void addProducto(Producto p);
    HashMap<String, User> allUsers();
    int size();

}
