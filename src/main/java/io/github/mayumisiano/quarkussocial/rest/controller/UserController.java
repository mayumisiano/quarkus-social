package io.github.mayumisiano.quarkussocial.rest.controller;

import io.github.mayumisiano.quarkussocial.rest.DTO.CreateUserRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;


@Path("/users")
public class UserController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(CreateUserRequest user) {
        return Response.ok().build();
    }

    @GET
    public Response listUsers() {
        return Response.ok().build();
    }
}
