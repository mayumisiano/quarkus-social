package io.github.mayumisiano.quarkussocial.domain.DTO.response;

import io.github.mayumisiano.quarkussocial.domain.enums.Tag;

import java.time.LocalDateTime;

public record PostDetails(
        String id,
        String title,
        String content,
        Tag tag,
        LocalDateTime createdAt
) {
}
