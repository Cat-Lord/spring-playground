package sk.catheaven.jpa.playground.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import sk.catheaven.jpa.playground.controllers.validation.groups.OnLogin;
import sk.catheaven.jpa.playground.controllers.validation.groups.OnSignUp;

import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * User can:
 * - log in
 * - sign up
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserConnectionRequest {
    @NotNull(groups = {OnLogin.class, OnSignUp.class})
    @Email(groups = {OnLogin.class, OnSignUp.class})
    private String email;

    @NotNull(groups = {OnLogin.class, OnSignUp.class})
    @Pattern(groups = {OnLogin.class, OnSignUp.class},
            regexp = "[\\w!@#$%^&*(),.<>]{8,}",
            message = "Password must be at least 8 characters long.")
    private String password;

    @NotNull(groups = OnSignUp.class)
    @Null(groups = OnLogin.class)
    @Past(groups = OnSignUp.class)
    private LocalDate birth;

 /*
    //
    // Without validation groups
    //
    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "[\\w!@#$%^&*(),.<>]{8,}", message = "Password must be at least 8 characters long.")
    private String password;

    @NotNull
    @Past
    private LocalDate birth;
 */
}
