package ie.gmit.sw.CarHireBookingSystem;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
public class DatabaseClient {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() throws Exception {
		// Ask the registry running on localhost and listening in port 1099 for the
		// instannce of
		// the MessageService object that is bound to the RMI registry with the name
		// howdayService.
		DatabaseService ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/databaseService");

		ds.Read();

		return "Got it!";
	}
}
