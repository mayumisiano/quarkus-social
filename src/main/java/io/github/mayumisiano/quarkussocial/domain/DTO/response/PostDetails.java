package io.github.mayumisiano.quarkussocial.domain.DTO.response;

import java.time.LocalDateTime;

public record PostDetails(
        String id,
        String title,
        String content,
        String tag,
        LocalDateTime createdAt
) {
}
