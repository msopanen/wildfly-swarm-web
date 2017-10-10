package fi.mps.swarm.application.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class HelloController {
	@GET
	@Produces("application/json")
	public String get() {
		return "{\"value\":\"Hello\"}";
	}
}
