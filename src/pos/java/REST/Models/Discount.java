package REST.Models;

/**
 * Created by Laurens Oomen on 23/09/15 at 14:53.
 */
public abstract class Discount {

    public Product product;

    public Discount(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public abstract double getDiscount(int quantityPurchased);
}

