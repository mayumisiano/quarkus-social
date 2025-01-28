package io.github.mayumisiano.quarkussocial.repository;

import io.github.mayumisiano.quarkussocial.domain.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import org.slf4j.Logger;
import io.github.mayumisiano.quarkussocial.config.LogConfig;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    private static final Logger LOG = LogConfig.getLogger(UserRepository.class);

    public User create(String name, Integer age) {
        LOG.info("Creating user with name: {}", name);
        
        User user = new User();
        user.setName(name);
        user.setAge(age);
        
        persist(user);
        LOG.info("User persisted with ID: {}", user.getId());
        
        return user;
    }

    public List<User> listAll() {
        LOG.info("Repository: Starting to fetch all users");
        try {
            List<User> users = findAll().list();
            LOG.info("Repository: Found {} users", users.size());
            return users;
        } catch (Exception e) {
            LOG.error("Repository: Error fetching users", e);
            throw e;
        }
    }
} 