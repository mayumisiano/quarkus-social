package io.github.mayumisiano.quarkussocial.service.impl;

import io.github.mayumisiano.quarkussocial.config.LogConfig;
import io.github.mayumisiano.quarkussocial.domain.model.User;
import io.github.mayumisiano.quarkussocial.rest.DTO.request.CreateUserRequest;
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
}
