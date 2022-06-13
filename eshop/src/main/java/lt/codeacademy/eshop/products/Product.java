package lt.codeacademy.eshop.products;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Product {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
}
