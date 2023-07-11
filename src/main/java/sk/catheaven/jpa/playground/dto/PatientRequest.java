package sk.catheaven.jpa.playground.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PatientRequest {
    String email;
    Integer age;
}
