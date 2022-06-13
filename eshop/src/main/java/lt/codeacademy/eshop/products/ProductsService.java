package lt.codeacademy.eshop.products;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    public List<Product> getProducts() {
        return productsRepository.getProducts();
    }
}
