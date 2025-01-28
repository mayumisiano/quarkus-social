package io.github.mayumisiano.quarkussocial.service;
import io.github.mayumisiano.quarkussocial.domain.model.User;
import io.github.mayumisiano.quarkussocial.exceptions.NotFoundException;
import io.github.mayumisiano.quarkussocial.rest.DTO.request.CreateUserRequest;
import io.github.mayumisiano.quarkussocial.rest.DTO.request.UpdateUserRequest;
import io.github.mayumisiano.quarkussocial.rest.DTO.response.ListUserDetails;

public interface UserService {
    User createUser(CreateUserRequest userRequest);

    ListUserDetails getAllUsers();

    void deleteUser(String id) throws NotFoundException;

    void updateUser(String id, UpdateUserRequest userRequest);
}
