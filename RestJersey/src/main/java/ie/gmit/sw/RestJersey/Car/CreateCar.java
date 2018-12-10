package ie.gmit.sw.RestJersey.Car;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Model.Car;
import ie.gmit.sw.rmi.RMIClass;

@Path("createCar")
public class CreateCar {

	//create an instance od the rmi class 
	private RMIClass r;

	////create a new car
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Car getBothRequest(Car s) throws Exception {

		System.out.println("Order added custID : " + s.getCarColour());
		r = new RMIClass();
		r.createCar(s);
		
		return s;
	}
}