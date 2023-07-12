package sk.catheaven.jpa.playground.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sk.catheaven.jpa.playground.controllers.mappers.ModelMapper;
import sk.catheaven.jpa.playground.dto.PatientRequest;
import sk.catheaven.jpa.playground.dto.PatientResponse;
import sk.catheaven.jpa.playground.model.Patient;
import sk.catheaven.jpa.playground.service.PatientService;

@RestController
@RequiredArgsConstructor
public class PatientController {

    private final ModelMapper<Patient, PatientRequest, PatientResponse> patientMapper;
    private final PatientService patientService;


    // we can keep the request body as plain string
    @PostMapping("/patients/raw")
    public ResponseEntity saveRawPatient(@RequestBody String patientRequest) {

        // manual parsing done here...

        System.out.println("Obtained patient request RAW: " + patientRequest);

        return ResponseEntity.ok(patientRequest);
    }

    // or we can guide spring towards our object that it will try to convert it into
    @PostMapping("/patients/new")
    public ResponseEntity<PatientResponse> saveNewPatient(@RequestBody @Valid PatientRequest patientRequest) {
        // at this point PatientRequest is parsed AND VALIDATED for us already
        System.out.println("Obtained patient request object: " + patientRequest);

        // convert and return something to the caller
        var patient = patientMapper.toModel(patientRequest);
        var savedPatient = patientService.savePatient(patient);
        return ResponseEntity.ok(patientMapper.toResponse(savedPatient));
    }
}
