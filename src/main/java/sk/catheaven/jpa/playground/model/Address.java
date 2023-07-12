package sk.catheaven.jpa.playground.model;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@Embeddable
@ToString
public class Address {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipCode;
}

