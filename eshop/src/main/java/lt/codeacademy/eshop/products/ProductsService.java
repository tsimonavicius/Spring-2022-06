package lt.codeacademy.eshop.products;

import lombok.AllArgsConstructor;
import lt.codeacademy.eshop.products.errors.ProductNotFoundException;
import lt.codeacademy.eshop.products.repos.JpaProductsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

@AllArgsConstructor
@Service
public class ProductsService {

    private final JpaProductsRepository productsRepository;

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
//                .orElseThrow(new MyExceptionSupplier());
//                .orElseThrow(new Supplier<ProductNotFoundException>() {
//
//                    @Override
//                    public ProductNotFoundException get() {
//                        return new ProductNotFoundException("", null);
//                    }
//                })
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

    private static class MyExceptionSupplier implements Supplier<ProductNotFoundException> {

        @Override
        public ProductNotFoundException get() {
            return new ProductNotFoundException("", null);
        }
    }
}
