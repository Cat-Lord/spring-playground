package sk.catheaven.jpa.playground.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.catheaven.jpa.playground.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
