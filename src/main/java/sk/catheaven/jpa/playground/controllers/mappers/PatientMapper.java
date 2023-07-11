package sk.catheaven.jpa.playground.controllers.mappers;

import sk.catheaven.jpa.playground.dto.PatientRequest;
import sk.catheaven.jpa.playground.dto.PatientResponse;
import sk.catheaven.jpa.playground.model.Patient;

public class PatientMapper implements ModelMapper<Patient, PatientRequest, PatientResponse> {

    @Override
    public Patient toModel(Patient original, PatientRequest patientRequest) {
        return Patient.builder()
                .id(original.getId())
                .firstName(original.getFirstName())
                .lastName(original.getLastName())
                .email(patientRequest.getEmail())
                .age(patientRequest.getAge())
                .build();
    }

    @Override
    public PatientResponse toResponse(Patient patient) {
        return PatientResponse.builder()
                .id(patient.getId())
                .fullName(patient.getFirstName() + ' ' + patient.getLastName())
                .email(patient.getEmail())
                .age(patient.getAge())
                .build();
    }
}
