package sk.catheaven.jpa.playground.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.catheaven.jpa.playground.model.Patient;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponse {
    Long id;
    String name;

    public static PatientResponse fromPatient(Patient patient) {
        return PatientResponse.builder()
                .id(patient.getId())
                .name(patient.getFullName())
                .build();
    }
}
