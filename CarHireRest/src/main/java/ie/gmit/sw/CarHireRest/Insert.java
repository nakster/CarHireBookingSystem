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
	@Path("/{value1}/{value2}/{value3}/{value4}")
	@Produces(MediaType.TEXT_HTML)
	public Response calcSqrt(@PathParam("value1") int value1,@PathParam("value2") String value2,@PathParam("value3") int value3,@PathParam("value4") int value4) throws Exception {
			
		RMIClass r = new RMIClass();
		r.create(value1, value2, value3, value4);
		
		String msg = String.format("Order Number ===>: %d, Added With Customer Id: %d", value1, value3);    
		return Response.status(200).entity(msg).build();
	}
}
