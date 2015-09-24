package pos.Controllers;

import pos.Models.Discount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laurens Oomen on 23/09/15 at 15:21.
 */
public class DiscountRegister {

    private List<Discount> discountList;
    private static DiscountRegister discountRegister;


    private DiscountRegister() {
        discountList = new ArrayList<Discount>();
        Inventory inventory = Inventory.getInventory();

        //Dummy Data
        addDiscount(new PercentageDiscount(inventory.searchProduct(123), 25));
    }

    public static DiscountRegister getDiscountRegister(){

        if (discountRegister == null) {
            synchronized (DiscountRegister.class) {
                if (discountRegister == null) {
                    discountRegister = new DiscountRegister();
                }
            }
        }
        return discountRegister;
    }

    public void addDiscount(Discount newDiscount){
        discountList.add(newDiscount);
    }

    public void deleteDiscount(Discount discount){
        discountList.remove(discount);
    }

    public List<Discount> getDiscounts(){
        return discountList;
    }

}
