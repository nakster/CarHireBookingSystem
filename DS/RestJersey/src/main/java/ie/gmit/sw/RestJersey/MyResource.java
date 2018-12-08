package ie.gmit.sw.RestJersey;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Model.Order;
import ie.gmit.sw.rmi.RMIClass;

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
	 * @throws Exception
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Order> getIt() throws MalformedURLException, RemoteException, Exception {

		RMIClass r = new RMIClass();
		return r.read();
	}
	
	@Path("both")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void getBothRequest(Student s)
    {
        System.out.println("****Student Details*****");
        System.out.println("Student Name : "+s.getName());
        System.out.println("Student Age  : "+s.getAge());
    }
	
//	@POST
//	@Consumes(MediaType.APPLICATION_XML)
//	public Order d(Order o) {
//		System.out.println("In delte");
//		return o;
//	}
}
