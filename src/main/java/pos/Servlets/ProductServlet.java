package pos.Servlets;

import com.google.gson.Gson;
import pos.Controllers.Inventory;
import pos.Models.Product;
import pos.Models.ProductSpec;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Remco on 22-9-2015.
 */
@Path("/product")
public class ProductServlet {

    @Path("/{barcode}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProduct(@PathParam("barcode") int barcode){
        Inventory inventory = Inventory.getInventory();
        Product product = inventory.searchProduct(barcode);

        Gson gson = new Gson();
        return gson.toJson(product);
    }

    @Path("/{barcode}/spec")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductPrice(@PathParam("barcode") int barcode){
        Inventory inventory = Inventory.getInventory();
        Product product = inventory.searchProduct(barcode);
        ProductSpec spec = product.getSpec();
        Gson gson = new Gson();
        return gson.toJson(spec);
    }
}
