package upc.edu.dsa;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

public class Pedido {
    private User user;
    LinkedList<LProducto> productos;


    public void Pedido(){
        this.productos = new LinkedList<LProducto>();

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

    public LinkedList<LProducto> getProductos() {
        return productos;
    }





    public void setProductos(LinkedList<LProducto> productos) {
        this.productos = productos;
    }

}
