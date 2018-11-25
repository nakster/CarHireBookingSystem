package ie.gmit.sw.CarHireRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.RMI.RMIClass;

@Path("Create")
public class Insert {
	
	@GET
	@Path("/{value1}/{value2}/{value3}")
	@Produces(MediaType.TEXT_HTML)
	public Response calcSqrt(@PathParam("value1") String value1,@PathParam("value2") int value2,@PathParam("value3") int value3) throws Exception {
			
		RMIClass r = new RMIClass();
		r.create(value1, value2, value3);
		
		String msg = String.format("Order Number On : %d, Added With Customer Id: %d", value1, value3);    
		return Response.status(200).entity(msg).build();
	}
}
