package lt.codeacademy.eshop.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class CompanyInfo {

    @Value("${name}")
    private String name;

    @Value("${address}")
    private String address;

    @Value("${iban: LT123456789}")
    private String iban;
}
