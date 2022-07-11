package lt.codeacademy.eshop.products.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private PhoneNumber.PhoneNumberType phoneNumberType;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        phoneNumberType = constraintAnnotation.phoneNumberType();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return PhoneNumber.PhoneNumberType.FULL.equals(phoneNumberType) ?
                isFullNumber(value) :
                isPartNumber(value);
    }

    private boolean isPartNumber(String value) {
        return value.length() == 9 && value.startsWith(PhoneNumber.PhoneNumberType.PART.getNumberPrefix());
    }

    private boolean isFullNumber(String value) {
        return value.length() == 12 && value.startsWith(PhoneNumber.PhoneNumberType.FULL.getNumberPrefix());
    }
}
