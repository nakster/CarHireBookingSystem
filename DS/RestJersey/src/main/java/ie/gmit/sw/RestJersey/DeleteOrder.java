package ie.gmit.sw.RestJersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Model.Order;
import ie.gmit.sw.rmi.RMIClass;

@Path("delete")
public class DeleteOrder {
	
	private RMIClass r ;
	
    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
    public Order getBothRequest(Order s) throws Exception
    {
        System.out.println("Order With ID : "+s.getOrderID()+ " Will be deleted");
        r = new RMIClass();
		r.delete(s.getOrderID());	
        return s;
    }
}
