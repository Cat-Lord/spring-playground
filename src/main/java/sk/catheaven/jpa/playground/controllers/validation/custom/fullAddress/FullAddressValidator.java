package sk.catheaven.jpa.playground.controllers.validation.custom.fullAddress;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import sk.catheaven.jpa.playground.model.Address;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.isNull;
import static org.apache.logging.log4j.util.Strings.isBlank;
import static sk.catheaven.jpa.playground.controllers.validation.custom.fullAddress.StateFormat.ANSI;
import static sk.catheaven.jpa.playground.controllers.validation.custom.fullAddress.StateFormat.ISO;

public class FullAddressValidator implements ConstraintValidator<FullAddress, Address> {

    private static final Map<StateFormat, Pattern> SUPPORTED_STATE_FORMAT_PATTERNS = Map.of(
            ANSI, Pattern.compile("^[A-Z]{3}$"),
            ISO, Pattern.compile("$[A-Z]{2}-[A-Z]{2}^")
    );

    private StateFormat stateFormat;

    @Override
    public void initialize(FullAddress constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.stateFormat = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Address address, ConstraintValidatorContext context) {
        if (isNull(address)) return false;
        if (isBlank(address.getName()) || isBlank(address.getCity())) return false;

        Matcher matcher = SUPPORTED_STATE_FORMAT_PATTERNS.get(stateFormat).matcher(address.getState());
        // if we want to be more specific instead of generic "Invalid address" message
        if (!matcher.matches()) {
            context.disableDefaultConstraintViolation();        // disable default behaviour
            context.buildConstraintViolationWithTemplate("Invalid State Name, please provide a valid state name")
                    .addPropertyNode("state")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
