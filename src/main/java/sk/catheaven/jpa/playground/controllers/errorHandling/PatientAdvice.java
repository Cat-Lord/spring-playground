package sk.catheaven.jpa.playground.controllers.errorHandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import sk.catheaven.jpa.playground.dto.ErrorResponse;

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
}
