package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Remco on 22-9-2015.
 */

@Path("/dollar")
public class Dollar {
    @Path("/{amount}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getDollar(@PathParam("amount")int amount){
        return "Dollar bitch " + amount;
    }
}
