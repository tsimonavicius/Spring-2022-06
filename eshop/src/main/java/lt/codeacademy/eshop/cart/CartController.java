package lt.codeacademy.eshop.cart;

import lombok.AllArgsConstructor;
import lt.codeacademy.eshop.products.Product;
import lt.codeacademy.eshop.products.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

@AllArgsConstructor
@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {

    private final ProductsService productsService;

    @ModelAttribute("cart")
    Cart initCart() {
        return new Cart();
    }

    @GetMapping
    public String getCart(Model model) {

        model.addAttribute("cart", new Cart(Arrays.asList(
                new Cart.CartItem(
                        new Product(
                                UUID.randomUUID(),
                                "Samsung",
                                "aaaa",
                                BigDecimal.valueOf(100),
                                ""),
                    2),
                new Cart.CartItem(
                        new Product(
                                UUID.randomUUID(),
                                "Iphone",
                                "aaaa",
                                BigDecimal.valueOf(250),
                                ""),
                        3)
        )));
        return "cart";
    }

    @PostMapping("/{id}")
    public String addToCart(@ModelAttribute Cart cart, @PathVariable UUID id) {

        cart.add(productsService.getProduct(id));

        return "redirect:/products";
    }
}
