package lt.codeacademy.eshop.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "company")
public class CompanyInfo {

    private String name;
    private String address = "Default address";
    private String iban = "LT123456789";
}
