package ie.gmit.sw.RestJersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Model.Order;

@Path("delete")
public class DeleteOrder {
	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Order del(Order o) throws Exception {	
		System.out.println(o);
		
		return o;
	}

}
