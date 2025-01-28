package io.github.mayumisiano.quarkussocial.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.Logger;
import io.github.mayumisiano.quarkussocial.config.LogConfig;

import java.util.Map;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {
    private static final Logger LOG = LogConfig.getLogger(ExceptionHandler.class);

    @Override
    public Response toResponse(Exception exception) {
        LOG.error("An error occurred: ", exception);

        if (exception instanceof NotFoundException) {
            return Response.status(Response.Status.NOT_FOUND)
                         .entity(Map.of("message", exception.getMessage()))
                         .build();
        }

        if (exception instanceof IllegalArgumentException) {
            return Response.status(Response.Status.BAD_REQUEST)
                         .entity(Map.of("message", exception.getMessage()))
                         .build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                     .entity(Map.of("message", "An unexpected error occurred"))
                     .build();
    }
}