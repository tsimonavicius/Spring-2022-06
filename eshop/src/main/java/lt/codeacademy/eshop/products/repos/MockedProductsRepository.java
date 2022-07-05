package lt.codeacademy.eshop.products.repos;

import lt.codeacademy.eshop.products.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Repository
@Profile("mocked-db")
public class MockedProductsRepository implements ProductsRepository {

    private final List<Product> productsList = new ArrayList<>();

    @Override
    public Page<Product> findAll(Pageable pageable) {

        return new PageImpl<>(productsList, pageable, productsList.size());
    }

    public Product save(Product product) {

        Optional<Product> productOptional = findById(product.getId());

        if (productOptional.isPresent()) {
            update(product);
        } else {
            createNewProduct(product);
        }

        return product;
    }

    @Override
    public Optional<Product> findById(UUID id) {

        return productsList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    @Override
    public void delete(Product productToRemove) {
        getIndex(productToRemove.getId())
                .ifPresent(index -> productsList.remove(index.intValue()));
    }

    @Override
    public List<Product> findByNameContainingIgnoreCase(String name) {

        return productsList.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .collect(toList());
    }

    private void createNewProduct(Product product) {
        productsList.add(product);
    }

    private void update(Product product) {

        getIndex(product.getId())
                .ifPresent(index -> productsList.set(index, product));
    }

    private Optional<Integer> getIndex(UUID id) {

        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getId().equals(id)) {
                return Optional.of(i);
            }
        }

        return Optional.empty();
    }
}
