package com.workwise.userservice.resource;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserResouce {
    @POST
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createUser(@QueryParam("type") String type, String body) {
        // TODO create a user based on recruiter or candidate
        System.out.println(body);
        if (type.equals("r")) {

        } else if (type.equals("c")) {

        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        // SignupEmailEvent.sendSignupEmail("li.jackie565@gmail.com");
        return Response.status(Response.Status.OK).build();
    }
}
