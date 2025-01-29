package io.github.mayumisiano.quarkussocial.domain.DTO.response;

import java.util.List;

public record ListUserDetails(
    List<UserDetails> users
) {}
