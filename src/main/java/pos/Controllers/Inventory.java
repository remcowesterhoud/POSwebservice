package pos.Controllers;

import pos.Enums.Brand;
import pos.Enums.ProductType;
import pos.Models.Product;
import pos.Models.ProductSpec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Remco on 22-9-2015.
 */
public class Inventory {

    private List<Product> productList;
    private static Inventory inventory;

    private Inventory() {
        productList = new ArrayList<Product>();

        //Dummy Data
        HashMap map = new HashMap();
        map.put("Merk", Brand.Heineken);
        map.put("Type", ProductType.Beer);
        ProductSpec spec = new ProductSpec(map);
        Product beer = new Product(10, "Heineken Bier", spec, 123);
        addProduct(beer);
    }

    public static Inventory getInventory(){

        if (inventory == null) {
            synchronized (Inventory.class) {
                if (inventory == null) {
                    inventory = new Inventory();
                }
            }
        }
        return inventory;
    }
    public void addProduct(Product newProduct){
        productList.add(newProduct);
    }

    public void deleteProduct(Product product){
        productList.remove(product);
    }

    public List<Product> getProducts(){
        return productList;
    }

    public Product searchProduct(int productCode){
        for (Product product : productList){
            if (product.getProductCode() == productCode){
                return product;
            }
        }
        return null;
    }

}