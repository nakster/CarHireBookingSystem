package ie.gmit.sw.RestJersey;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.Model.Order;
import ie.gmit.sw.rmi.RMIClass;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("read")
public class ReadOrder {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 * @throws Exception
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getIt() throws MalformedURLException, RemoteException, Exception {

		RMIClass r = new RMIClass();
		List<Order> orders =  r.read();
		
		final GenericEntity <List<Order>> en = new GenericEntity<List<Order>>(orders) {};
		
		return Response.status(200).entity(en).build();
	}
	
}
