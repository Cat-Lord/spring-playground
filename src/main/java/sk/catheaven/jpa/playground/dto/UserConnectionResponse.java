package sk.catheaven.jpa.playground.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * User can:
 * - log in
 * - sign up
 */
@Getter
@Builder
@ToString
@JsonInclude(NON_NULL)
public class UserConnectionResponse {
    Long id;
    String email;
    String password;
    @Nullable
    LocalDate birth;
}
