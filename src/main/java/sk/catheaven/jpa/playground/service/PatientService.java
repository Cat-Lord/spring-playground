package sk.catheaven.jpa.playground.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.catheaven.jpa.playground.model.Patient;
import sk.catheaven.jpa.playground.repository.PatientRepository;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
