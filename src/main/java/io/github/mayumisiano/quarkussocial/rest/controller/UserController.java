package io.github.mayumisiano.quarkussocial.rest.controller;

import io.github.mayumisiano.quarkussocial.domain.model.User;
import io.github.mayumisiano.quarkussocial.rest.DTO.CreateUserRequest;
import io.github.mayumisiano.quarkussocial.service.UserService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;


@Path("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(@Valid CreateUserRequest userRequest) {
        User userCreated = userService.createUser(userRequest);
        return Response.status(Response.Status.CREATED).entity(userCreated).build();
    }

    @GET
    public Response listUsers() {
        return Response.ok().build();
    }
}
