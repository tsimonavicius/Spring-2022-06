package lt.codeacademy.eshop.products.repos;

import lt.codeacademy.eshop.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaProductsRepository extends JpaRepository<Product, UUID> {
}
