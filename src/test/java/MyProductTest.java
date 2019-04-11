import org.junit.*;
import upc.edu.dsa.*;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

import static org.reflections.Reflections.log;

public class MyProductTest {

    final static Logger log = Logger.getLogger(MyProductTest.class.getName());
    private static MyProduct mp;
    static List<LProducto> lp1, lp2, lp3;
    static Pedido pedido1, pedido2, pedido3;

    static User u1, u2;

    static Producto producto1, producto2, producto3, producto4, producto5, producto6;

    @Before
    public void setUp() throws ProductoNotFoundException {

        this.mp = MyProductImplementation.getInstance();
        lp1 = new LinkedList<>();
        lp2 = new LinkedList<>();
        lp3 = new LinkedList<>();
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
    @Test
    public void HacerUnPedido () throws ProductoNotFoundException{
        try {
            //Place new orders
            LProducto l1 = new LProducto();
            l1.producto = "Pantalon";
            l1.c= 3;
            LProducto l2 = new LProducto();
            l2.producto = "Camiseta";
            l2.c= 5;
            LProducto l3 = new LProducto();
            l3.producto = "Abrigo";
            l3.c = 3;
            lp1.add(l1);
            lp1.add(l2);
            lp1.add(l3);
            lp2.add(l1);
            pedido1 = new Pedido(lp1);
            pedido2 = new Pedido(lp2);
            log.info("Pedido1: " +pedido1);
            mp.HacerUnPedido("Sheila", pedido1);
            mp.HacerUnPedido("Sergi", pedido2);
        }catch (UserNotFoundException e){
            log.error("EL usuario no existe en la lista " +e.getMessage());
        }
    }
}
