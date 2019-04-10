package upc.edu.dsa;

import java.util.LinkedList;

public class Pedido {
    private User user;
    private LinkedList<Producto> productos;

    public void Pedido(){
        this.productos = new LinkedList<Producto>();

    }

    public Pedido(User user) {
        this.user = user;
        this.productos = productos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<Producto> productos) {
        this.productos = productos;
    }

}
