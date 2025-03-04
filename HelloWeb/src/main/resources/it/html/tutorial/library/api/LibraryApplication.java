package it.html.tutorial.library.api;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")  // La base URL sarà http://localhost:8080/api
public class LibraryApplication extends ResourceConfig {
    public LibraryApplication() {
        packages("it.html.tutorial.library.api"); // Jersey cerca le API in questo package
    }
}

public class LibraryApplication {

}
