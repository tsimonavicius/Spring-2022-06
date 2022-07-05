package lt.codeacademy.eshop.products.repos;

import lt.codeacademy.eshop.products.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

@Profile("!mocked-db")
public interface JpaProductsRepository extends JpaRepository<Product, UUID>, ProductsRepository {

    List<Product> findByNameContainingIgnoreCase(String name);
}
