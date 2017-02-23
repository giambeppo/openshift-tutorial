package it.eustema.microservizi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/ciao")
public class CiaoMondoEndpoint {

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("Ciao mondo!").build();
	}

}
