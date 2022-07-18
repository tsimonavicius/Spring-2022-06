package lt.codeacademy.eshop.commons.controlleradvice;

import lt.codeacademy.eshop.products.CompanyInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class CompanyInfoControllerAdvice {

    private final CompanyInfo companyInfo;

    public CompanyInfoControllerAdvice(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    @ModelAttribute("companyInfo")
    public CompanyInfo addCompanyDataToModel() {
        return companyInfo;
    }
}
