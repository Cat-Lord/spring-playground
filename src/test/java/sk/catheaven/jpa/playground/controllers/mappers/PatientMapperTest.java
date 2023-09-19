package sk.catheaven.jpa.playground.controllers.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sk.catheaven.jpa.playground.dto.PatientResponse;
import sk.catheaven.jpa.playground.model.Patient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PatientMapperTest {
    @Autowired
    private PatientMapper patientMapper;

    @Test
    public void toResponseTest() {
        Patient patient = new Patient(
                123L,
                "First",
                "Last",
                "email@email.em",
                61,
                List.of("Eddie", "Kefir"),
                true,
                "ssn"
        );
        PatientResponse request = patientMapper.toResponse(patient);

        assertEquals(request.getId(), patient.getId());
        assertEquals(request.getAge(), patient.getAge());
        assertEquals(request.getFullName(), patient.getFirstName() + " " + patient.getLastName());
        assertEquals(request.getEmail(), patient.getEmail());
    }
}
