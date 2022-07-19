package lt.codeacademy.eshop.cart;

import lombok.AllArgsConstructor;
import lt.codeacademy.eshop.products.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@AllArgsConstructor
@Controller
@SessionAttributes("cart")
public class CartController {

    private final ProductsService productsService;

    @ModelAttribute("cart")
    Cart initCart() {
        return new Cart();
    }

    @GetMapping("/public/cart")
    public String getCart(@ModelAttribute Cart cart) {

        return "cart";
    }

    @PostMapping("/public/cart/{id}")
    public String addToCart(@ModelAttribute Cart cart, @PathVariable UUID id) {

        cart.add(productsService.getProduct(id));

        return "redirect:/products";
    }

    @PostMapping("/private/cart")
    public String order(@ModelAttribute Cart cart,
                        SessionStatus sessionStatus, RedirectAttributes redirectAttributes) {

        if (cart.hasItems()) {
            sessionStatus.setComplete();
            redirectAttributes.addAttribute("message", "cartPage.orderReceived");
            return "redirect:/products";
        }

        return "cart";
    }
}
