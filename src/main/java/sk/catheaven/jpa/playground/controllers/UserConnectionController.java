package sk.catheaven.jpa.playground.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sk.catheaven.jpa.playground.controllers.mappers.ModelMapper;
import sk.catheaven.jpa.playground.controllers.validation.groups.OnLogin;
import sk.catheaven.jpa.playground.controllers.validation.groups.OnSignUp;
import sk.catheaven.jpa.playground.dto.UserConnectionRequest;
import sk.catheaven.jpa.playground.dto.UserConnectionResponse;
import sk.catheaven.jpa.playground.model.User;

@RestController
@RequiredArgsConstructor
public class UserConnectionController {

    private final ModelMapper<User, UserConnectionRequest, UserConnectionResponse> userMapper;

    @PostMapping("/signup")
    public ResponseEntity<UserConnectionResponse> signUpUser(@RequestBody @Validated(OnSignUp.class) UserConnectionRequest userRequest) {
        System.out.println("Registering user in /signup: " + userRequest);
        User user = userMapper.toModel(userRequest);
        return ResponseEntity.ok(userMapper.toResponse(user));
    }

    @PostMapping("/login")
    public ResponseEntity<UserConnectionResponse> loginUser(@RequestBody @Validated(OnLogin.class) UserConnectionRequest userRequest) {
        System.out.println("Registering user in /signup: " + userRequest);
        User user = userMapper.toModel(userRequest);
        return ResponseEntity.ok(userMapper.toResponse(user));
    }
}
