package Shop;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

   public List<Product> products;

    public ProductRepository() {

        products = new ArrayList<>();
        products.add(new Product("Marchewka", 3.5, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAwDcZTvTV6lWN9pWeTey_00BR9i99Ee0lckr7BHlmAgLx2-Pm"));
        products.add(new Product("Pietruszka", 4.3, "https://www.gazeta-mosina.pl/wp-content/uploads/2016/08/Pietruszka-640x442.jpg"));
        products.add(new Product("Por", 4.3, "http://www.dekomozaik.pl/environment/cache/images/500_500_productGfx_18187e1a9b8bbb7c8fd301a40a8df6d9.jpg"));

    }

    public List<Product> getProducts() {
        return products;
    }

    public Product findByName(String name){
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        } return null;
    }

}
