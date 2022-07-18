package lt.codeacademy.eshop.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lt.codeacademy.eshop.products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
public class Cart {

    private final List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public BigDecimal getSum() {
                // items = [ { totalPrice: 100 * 2 = 200 }, { totalPrice: 250 * 3 = 750 }, ... ]
        return items.stream()
                .map(CartItem::getTotalPrice) // [ 200, 750, ... ]
                .reduce(BigDecimal.ZERO, BigDecimal::add);
                    // 0 + 1000 = 1000
                    //              +
                    //              150 = 1150
    }

    public void add(Product product) {

        Optional<CartItem> item = items.stream()
                .filter(i -> i.getProduct().getId().equals(product.getId()))
                .findFirst();

        if (item.isPresent()) {
            item.get().increaseQuantity();
        } else {
            items.add(new CartItem(product));
        }
    }

    @Data
    public static class CartItem {
        private final Product product;
        private int quantity;

        public CartItem(Product product) {
            this(product, 1);
        }

        public CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public BigDecimal getTotalPrice() {

            return product.getPrice()
                    .multiply(BigDecimal.valueOf(quantity));
        }

        public void increaseQuantity() {
            this.quantity++;
        }
    }
}

