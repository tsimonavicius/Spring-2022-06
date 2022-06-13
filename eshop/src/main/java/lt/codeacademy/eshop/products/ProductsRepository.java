package lt.codeacademy.eshop.products;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsRepository {

    private final List<Product> productsList = new ArrayList<>();

    public List<Product> getAll() {
        return productsList;
    }

    public void save(Product product) {
        productsList.add(product);
    }
}
