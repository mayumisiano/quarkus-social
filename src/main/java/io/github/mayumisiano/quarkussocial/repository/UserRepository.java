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
        User user = new User();
        user.setName(name);
        user.setAge(age);
        
        persist(user);

        return user;
    }

    public List<User> listAll() {
        try {
            List<User> users = findAll().list();
            return users;
        } catch (Exception e) {
            LOG.error("Repository: Error fetching users", e);
            throw e;
        }
    }

    public boolean deleteById(Long id) {
        return delete("id", id) > 0;
    }

    public boolean updateUser(Long id, User user) {
        return update("id", id, user) > 0;
    }
} 