package sk.catheaven.jpa.playground.controllers.errorHandling;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import sk.catheaven.jpa.playground.dto.ErrorResponse;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice("sk.catheaven.jpa.playground")
public class PatientAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse handleUnexpectedErrors(Exception exception) {
        return ErrorResponse.builder()
                .title("Unexpected error occurred")
                .detail("Please, contact the administrator, if the error persists")
                .errorMessage(exception.getMessage())
                .build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleBadRequest(IllegalArgumentException exception) {
        return ErrorResponse.builder()
                .title("Data incorrect or missing")
                .detail("Make sure you filled in correct data")
                .errorMessage(exception.getMessage())
                .build();
    }

    // Hibernate validator exceptions (@isValid attributes didn't pass validation)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleInvalidRequest(MethodArgumentNotValidException invalidArgumentException) {
        var invalidArgsErrors = invalidArgumentException.getFieldErrors().stream().map(fieldError -> {
            var rejectedValue = Optional.ofNullable(fieldError.getRejectedValue())
                    .map(Object::toString)
                    .orElse(null);
            return ConstraintViolation.builder()
                    .fieldName(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .rejectedValue(rejectedValue)
                    .build();
        }).collect(Collectors.toList());

        return ErrorResponse.builder()
                .title("Found errors")
                .detail("Data contains error, please fix them and try again.")
                .validationErrors(invalidArgsErrors)
                .build();
    }
}
