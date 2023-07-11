package sk.catheaven.jpa.playground.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.catheaven.jpa.playground.dto.PatientRequest;
import sk.catheaven.jpa.playground.dto.PatientResponse;

@Controller
public class PatientController {

    // we can keep the request body as plain string
    @PostMapping("/patients/raw")
    public ResponseEntity saveRawPatient(@RequestBody String patientRequest) {

        // manual parsing done here...

        System.out.println("Obtained patient request RAW: " + patientRequest);

        return ResponseEntity.ok().build();
    }

    // or we can guide spring towards our object that it will try to convert it into
    @PostMapping("/patients/new")
    public ResponseEntity<PatientResponse> saveNewPatient(@RequestBody @Valid PatientRequest patientRequest) {

        // at this point PatientRequest is parsed AND VALIDATED for us already
        System.out.println("Obtained patient request object: " + patientRequest);

        return ResponseEntity.ok().build();
    }
}
