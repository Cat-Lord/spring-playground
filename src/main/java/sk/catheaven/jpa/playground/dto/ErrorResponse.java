package sk.catheaven.jpa.playground.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import sk.catheaven.jpa.playground.controllers.errorHandling.ConstraintViolation;

import java.util.Collection;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@Getter
@JsonInclude(NON_NULL)          // include only non-null fields
public class ErrorResponse {
    String title;
    String detail;
    String errorMessage;

    @Nullable
    Collection<ConstraintViolation> validationErrors;
}
