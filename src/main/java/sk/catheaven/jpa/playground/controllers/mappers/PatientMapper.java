package sk.catheaven.jpa.playground.controllers.mappers;

import sk.catheaven.jpa.playground.dto.PatientRequest;
import sk.catheaven.jpa.playground.dto.PatientResponse;
import sk.catheaven.jpa.playground.model.Patient;

public class PatientMapper implements ModelMapper<Patient, PatientRequest, PatientResponse> {

    @Override
    public Patient toModel(Patient original, PatientRequest patientRequest) {
        var patient = toModel(patientRequest);
        patient.setId(original.getId());
        patient.setFirstName(original.getFirstName());
        patient.setLastName(original.getLastName());
        return patient;
    }

    @Override
    public Patient toModel(PatientRequest patientRequest) {
        return Patient.builder()
                .email(patientRequest.getEmail())
                .age(patientRequest.getAge())
                .favoriteCats(patientRequest.getFavoriteCats())
                .isCatLover(patientRequest.getIsCatLover())
                .ssn(patientRequest.getSsn())
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
