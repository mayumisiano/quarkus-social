package io.github.mayumisiano.quarkussocial.service.impl;

import io.github.mayumisiano.quarkussocial.config.LogConfig;
import io.github.mayumisiano.quarkussocial.domain.DTO.request.CreatePostRequest;
import io.github.mayumisiano.quarkussocial.domain.DTO.response.ListPostDetails;
import io.github.mayumisiano.quarkussocial.domain.DTO.response.PostDetails;
import io.github.mayumisiano.quarkussocial.domain.enums.Tag;
import io.github.mayumisiano.quarkussocial.domain.model.Post;
import io.github.mayumisiano.quarkussocial.domain.model.User;
import io.github.mayumisiano.quarkussocial.exceptions.NotFoundException;
import io.github.mayumisiano.quarkussocial.repository.PostRepository;
import io.github.mayumisiano.quarkussocial.repository.UserRepository;
import io.github.mayumisiano.quarkussocial.service.PostService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class PostServiceImpl implements PostService {
    private static final Logger LOG = LogConfig.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public PostServiceImpl(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public PostDetails savePost(String id, CreatePostRequest createPostRequest) {
        Long userId = Long.valueOf(id);
        User user = Optional.ofNullable(userRepository.findById(userId))
                .orElseThrow(() -> {
                    LOG.error("User not found with id: {}", userId);
                    return new NotFoundException("User not found with id: " + userId);
                });

        Post post = postRepository.create(createPostRequest.title(), 
                                        createPostRequest.content(),
                Tag.valueOf(createPostRequest.tag()),
                                        user);

        return new PostDetails(
                String.valueOf(post.getId()),
                post.getTitle(),
                post.getContent(),
                post.getTag(),
                post.getCreatedAt()
        );
    }

    @Override
    public ListPostDetails listPostsByUser(String userId) {
        Long id = Long.valueOf(userId);
        User user = Optional.ofNullable(userRepository.findById(id))
                .orElseThrow(() -> {
                    LOG.error("User not found with id: {}", userId);
                    return new NotFoundException("User not found with id: " + userId);
                });

        List<Post> posts = postRepository.findByUser(user);

        List<PostDetails> postDetails = posts.stream()
                .map(post -> new PostDetails(
                        String.valueOf(post.getId()),
                        post.getTitle(),
                        post.getContent(),
                        post.getTag(),
                        post.getCreatedAt()
                ))
                .collect(Collectors.toList());

        return new ListPostDetails(postDetails);
    }
}
