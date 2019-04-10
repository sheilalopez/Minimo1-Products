package upc.edu.dsa;

import java.util.LinkedList;

public class Pedido {
    private User user;
    private LinkedList<Prodcuto> productos;

    public void Pedido(){
        this.productos = new LinkedList<Prodcuto>();

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

    public LinkedList<Prodcuto> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<Prodcuto> productos) {
        this.productos = productos;
    }

}
