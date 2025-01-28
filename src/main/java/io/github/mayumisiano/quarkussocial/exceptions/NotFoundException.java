package io.github.mayumisiano.quarkussocial.exceptions;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import java.util.Map;

public class NotFoundException extends WebApplicationException {
    public NotFoundException(String message) {
        super(Response.status(Response.Status.NOT_FOUND)
                     .entity(Map.of("message", message))
                     .build());
    }
}