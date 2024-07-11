package it.corso;

import java.util.Set;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import it.corso.jwt.JWTTokenNeededFilter;
import jakarta.ws.rs.ApplicationPath;

@Component
@ApplicationPath("api")
public class JerseyConfig  extends ResourceConfig {

	public JerseyConfig() {
		
		        register(JWTTokenNeededFilter.class);
		        register(CorsFilter.class);
		packages("it.corso");
	}

	
	
}
