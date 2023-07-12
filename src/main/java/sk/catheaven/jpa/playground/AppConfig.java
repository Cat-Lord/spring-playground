package sk.catheaven.jpa.playground;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import sk.catheaven.jpa.playground.controllers.mappers.ModelMapper;
import sk.catheaven.jpa.playground.controllers.mappers.PatientMapper;
import sk.catheaven.jpa.playground.controllers.mappers.UserMapper;
import sk.catheaven.jpa.playground.dto.PatientRequest;
import sk.catheaven.jpa.playground.dto.PatientResponse;
import sk.catheaven.jpa.playground.dto.UserConnectionRequest;
import sk.catheaven.jpa.playground.dto.UserConnectionResponse;
import sk.catheaven.jpa.playground.model.Patient;
import sk.catheaven.jpa.playground.model.User;

@Configuration
@ComponentScan("sk.catheaven.jpa.playground")
@EntityScan("sk.catheaven.jpa.playground.model")
public class AppConfig {

    @Bean
    public ModelMapper<Patient, PatientRequest, PatientResponse> getPatientMapper() {
        return new PatientMapper();
    }

    @Bean
    public ModelMapper<User, UserConnectionRequest, UserConnectionResponse> getUserMapper() {
        return new UserMapper();
    }
}
