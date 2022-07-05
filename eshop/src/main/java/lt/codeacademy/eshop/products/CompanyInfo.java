package lt.codeacademy.eshop.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "company")
public class CompanyInfo {

    private String name;
    private String address = "Default address";

    private CompanyBankInfo bankInfo;

    private List<BigDecimal> list;
}

@Getter
@Setter
class CompanyBankInfo {

    private String bank;
    private String iban = "LT123456789";
}