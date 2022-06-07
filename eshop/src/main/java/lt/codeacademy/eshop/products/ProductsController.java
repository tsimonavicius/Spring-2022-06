package lt.codeacademy.eshop.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static java.util.Collections.emptyList;

@Controller
public class ProductsController {

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", emptyList());
        return "products";
    }
}
