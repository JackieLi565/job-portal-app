package com.workwise.userservice.resource;

import com.google.gson.Gson;
import com.workwise.userservice.model.Candidate;
import com.workwise.userservice.repository.CandidateRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Optional;

@Path("/candidates")
public class CandidateResource {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCandidateById(@PathParam("id") String id) {
        try {
            Optional<Candidate> userOptional = CandidateRepository.findCandidateById(id);

            if (userOptional.isEmpty()) return Response.status(Response.Status.NOT_FOUND)
                    .entity("No Candidate Found")
                    .build();

            Candidate candidate = userOptional.get();
            Gson gson = new Gson();

            String jsonPayload = gson.toJson(candidate);
            return Response.ok().entity(jsonPayload).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.TEXT_PLAIN).entity(e.toString()).build();
        }
    }
}
