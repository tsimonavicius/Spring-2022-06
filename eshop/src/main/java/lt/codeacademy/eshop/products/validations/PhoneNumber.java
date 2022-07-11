package lt.codeacademy.eshop.products.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumber {

    String message() default "{javax.validation.constraint.PhoneNumber.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    PhoneNumberType phoneNumberType() default PhoneNumberType.FULL;

    enum PhoneNumberType {
        FULL("+3706"),
        PART("86");

        private String numberPrefix;

        PhoneNumberType(String numberPrefix) {
            this.numberPrefix = numberPrefix;
        }

        public String getNumberPrefix() {
            return numberPrefix;
        }
    }
}

