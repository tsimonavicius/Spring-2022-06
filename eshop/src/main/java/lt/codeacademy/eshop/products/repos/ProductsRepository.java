package lt.codeacademy.eshop.products.repos;

import lt.codeacademy.eshop.products.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductsRepository {

    Page<Product> findAll(Pageable pageable);

    Product save(Product product);

    Optional<Product> findById(UUID id);

    void delete(Product productToRemove);

    List<Product> findByNameContainingIgnoreCase(String name);
}
