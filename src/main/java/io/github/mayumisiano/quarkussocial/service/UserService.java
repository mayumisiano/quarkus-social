package io.github.mayumisiano.quarkussocial.service;
import io.github.mayumisiano.quarkussocial.domain.model.User;
import io.github.mayumisiano.quarkussocial.rest.DTO.request.CreateUserRequest;
import io.github.mayumisiano.quarkussocial.rest.DTO.response.ListUserDetails;

public interface UserService {
    User createUser(CreateUserRequest userRequest);

    ListUserDetails getAllUsers();
}
