package io.github.mayumisiano.quarkussocial.service;
import io.github.mayumisiano.quarkussocial.exceptions.NotFoundException;
import io.github.mayumisiano.quarkussocial.domain.DTO.request.CreateUserRequest;
import io.github.mayumisiano.quarkussocial.domain.DTO.request.UpdateUserRequest;
import io.github.mayumisiano.quarkussocial.domain.DTO.response.ListUserDetails;
import io.github.mayumisiano.quarkussocial.domain.DTO.response.UserDetails;

public interface UserService {
    UserDetails createUser(CreateUserRequest userRequest);

    ListUserDetails getAllUsers();

    void deleteUser(String id) throws NotFoundException;

    UserDetails updateUser(String id, UpdateUserRequest userRequest);
}
