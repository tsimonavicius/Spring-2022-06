package lt.codeacademy.eshop.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.eshop.products.validations.PhoneNumber;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @NotBlank
    @Size(min=3, max=50)
    private String name;

    @Size(max=255)
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    @PhoneNumber(phoneNumberType = PhoneNumber.PhoneNumberType.PART)
    private String phoneNumber;
}
