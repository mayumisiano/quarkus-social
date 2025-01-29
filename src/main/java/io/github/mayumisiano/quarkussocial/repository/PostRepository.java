package io.github.mayumisiano.quarkussocial.repository;

import io.github.mayumisiano.quarkussocial.domain.model.Post;
import io.github.mayumisiano.quarkussocial.domain.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;

@ApplicationScoped
public class PostRepository implements PanacheRepository<Post> {

    public Post create(String title, String content, String tag, User user) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setTag(tag);
        post.setCreatedAt(LocalDateTime.now());
        post.setUser(user);  
        persist(post);
        return post;
    }
}
