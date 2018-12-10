package ie.gmit.sw.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.Model.Car;
import ie.gmit.sw.Model.Customer;
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

	// ================== Cust
	public void createCust(Customer c) throws Exception {
		ch.createCust(c);
	}

	public List<Customer> readCust() throws Exception {
		return ch.readCust();
	}

	public void createCar(Car s) throws RemoteException, SQLException {
		// TODO Auto-generated method stub
		ch.createCar(s);

	}

	public List<Car> readCar() throws Exception {
		return ch.readCar();
	}
}
