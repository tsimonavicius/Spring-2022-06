package lt.codeacademy.eshop.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Arrays;

@Controller
public class ProductsController {

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products",
                Arrays.asList(new Product("iPhone 21", "This is a product description", new BigDecimal("1230.20"))));
        return "products";
    }
}
