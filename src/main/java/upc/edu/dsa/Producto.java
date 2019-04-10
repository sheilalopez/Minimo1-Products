package upc.edu.dsa;

public class Producto {
    private String nombreProducto;
    private double precio;
    private int ventas = 0;

    public void Producto(){

    }

    public Producto(String nombreProducto, double precio) {

        this.nombreProducto = nombreProducto;
        this.precio = precio;

    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
    public void addVentas (int q) {
        this.ventas = this.ventas + q;
    }
}
