package lt.codeacademy.eshop.products;

import lombok.AllArgsConstructor;
import lt.codeacademy.eshop.products.errors.ProductNotFoundException;
import lt.codeacademy.eshop.products.repos.ProductsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    public Page<Product> getProducts(Pageable pageable) {
        return productsRepository.findAll(pageable);
    }

    public void createProduct(Product product) {

        UUID productId = UUID.randomUUID();
        product.setId(productId);

        productsRepository.save(product);
    }

    public Product getProduct(UUID id) {

        return productsRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("", null));
    }

    public void updateProduct(Product product) {

        productsRepository.save(product);
    }

    public Product deleteProduct(UUID id) {

        Product productToRemove = getProduct(id);
        productsRepository.delete(productToRemove);

        return productToRemove;
    }

    public List<Product> search(String name) {

        return productsRepository.findByNameContainingIgnoreCase(name);
    }

}
