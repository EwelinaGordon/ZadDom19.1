package Shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CartController {

    private ShoppingCart shoppingCart;

    public CartController(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @GetMapping("/koszyk")
    @ResponseBody
    public String showCart(){
        return shoppingCart.toString();
    }

    @GetMapping("/koszyk/suma")
    @ResponseBody
    public String totalPrice(){
        return "Do zapłaty: " + shoppingCart.getTotals() + " zł.";
    }
}
