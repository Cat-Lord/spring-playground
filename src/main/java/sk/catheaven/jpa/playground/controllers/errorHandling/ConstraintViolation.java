package sk.catheaven.jpa.playground.controllers.errorHandling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConstraintViolation {
    String fieldName;
    String message;
    String rejectedValue;
}
