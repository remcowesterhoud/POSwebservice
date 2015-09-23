package pos.Servlets;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import pos.Controllers.CardRegister;
import pos.Models.FidelityCard;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

        List<FidelityCard> cards = register.getCards();

        Gson gson = new Gson();
        JsonElement jArray = new JsonArray();
        for (FidelityCard card : cards){
            JsonElement jTree = gson.toJsonTree(card);
            jTree.getAsJsonObject().addProperty("self", "http://localhost:8080/fidelitycards/" + card.getCardCode());
            jArray.getAsJsonArray().add(jTree);
        }

        return gson.toJson(jArray);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createCard(@FormParam("cardcode") int cardcode, @FormParam("name") String name){
        CardRegister register = CardRegister.getCardRegister();
        FidelityCard card = new FidelityCard(cardcode, name);
        register.addCard(card);

        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(card);
        jsonElement.getAsJsonObject().addProperty("self", "http://localhost:8080/fidelitycards/" + cardcode);
        return gson.toJson(jsonElement);
    }

    @Path("/{cardcode}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String updateCard(@PathParam("cardcode") int cardcode, @QueryParam("name") String name){
        CardRegister register = CardRegister.getCardRegister();
        FidelityCard card = register.searchCard(cardcode);
        card.setCustomerName(name);

        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(card);
        jsonElement.getAsJsonObject().addProperty("self", "http://localhost:8080/fidelitycards/" + cardcode);
        return gson.toJson(jsonElement);
    }

    @Path("/{cardcode}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCard(@PathParam("cardcode") int cardcode){
        CardRegister register = CardRegister.getCardRegister();
        FidelityCard card = register.searchCard(cardcode);
        register.deleteCard(card);

        Gson gson = new Gson();
        JsonElement json = new JsonObject();
        json.getAsJsonObject().addProperty("status", "Success");
        return gson.toJson(json);
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
