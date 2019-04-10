package upc.edu.dsa;

import java.util.LinkedList;

public class User {
    //Atributos
    private int idUser;
    private String Username;
    private LinkedList<Pedido> pedidos;

    public User (){

    }

    public User(int idUser, String username) {
        this.idUser = idUser;
        Username = username;
        this.pedidos = new LinkedList<Pedido>();
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public LinkedList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(LinkedList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    //metodo
    public void addPedido (Pedido pedido){
        this.pedidos.add(pedido);
    }
}
