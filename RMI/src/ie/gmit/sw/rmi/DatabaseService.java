package ie.gmit.sw.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import ie.gmit.sw.Model.Car;
import ie.gmit.sw.Model.Customer;
import ie.gmit.sw.Model.Order;

public interface DatabaseService extends Remote {

	// this method reads all the orders
	public List<Order> read() throws RemoteException, SQLException;

	// update hire
	public void update(int orderId, int custId, int carId) throws RemoteException, SQLException;

	// delete hire
	public void delete(int id) throws RemoteException, SQLException;

	// this method here creates a booking
	public void create(int custId, int carId) throws RemoteException, SQLException;

	// this method here creates a customer
	public List<Customer> readCust() throws RemoteException, SQLException;
	public void createCust(Customer c) throws RemoteException, SQLException;

	// this method here creates a customer
	public void createCar(Car c) throws RemoteException, SQLException;
	public List<Car> readCar() throws RemoteException, SQLException;
}
