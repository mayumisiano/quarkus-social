package io.github.mayumisiano.quarkussocial.rest.DTO;

public record CreateUserRequest (
        String name,
        Integer age
) {}