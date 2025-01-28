package io.github.mayumisiano.quarkussocial.rest.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateUserRequest(
        
    @NotBlank(message = "Name is required")
    String name,
    
    @NotNull(message = "Age is required")
    @Positive(message = "Age must be greater than zero")
    Integer age
) {}