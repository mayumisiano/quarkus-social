package io.github.mayumisiano.quarkussocial.domain.DTO.request;

public record CreatePostRequest (
        String title,
        String content,
        String tag
) {}
