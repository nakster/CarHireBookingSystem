package ie.gmit.sw.RestJersey.Car;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.Model.Car;
import ie.gmit.sw.rmi.RMIClass;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("readCar")
public class ReadCar {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 * @throws Exception
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	//reads all the car objects 
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getIt() throws MalformedURLException, RemoteException, Exception {

		RMIClass r = new RMIClass();
		List<Car> orders =  r.readCar();
		
		final GenericEntity <List<Car>> en = new GenericEntity<List<Car>>(orders) {};
		
		return Response.status(200).entity(en).build();
	}
	
}
