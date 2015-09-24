package SOAP.Models;

import java.util.Scanner;

/**
 * Created by Remco on 10-9-2015.
 */
public abstract class Payment {
    protected double amount;

    public Payment(double amount){
        this.amount = amount;
    }

    public double getAmountPayed() {
        return amount;
    }
}
