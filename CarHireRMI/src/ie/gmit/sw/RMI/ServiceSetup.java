package ie.gmit.sw.RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceSetup {
	public static void main(String[] args) throws Exception {

		// Set an instance of DatabaseService
		CarHireService ds = new CarHireServiceImpl();

		// Start the RMI registry on port 1099
		LocateRegistry.createRegistry(1099);

		// Bind our remote object to the registry with the human-readable name
		Naming.rebind("databaseService", ds);

		// Print a nice message to standard output
		System.out.println("Server ready.");
	}

}
