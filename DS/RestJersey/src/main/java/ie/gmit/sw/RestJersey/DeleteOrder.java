package ie.gmit.sw.RestJersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Consumes.DeleteOrderId;
import ie.gmit.sw.rmi.RMIClass;

@Path("delete")
public class DeleteOrder {
	
	
	private RMIClass r ;
	
    @POST
    @Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
    public DeleteOrderId getBothRequest(DeleteOrderId s) throws Exception
    {
        System.out.println("Order With ID : "+s.getOrderId()+ " Will be deleted");
        r = new RMIClass();
		r.delete(s.getOrderId());	
        return s;
    }

}
