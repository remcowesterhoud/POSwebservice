package pos.Models;

import java.io.Serializable;

/**
 * Created by Remco on 22-9-2015.
 */
public class Product implements Serializable{
    private double price;
    private ProductSpec spec;
    private int productCode;
    private String name;

    public Product(double price, String name, ProductSpec spec, int productCode) {
        this.price = price;
        this.name = name;
        this.spec = spec;
        this.productCode = productCode;
    }

    public double getPrice() {

        return price;
    }

    public ProductSpec getSpec() {
        return spec;
    }

    public int getProductCode() {
        return productCode;
    }

    public String getName(){
        return name;
    }
}