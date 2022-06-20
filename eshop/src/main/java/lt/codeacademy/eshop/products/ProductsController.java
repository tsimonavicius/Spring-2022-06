package lt.codeacademy.eshop.products;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping
    public String getProducts(@RequestParam(required = false) Integer page, Model model) {

        Page<Product> products = productsService.getProducts(page);
        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping("/create")
    public String openProductForm(Model model) {

        model.addAttribute("product", new Product());
        return "productForm";
    }

    @PostMapping("/create")
    public String createProduct(Product product, Model model) {

        productsService.createProduct(product);

        model.addAttribute("message", String.format("Product '%s' successfully created!", product.getName()));
        model.addAttribute("products", productsService.getProducts(null));

        return "products";
    }

    @GetMapping("/{id}")
    public String openProduct(@PathVariable UUID id, Model model) {

        model.addAttribute("product", productsService.getProduct(id));

        return "productForm";
    }

    @PostMapping("/{id}")
    public String updateProduct(Product product, Model model) {

        productsService.updateProduct(product);

        model.addAttribute("message", String.format("Product '%s' successfully updated!", product.getName()));

        return getProducts(0, model);
    }

    @PostMapping("/{id}/delete")
    public String deleteProduct(@PathVariable UUID id, Model model) {

        Product product = productsService.deleteProduct(id);

        model.addAttribute("message", String.format("Product '%s' successfully deleted!", product.getName()));

        return getProducts(0, model);
    }

    @GetMapping("/search")
    public String search(@RequestParam(required = false) String name, Model model) {

        model.addAttribute("products",
                productsService.search(name));

        return "products";
    }
}
