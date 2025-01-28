package io.github.mayumisiano.quarkussocial.service.impl;

import io.github.mayumisiano.quarkussocial.config.LogConfig;
import io.github.mayumisiano.quarkussocial.domain.model.User;
import io.github.mayumisiano.quarkussocial.exceptions.NotFoundException;
import io.github.mayumisiano.quarkussocial.rest.DTO.request.CreateUserRequest;
import io.github.mayumisiano.quarkussocial.rest.DTO.request.UpdateUserRequest;
import io.github.mayumisiano.quarkussocial.rest.DTO.response.ListUserDetails;
import io.github.mayumisiano.quarkussocial.rest.DTO.response.UserDetails;
import io.github.mayumisiano.quarkussocial.service.UserService;
import io.github.mayumisiano.quarkussocial.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LogConfig.getLogger(UserServiceImpl.class);
    
    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ListUserDetails getAllUsers() {
        List<User> users = userRepository.listAll();
        
        List<UserDetails> details = users.stream()
            .map(user -> {
                return new UserDetails(
                    user.getId().toString(),
                    user.getName(),
                    user.getAge());
            })
            .collect(Collectors.toList());
        
        return new ListUserDetails(details);
    }

    @Override
    public User createUser(CreateUserRequest request) {
        return userRepository.create(request.name(), request.age());
    }

    @Override
    @Transactional
    public void deleteUser(String id) throws NotFoundException {
        try {
            Long userId = Long.valueOf(id);

            boolean deleted = userRepository.deleteById(userId);
            if (!deleted) {
                LOG.error("User not found with id: {}", userId);
                throw new NotFoundException("User not found with id: " + id);
            }
            LOG.info("User deleted successfully");
        } catch (NumberFormatException e) {
            LOG.error("Invalid user id format: {}", id);
            throw new IllegalArgumentException("Invalid user id format: " + id);
        }
    }

    @Override
    @Transactional
    public void updateUser(String id, UpdateUserRequest userRequest) {
        try {
            Long userId = Long.valueOf(id);

            User user = userRepository.findByIdOptional(userId)
                .orElseThrow(() -> {
                    LOG.error("User not found with id: {}", userId);
                    throw new NotFoundException(String.format("User with ID %s was not found in the database", id));
                });
            
            user.setName(userRequest.name());
            user.setAge(userRequest.age());
            
            userRepository.persist(user);
            LOG.info("User updated successfully");
            
        } catch (NumberFormatException e) {
            LOG.error("Invalid user id format: {}", id);
            throw new IllegalArgumentException("Invalid user ID format. Please provide a valid numeric ID");
        }
    }
}
