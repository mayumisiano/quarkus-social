package io.github.mayumisiano.quarkussocial.service.impl;

import io.github.mayumisiano.quarkussocial.config.LogConfig;
import io.github.mayumisiano.quarkussocial.domain.model.User;
import io.github.mayumisiano.quarkussocial.rest.DTO.CreateUserRequest;
import io.github.mayumisiano.quarkussocial.service.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;

@ApplicationScoped
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LogConfig.getLogger(UserServiceImpl.class);

    @Override
    public User createUser(CreateUserRequest request) {
        LOG.info("Creating user with name: {}", request.name());
        
        if (request.name() == null || request.name().trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        
        if (request.age() == null || request.age() < 0) {
            throw new IllegalArgumentException("Age must be a positive number");
        }

        User user = new User();
        user.setName(request.name());
        user.setAge(request.age());
        
        user.persist();
        LOG.info("User persisted with ID: {}", user.getId());
        
        return user;
    }
}
