package ie.gmit.sw.CarHireRest;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.Models.Order;
import ie.gmit.sw.RMI.RMIClass;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Order> getIt() throws Exception, RemoteException, NotBoundException {

		RMIClass r = new RMIClass();
		// return ch.Read();
		return r.readData();
	}

	@GET
	@Path("/delete/{value}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Order> calcSqrt(@PathParam("value") int value) throws Exception {
		
		RMIClass r = new RMIClass();
		r.delete(value);
		
		return r.readData();
	}
}
