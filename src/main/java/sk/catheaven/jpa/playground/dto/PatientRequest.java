package sk.catheaven.jpa.playground.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class PatientRequest {

    @NotBlank
    @Pattern(regexp = "[\\w.]+@[\\w.]+\\.\\w{2,3}", message = "Invalid email address")
    String email;

    @Min(value = 0, message = "Age cannot be a negative number")
    @Max(value = 150, message = "Age is too high")
    Integer age;

    @NotNull
    @Size(min = 3, max = 300)
    List<String> favoriteCats;

    @AssertTrue
    Boolean isCatLover;
}
