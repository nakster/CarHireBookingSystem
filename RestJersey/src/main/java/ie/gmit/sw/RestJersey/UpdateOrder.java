package ie.gmit.sw.RestJersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Model.Order;
import ie.gmit.sw.rmi.RMIClass;

@Path("update")
public class UpdateOrder {
	
	private RMIClass r ;
	
	
	@PUT
    @Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
    public Order getBothRequest(Order s) throws Exception
    {
        System.out.println("Order With ID : "+s.getOrderID()+ " Will be Updated");
        r = new RMIClass();
		r.update(s.getOrderID(), s.getCustomer().getCustID(), s.getCar().getCarID());
        return s;
    }
}
