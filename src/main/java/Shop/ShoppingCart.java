package Shop;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ShoppingCart {

    private HashMap<Product, Integer> cart;

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public HashMap<Product, Integer> getCart() {
        return cart;
    }

    public void addProduct(Product product, Integer amount) {

        if (cart.get(product) == null) {
            cart.put(product, amount);
        } else {
            Integer totalAmount = cart.get(product);
            cart.put(product, totalAmount + amount);
        }
    }

    public Double getTotals(){
        double totalAmount = 0;
        for (Map.Entry<Product, Integer> cartElement : cart.entrySet()) {
            totalAmount += cartElement.getValue() * cartElement.getKey().getPrice();
        }
        return totalAmount;
    }

    @Override
    public String toString() {
        String result = "";
        for (Map.Entry<Product, Integer> element : cart.entrySet()) {
            Product product = element.getKey();
            result +="Produkt: " +product.getName() +" , Cena: " +product.getPrice() + ", Ilość: " + element.getValue() + "</br>";
        }
        return result;
    }
}

