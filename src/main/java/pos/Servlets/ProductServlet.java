package pos.Servlets;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import pos.Controllers.Inventory;
import pos.Models.Product;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Remco on 22-9-2015.
 */
@Path("/products")
public class ProductServlet {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String allProducts(){
        Inventory inventory = Inventory.getInventory();

        Gson gson = new Gson();
        return gson.toJson(inventory.getProducts());
    }

    @Path("/{barcode}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProduct(@PathParam("barcode") int barcode){
        Inventory inventory = Inventory.getInventory();
        Product product = inventory.searchProduct(barcode);

        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(product);
        jsonElement.getAsJsonObject().addProperty("self", "http://localhost:8080/products/" + barcode);
        return gson.toJson(jsonElement);
    }
}
