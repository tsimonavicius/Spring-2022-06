package lt.codeacademy.eshop.products.repos;

import lt.codeacademy.eshop.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaProductsRepository extends JpaRepository<Product, UUID>, ProductsRepository {

    List<Product> findByNameContainingIgnoreCase(String name);
}
