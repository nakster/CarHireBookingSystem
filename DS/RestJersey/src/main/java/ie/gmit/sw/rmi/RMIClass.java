package ie.gmit.sw.rmi;

import java.rmi.Naming;
import java.util.List;

import ie.gmit.sw.Model.Order;

public class RMIClass {

	private DatabaseService ch;

	public RMIClass() throws Exception {
		ch = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
	}

	// ============== READ ====================
	public List<Order> read() throws Exception {
		return ch.read();
	}

	// ============== Delete ====================
	public void delete(int id) throws Exception {
		ch.delete(id);

	}

	// ============== Update ====================
	public void update(int orderId, int custId, int carId) throws Exception {
		ch.update(orderId, custId, carId);
	}

	// =============== create ===================
	public void create(int custId, int carId) throws Exception {
		ch.create(custId, carId);
	}

}
