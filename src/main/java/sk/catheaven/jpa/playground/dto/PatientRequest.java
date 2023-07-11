package sk.catheaven.jpa.playground.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
}
