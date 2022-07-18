package lt.codeacademy.eshop.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lt.codeacademy.eshop.products.Product;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class Cart {

    private final List<CartItem> items;

    public BigDecimal getSum() {
                // items = [ { totalPrice: 100 * 2 = 200 }, { totalPrice: 250 * 3 = 750 }, ... ]
        return items.stream()
                .map(CartItem::getTotalPrice) // [ 200, 750, ... ]
                .reduce(BigDecimal.ZERO, (total, cartItemPrice) -> {
                    System.out.println("--------------------------");
                    System.out.println("total: " + total);
                    System.out.println("cartItemPrice: " + cartItemPrice);

                    return total.add(cartItemPrice);
                });
                    // 0 + 1000 = 1000
                    //              +
                    //              150 = 1150
    }

    @Data
    public static class CartItem {
        private final Product product;
        private final int quantity;

        public BigDecimal getTotalPrice() {

            return product.getPrice()
                    .multiply(BigDecimal.valueOf(quantity));
        }
    }
}

