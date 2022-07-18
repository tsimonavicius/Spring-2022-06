package lt.codeacademy.eshop.cart;

import lt.codeacademy.eshop.products.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

@Controller
@RequestMapping("/cart")
public class CartController {

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
}
