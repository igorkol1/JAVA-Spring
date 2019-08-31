package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.domain.Product;

import java.util.*;

@Component
public class ProduktDao {

    List<Product> productList;

    public ProduktDao() {
        Random random = new Random();
        productList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            productList.add(new Product("Product " + i, random.nextDouble()));
        }
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProductWithUuid(UUID uuid) {
        return productList.stream()
                .filter(product -> product.getUuid().equals(uuid))
                .findFirst()
                .orElse(null);
    }
}
