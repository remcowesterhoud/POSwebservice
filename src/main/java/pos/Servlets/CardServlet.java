package pos.Servlets;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import pos.Controllers.CardRegister;
import pos.Models.FidelityCard;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Remco on 23-9-2015.
 */
@Path("/fidelitycards")
public class CardServlet {

    @GET

    @Produces(MediaType.APPLICATION_JSON)
    public String allCards(){
        CardRegister register = CardRegister.getCardRegister();
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(register);
        List<FidelityCard> cards = register.getCards();

        for(FidelityCard card : cards){
            jsonElement.getAsJsonObject().addProperty("self", "http://localhost:8080/fidelitycards/");
        }



            return gson.toJson(jsonElement);


    }

    @Path("/{cardcode}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCard(@PathParam("cardcode") int cardcode){
        CardRegister register = CardRegister.getCardRegister();
        FidelityCard fidelityCard = register.searchCard(cardcode);

        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(fidelityCard);
        jsonElement.getAsJsonObject().addProperty("self", "http://localhost:8080/fidelitycards/" + cardcode);
        return gson.toJson(jsonElement);
    }
}
