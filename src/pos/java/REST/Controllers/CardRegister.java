package REST.Controllers;

import REST.Models.FidelityCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Remco on 23-9-2015.
 */
public class CardRegister {

    private List<FidelityCard> fidelityCardList;
    private static CardRegister cardRegister;

    private CardRegister() {
        fidelityCardList = new ArrayList<FidelityCard>();

        //Dummy Data
        addCard(new FidelityCard(123, "Laurens Oomen"));
        addCard(new FidelityCard(666, "Matthijs van der Meijden"));
        addCard(new FidelityCard(888, "Remco Westerhoud"));
    }

    public static CardRegister getCardRegister(){

        if (cardRegister == null) {
            synchronized (CardRegister.class) {
                if (cardRegister == null) {
                    cardRegister = new CardRegister();
                }
            }
        }
        return cardRegister;
    }

    public void addCard(FidelityCard newFidelityCard){
        fidelityCardList.add(newFidelityCard);
    }

    public void deleteCard(FidelityCard fidelityCard){
        fidelityCardList.remove(fidelityCard);
    }

    public List<FidelityCard> getCards(){
        return fidelityCardList;
    }

    public FidelityCard searchCard(int cardCode){
        for (FidelityCard fidelityCard : fidelityCardList){
            if (fidelityCard.getCardCode() == cardCode){
                return fidelityCard;
            }
        }
        return null;
    }
}
