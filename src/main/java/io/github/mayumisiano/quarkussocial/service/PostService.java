package io.github.mayumisiano.quarkussocial.service;

import io.github.mayumisiano.quarkussocial.domain.DTO.request.CreatePostRequest;
import io.github.mayumisiano.quarkussocial.domain.DTO.response.PostDetails;

public interface PostService {

    PostDetails savePost(String userId, CreatePostRequest createPostRequest);
}
