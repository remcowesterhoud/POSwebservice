package REST.Models;

/**
 * Created by Remco on 23-9-2015.
 */
public class FidelityCard {

    private int cardCode;
    private String customerName;

    public FidelityCard(int cardCode, String customerName) {
        this.cardCode = cardCode;
        this.customerName = customerName;
    }

    public int getCardCode() {

        return cardCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
