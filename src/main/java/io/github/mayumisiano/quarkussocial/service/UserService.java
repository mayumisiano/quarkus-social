package io.github.mayumisiano.quarkussocial.service;
import io.github.mayumisiano.quarkussocial.domain.model.User;
import io.github.mayumisiano.quarkussocial.rest.DTO.CreateUserRequest;

public interface UserService {
    User createUser(CreateUserRequest userRequest);
}