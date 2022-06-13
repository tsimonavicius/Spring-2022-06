package lt.codeacademy.eshop.products;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class ProductsService {
    public List<Product> getProducts() {
        return Collections.singletonList(
                new Product("iPhone 21", "This is a product description", new BigDecimal("1230.20")));
    }
}
