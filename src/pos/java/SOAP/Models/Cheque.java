package SOAP.Models;

import REST.Enums.ProductType;
import REST.Models.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by luppi on 9-9-2015.
 */
public class Cheque extends Payment {

    public Cheque(HashMap<Product, Integer> order, double amount){
        super(amount);
        handlePayment(order);
    }

    public double handlePayment(HashMap<Product, Integer> order) {

        ProductType type = getChequeType();
        double max = calculateMax(order, type);
        if (amount > max) {
            System.out.println("You do not have enough products of this type.");
            return handlePayment(order);
        } else {
            return amount;
        }
    }
    public ProductType getChequeType(){
        System.out.println("What type of cheque do you have? Options are:");
        ProductType[] types = ProductType.values();
        int i = 0;
        for (ProductType type : types){
            i++;
            System.out.println(i + ". for " + type);
        }
        return types[scanner.nextInt() - 1];
    }

    public double calculateMax(HashMap<Product, Integer> order, ProductType type){
        double max = 0;

        for (Map.Entry<Product, Integer> entry : order.entrySet()){
            if (entry.getKey().getSpec().getSpec("Type") == type){
                max += entry.getKey().getPrice() * entry.getValue();
            }
        }
        return max;
    }
}
