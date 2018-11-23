package ie.gmit.sw.CarHireRest;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Models.Order;
import ie.gmit.sw.RMI.RMIClass;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws NotBoundException 
     * @throws RemoteException 
     * @throws MalformedURLException 
     */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<Order> getIt() throws Exception, RemoteException, NotBoundException {
    	
		//CarHireService ch;
		//ch = (CarHireService) Naming.lookup("rmi://127.0.0.1:1099/databaseService");
		
    	RMIClass r = new RMIClass();
       // return ch.Read();
    	return r.getService();
    }
}
