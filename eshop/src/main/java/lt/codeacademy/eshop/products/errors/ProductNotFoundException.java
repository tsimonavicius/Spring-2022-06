package lt.codeacademy.eshop.products.errors;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ProductNotFoundException extends RuntimeException {

    private final UUID productId;

    public ProductNotFoundException(String messageCode, UUID productId) {
        super(messageCode);
        this.productId = productId;
    }
}
