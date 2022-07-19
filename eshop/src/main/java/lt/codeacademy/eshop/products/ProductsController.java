package lt.codeacademy.eshop.products;

import lombok.AllArgsConstructor;
import lt.codeacademy.eshop.products.errors.ProductNotFoundException;
import lt.codeacademy.eshop.products.validations.CustomProductValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.UUID;

@AllArgsConstructor
@Controller
public class ProductsController {

    private final ProductsService productsService;
    private final CustomProductValidator productValidator;

    @InitBinder(value = "product")
    void initStudentValidator(WebDataBinder binder) {
        binder.addValidators(productValidator);
    }

    @GetMapping("/public/products")
    public String getProducts(@PageableDefault(size = 3) Pageable pageable, Model model) {

        Page<Product> products = productsService.getProducts(pageable);
        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping("/private/products/create")
    public String openProductForm(Model model) {

        model.addAttribute("product", new Product());
        return "productForm";
    }

    @PostMapping("/private/products/create")
    public String createProduct(@Valid Product product, BindingResult errors, RedirectAttributes redirectAttributes) {

        if (errors.hasErrors()) {
            return "productForm";
        }

        productsService.createProduct(product);

        redirectAttributes.addFlashAttribute("message",
                String.format("Product '%s' successfully created!", product.getName()));

        return "redirect:/products";
    }

    @GetMapping("/private/products/{id}")
    public String openProduct(@PathVariable UUID id, Model model) {

        model.addAttribute("product", productsService.getProduct(id));

        return "productForm";
    }

    @PostMapping("/private/products/{id}")
    public String updateProduct(Product product, Model model) {

        productsService.updateProduct(product);

        model.addAttribute("message", String.format("Product '%s' successfully updated!", product.getName()));

        return getProducts(null, model);
    }

    @PostMapping("/private/products/{id}/delete")
    public String deleteProduct(@PathVariable UUID id, RedirectAttributes redirectAttributes) {

        Product product = productsService.deleteProduct(id);

        redirectAttributes.addAttribute("message", String.format("Product '%s' successfully deleted!", product.getName()));

        return "redirect:/products";
    }

    @GetMapping("/public/products/search")
    public String search(@RequestParam(required = false) String name, Model model) {

        model.addAttribute("products",
                productsService.search(name));

        return "products";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public String productNotFound(ProductNotFoundException e, Model model) {

        model.addAttribute("messageCode", e.getMessage());
        model.addAttribute("productId", e.getProductId());

        return "error/productNotFoundPage";
    }
}
