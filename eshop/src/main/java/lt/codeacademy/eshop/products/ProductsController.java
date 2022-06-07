package lt.codeacademy.eshop.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Arrays;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("products",
                Arrays.asList(new Product("iPhone 21", "This is a product description", new BigDecimal("1230.20"))));
        return "products";
    }

    @GetMapping("/create")
    public String createProduct() {
        return "productForm";
    }
}
