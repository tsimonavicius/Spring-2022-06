package lt.codeacademy.eshop.products;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductsRepository {

    private final List<Product> productsList = new ArrayList<>();

    public List<Product> getAll() {
        return productsList;
    }

    public void save(Product product) {
        productsList.add(product);
    }

    public Product getById(UUID id) {

        return productsList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void update(Product product) {

        Integer index = null;
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getId().equals(product.getId())) {
                index = i;
            }
        }

        if (index != null) {
            productsList.set(index, product);
        }
    }
}
