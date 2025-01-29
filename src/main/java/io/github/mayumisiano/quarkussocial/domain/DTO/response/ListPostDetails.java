package io.github.mayumisiano.quarkussocial.domain.DTO.response;

import java.util.List;

public record ListPostDetails(
        List<PostDetails> posts
) {}
