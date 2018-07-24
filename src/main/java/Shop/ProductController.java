package Shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


@Controller
public class ProductController {

    private ProductRepository productRepository;
    private ShoppingCart shoppingCart;

    public ProductController(ProductRepository productRepository, ShoppingCart shoppingCart) {
        this.productRepository = productRepository;
        this.shoppingCart = shoppingCart;
    }

    @GetMapping("/")
    public String productPresents(Model model) {
        List<Product> productsSet = productRepository.getProducts();
        model.addAttribute("products", productsSet);
        model.addAttribute("newProd", new Product());
        return "index";
    }

    @PostMapping("/add")
    public String addProductToCart(@RequestParam String name, @RequestParam Integer amount) {
        Product product = productRepository.findByName(name);
        if (product != null) {
            shoppingCart.addProduct(product, amount);
            return "added.html";
        }
        return "redirect:/";
    }






}
