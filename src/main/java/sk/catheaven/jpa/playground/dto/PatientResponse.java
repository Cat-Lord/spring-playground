package sk.catheaven.jpa.playground.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponse {
    Long id;
    String fullName;
    String email;
    Integer age;
}
