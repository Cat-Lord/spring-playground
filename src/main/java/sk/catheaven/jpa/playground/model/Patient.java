package sk.catheaven.jpa.playground.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Patient {
    Long id;
    String firstName;
    String lastName;
    String email;
    Integer age;
}
