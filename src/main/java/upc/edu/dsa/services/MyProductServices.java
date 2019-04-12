package upc.edu.dsa.services;
import upc.edu.dsa.*;
import upc.edu.dsa.exceptions.*;
import upc.edu.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
@Api(value = "/products", description = "Endpoint to MyProductServices")
@Path("/products")

public class MyProductServices {
    private MyProduct MyProduct;
    public MyProductServices () throws ProductoNotFoundException, UserNotFoundException {
        this.MyProduct = MyProductImplementation.getInstance();

            this.MyProduct.addUser(10, "Maria");
            this.MyProduct.addUser("20", "Sheila");

            this.MyProduct.addProducto("Pantalon", 35);
            this.MyProduct.addProducto("Camiseta", 5);
            this.MyProduct.addProducto("Abrigo", 60);





}
