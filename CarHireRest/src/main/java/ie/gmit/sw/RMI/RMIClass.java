package ie.gmit.sw.RMI;

import java.rmi.Naming;
import java.util.List;

import ie.gmit.sw.Models.Customer;
import ie.gmit.sw.Models.Order;

public class RMIClass {
	private CarHireService ch;

	public RMIClass() throws Exception {
		ch = (CarHireService) Naming.lookup("rmi://127.0.0.1:1099/databaseService");

	}

	// ============== READ ====================
	public List<Order> readData() throws Exception {
		return ch.Read();
	}
	public List<Customer> readCustomer() throws Exception {
		return ch.ReadCust();
	}
	
	public void delete(int id) throws Exception {
		ch.Delete(id);
	}
	
	public void create(int OrderNum, String d, int custId, int carId) throws Exception {
		ch.Create(OrderNum,d,custId,carId);
	}
}
