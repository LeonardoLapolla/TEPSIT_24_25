package it.html.tutorial.library.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/test") // Accessibile su /api/test
public class Test {

    @GET
    @Path("{name}")  // Accetta un parametro nella URL
    public String test(@PathParam("name") String name) {
        return "Ciao " + name.toUpperCase();
    }
}
