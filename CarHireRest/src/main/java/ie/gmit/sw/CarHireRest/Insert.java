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
	
	//private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@GET
	@Path("/{value1}/{value2}/{value3}")
	@Produces(MediaType.TEXT_HTML)
	public Response calcSqrt(@PathParam("value1") int value1,@PathParam("value2") int value2,@PathParam("value3") String value3) throws Exception {
		
		//String v = dateFormat.format(value1);
		RMIClass r = new RMIClass();
		r.create(value1, value2, value3);
		
		String msg = String.format("Order Made On : %s, Added With Customer Id: %s", value3, value1);    
		return Response.status(200).entity(msg).build();
	}
}
