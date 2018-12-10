package ie.gmit.sw.RestJersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Model.Order;
import ie.gmit.sw.rmi.RMIClass;

@Path("create")
public class CreateOrder {
	
	//create an instance od the rmi class 
	private RMIClass r;

	//this here creates a order
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Order getBothRequest(Order s) throws Exception {

		System.out.println("Order added custID : " + s.getCustomer().getCustID());
		r = new RMIClass();
		//send the order object to rmi
		r.create(s.getCustomer().getCustID(), s.getCar().getCarID());
		return s;
	}
}