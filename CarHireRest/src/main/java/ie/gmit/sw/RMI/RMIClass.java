package ie.gmit.sw.RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class RMIClass {
	
	private CarHireService ch;
	
	public RMIClass() throws Exception {
		ch = (CarHireService) Naming.lookup("rmi://127.0.0.1:1099/databaseService");
		
	}
	
	public void getService() {
		try {
			ch.Read();
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
	}
}
