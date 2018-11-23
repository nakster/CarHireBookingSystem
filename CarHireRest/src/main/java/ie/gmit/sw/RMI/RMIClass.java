package ie.gmit.sw.RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import ie.gmit.sw.Models.Order;

public class RMIClass {

	private CarHireService ch;

	public RMIClass() throws Exception {
		ch = (CarHireService) Naming.lookup("rmi://127.0.0.1:1099/databaseService");

	}

	public List<Order> getService() throws Exception {
		return ch.Read();
	}
}
