package pos.Controllers;

import pos.Models.Discount;
import pos.Models.Product;

/**
 * Created by Laurens Oomen on 23/09/15 at 15:43.
 */
public class PercentageDiscount extends Discount{

    private double percentage;

    public PercentageDiscount(Product product, double percentage) {
        super(product);
        this.percentage = percentage;
    }

    public double getDiscount(int quantityPurchased) {
        double discount = product.getPrice() * (percentage / 100);
        return discount * quantityPurchased;
    }
}
