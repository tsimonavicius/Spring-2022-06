package lt.codeacademy.eshop.products.validations;

import lt.codeacademy.eshop.products.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Product product = (Product) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "phoneNumber.required");

        if (!product.getPhoneNumber().startsWith("+3706") &&
                !product.getPhoneNumber().startsWith("86")) {
            errors.rejectValue("phoneNumber", "phoneNumber.invalid",
                    new Object[] { product.getPhoneNumber() }, null);
        }
    }
}
