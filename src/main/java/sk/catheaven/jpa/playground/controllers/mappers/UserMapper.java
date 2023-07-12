package sk.catheaven.jpa.playground.controllers.mappers;

import sk.catheaven.jpa.playground.dto.UserConnectionRequest;
import sk.catheaven.jpa.playground.dto.UserConnectionResponse;
import sk.catheaven.jpa.playground.model.User;

import java.util.Optional;

public class UserMapper implements ModelMapper<User, UserConnectionRequest, UserConnectionResponse> {
    @Override
    public User toModel(User original, UserConnectionRequest userConnectionRequest) {
        var user = toModel(userConnectionRequest);
        var birth = Optional.ofNullable(userConnectionRequest.getBirth()).orElse(original.getBirth());
        user.setBirth(birth);
        return user;
    }

    @Override
    public User toModel(UserConnectionRequest userConnectionRequest) {
        return User.builder()
                .email(userConnectionRequest.getEmail())
                .password(userConnectionRequest.getPassword())
                .birth(userConnectionRequest.getBirth())
                .build();
    }

    @Override
    public UserConnectionResponse toResponse(User user) {
        return UserConnectionResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .birth(user.getBirth())
                .build();
    }
}
