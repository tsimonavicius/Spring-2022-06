package lt.codeacademy.eshop.products;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductsRepository {
    public List<Product> getProducts() {
        return Collections.singletonList(
                new Product("iPhone 21", "This is a product description", new BigDecimal("1230.20")));
    }
}
