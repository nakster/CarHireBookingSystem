package ie.gmit.sw.RestJersey.Customer;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Model.Customer;
import ie.gmit.sw.rmi.RMIClass;

@Path("createCust")
public class CreateCust {

	//create an instance od the rmi class 
	private RMIClass r;

	//create a customer
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Customer getBothRequest(Customer s) throws Exception {

		System.out.println("Order added custID : " + s.getFirstName());
		r = new RMIClass();
//		r.create(s.getCustomer().getCustID(), s.getCar().getCarID());
		r.createCust(s);
		return s;
	}
}