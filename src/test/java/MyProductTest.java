import org.junit.*;
import upc.edu.dsa.*;

import java.util.List;
public class MyProductTest {
    private static MyProduct mp;

    @Before
    public void setUp() throws ProductoNotFoundException {

        this.mp = MyProductImplementation.getInstance();
        //creo usuarios
        this.mp.addUser(10, "Maria");
        this.mp.addUser(20, "Sheila");
        this.mp.addUser(30, "Sergi");
        //creo productos

        this.mp.addProducto("Pantalon", 35);
        this.mp.addProducto("Camiseta", 5);
        this.mp.addProducto("Abrigo", 60);
        this.mp.addProducto("Camisa", 30);
        this.mp.addProducto("Zapatos", 80);


    }


    @After
    public void tearDown(){
        this.mp.clear();
    }

    @Test
    public void ProductosOrdenadosPorPrecio() throws ProductoNotFoundException {
        List<Producto> res = this.mp.ProductosOrdenadosPorPrecio();
        Assert.assertEquals(res.get(0).getNombreProducto(), "Camiseta", "Camiseta");
        Assert.assertEquals(res.get(1).getNombreProducto(), "Camisa", "Camisa");
        Assert.assertEquals(res.get(2).getNombreProducto(), "Pantalon", "Pantalon");
        Assert.assertEquals(res.get(3).getNombreProducto(), "Abrigo", "Abrigo");
        Assert.assertEquals(res.get(4).getNombreProducto(), "Zapatos", "Zapatos");


    }
}
