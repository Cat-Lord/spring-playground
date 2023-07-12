package sk.catheaven.jpa.playground.controllers.validation.custom.fullAddress;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = {FullAddressValidator.class})
public @interface FullAddress {
    String message() default "Address invalid or incomplete.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    StateFormat value();
}
