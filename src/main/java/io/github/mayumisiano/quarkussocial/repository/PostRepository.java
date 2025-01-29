package io.github.mayumisiano.quarkussocial.repository;

import io.github.mayumisiano.quarkussocial.config.LogConfig;
import io.github.mayumisiano.quarkussocial.domain.enums.Tag;
import io.github.mayumisiano.quarkussocial.domain.model.Post;
import io.github.mayumisiano.quarkussocial.domain.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class PostRepository implements PanacheRepository<Post> {
    private static final Logger LOG = LogConfig.getLogger(UserRepository.class);

    public Post create(String title, String content, Tag tag, User user) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setTag(tag);
        post.setCreatedAt(LocalDateTime.now());
        post.setUser(user);  
        persist(post);
        return post;
    }


    public List<Post> findByUser(User user) {
        try {
            return list("user", user);  // Using Panache's simplified query method
            // Alternative using JPQL:
            // return find("FROM Post WHERE user = ?1", user).list();
        } catch (Exception e) {
            LOG.error("Repository: Error fetching posts for user: {}", user.getId(), e);
            throw e;
        }
    }
}
