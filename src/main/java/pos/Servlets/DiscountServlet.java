package pos.Servlets;

import com.google.gson.Gson;
import pos.Controllers.Inventory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Laurens Oomen on 22-9-2015 at 15:48.
 */
public class DiscountServlet {

//    @Path("/{barcode}")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getDiscount(@PathParam("barcode") int[] barcodes){
//        Inventory inventory = Inventory.getInventory();
//        Discount discount = inventory.searchDiscount(barcode);
//
//        Gson gson = new Gson();
//        return gson.toJson(discount);
//    }
}
