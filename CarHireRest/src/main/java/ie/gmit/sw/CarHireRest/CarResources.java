package ie.gmit.sw.CarHireRest;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Models.Car;
import ie.gmit.sw.RMI.RMIClass;

@Path("car")
public class CarResources {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Car> getIt() throws Exception, RemoteException, NotBoundException {

		RMIClass r = new RMIClass();
		return r.readCars();
	}
}
