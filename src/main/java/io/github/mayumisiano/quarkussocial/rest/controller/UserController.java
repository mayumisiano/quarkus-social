package io.github.mayumisiano.quarkussocial.rest.controller;

import io.github.mayumisiano.quarkussocial.domain.model.User;
import io.github.mayumisiano.quarkussocial.rest.DTO.request.CreateUserRequest;
import io.github.mayumisiano.quarkussocial.rest.DTO.request.UpdateUserRequest;
import io.github.mayumisiano.quarkussocial.rest.DTO.response.ListUserDetails;
import io.github.mayumisiano.quarkussocial.rest.DTO.response.UserDetails;
import io.github.mayumisiano.quarkussocial.service.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import io.github.mayumisiano.quarkussocial.config.LogConfig;
import java.util.Map;


@Path("/users")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    private static final Logger LOG = LogConfig.getLogger(UserController.class);

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(@Valid CreateUserRequest userRequest) {
        UserDetails userCreated = userService.createUser(userRequest);
        return Response.status(Response.Status.CREATED).entity(userCreated).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listUsers() {
        ListUserDetails users = userService.getAllUsers();
        return Response.ok(users).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") String id) {
        userService.deleteUser(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") String id, @Valid UpdateUserRequest userRequest) {
        UserDetails updatedUser = userService.updateUser(id, userRequest);
        return Response.ok(updatedUser).build();
    }
}
