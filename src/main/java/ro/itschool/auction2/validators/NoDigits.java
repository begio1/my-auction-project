package ro.itschool.auction2.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = NoDigitsValidators.class)
public @interface NoDigits {
    String message() default "String cannot contain digits.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
