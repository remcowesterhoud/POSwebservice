package pos.Servlets;

import com.google.gson.Gson;
import pos.Models.Discount;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * Created by Laurens Oomen on 22-9-2015 at 15:48.
 */
//@Path("/discounts")
//public class DiscountServlet {
//
//    @Path("/{discountID}")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getDiscount(@PathParam("discountID") int discountID){
//
//        Discount discount = Discounts.searchDiscount(discountID);
//        Gson gson = new Gson();
//        return gson.toJson(discount);
//    }
//    @Path("/discountDate")
//    @GET
//    @Produces
//    public String getDiscountDate(@PathParam("date") Date date){
//        Gson gson = new Gson();
//        if(d.date = date) {
//            for (Discount d : Discounts) {
//
//                gson.toJson(d);
//
//            }
//        }
//        return gson.toJson(date);
//    }
//    @Path("/newDiscount")
//    @POST
//    public void newDiscount(@PathParam("discount") Discount discount){
//        Discounts.add(discount);
//    }
//}