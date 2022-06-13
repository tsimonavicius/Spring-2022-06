package lt.codeacademy.eshop.products;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping
    public String getProducts(Model model) {

        List<Product> products = productsService.getProducts();
        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping("/create")
    public String openProductForm() {
        return "productForm";
    }

    @PostMapping("/create")
    public String createProduct(Product product, Model model) {

        productsService.createProduct(product);

        model.addAttribute("products", productsService.getProducts());
        return "products";
    }
}
