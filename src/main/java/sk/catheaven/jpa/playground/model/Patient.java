package sk.catheaven.jpa.playground.model;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class Patient {
    Long id;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z']+", message = "Invalid last name")
    String firstName;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z']+", message = "Invalid last name")
    String lastName;

    @NotBlank
    @Email
    String email;

    @Min(value = 0, message = "Age cannot be a negative number, minimum is {value}")
    @Max(value = 150, message = "Age is too high, at most {value} years is allowed")
    Integer age;

    @NotNull
    @Size(min = 3, max = 300)
    List<String> favoriteCats;

    @AssertTrue
    Boolean isCatLover;
}
