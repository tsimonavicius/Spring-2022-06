package lt.codeacademy.eshop.products;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    public List<Product> getProducts() {
        return productsRepository.getAll();
    }

    public void createProduct(Product product) {

        UUID productId = UUID.randomUUID();
        product.setId(productId);

        productsRepository.save(product);
    }

    public Product getProduct(UUID id) {

        return productsRepository.getById(id);
    }

    public void updateProduct(Product product) {

        productsRepository.update(product);
    }

    public void deleteProduct(UUID id) {

        productsRepository.delete(id);
    }
}
