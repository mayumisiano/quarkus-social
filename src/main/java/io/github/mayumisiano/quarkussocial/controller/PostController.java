package io.github.mayumisiano.quarkussocial.controller;

import io.github.mayumisiano.quarkussocial.domain.DTO.request.CreatePostRequest;
import io.github.mayumisiano.quarkussocial.domain.DTO.response.PostDetails;
import io.github.mayumisiano.quarkussocial.service.PostService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
        import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users/{userId}/posts")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostController {

    private final PostService postService;

    @Inject
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @POST
    public Response savePost(@PathParam("userId") String userId, CreatePostRequest createPostRequest) {
        PostDetails post = postService.savePost(userId, createPostRequest);
        return Response.status(Response.Status.CREATED).entity(post).build();
    }
}
