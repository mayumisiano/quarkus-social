package io.github.mayumisiano.quarkussocial.rest.DTO.response;

import java.util.List;

public record ListUserDetails(
    List<UserDetails> users
) {}
