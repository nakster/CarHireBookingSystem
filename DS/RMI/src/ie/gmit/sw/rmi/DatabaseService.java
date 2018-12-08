package ie.gmit.sw.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.Model.Order;

public interface DatabaseService extends Remote {

	// this method reads all the orders
	public List<Order> read() throws RemoteException, SQLException;

	// update hire
	public void update(int orderId, int custId, int carId) throws RemoteException, SQLException;

	// delete hire
	public void delete(int id) throws RemoteException, SQLException;

	//this method here creates a booking 
	public void Create(int custId, int carId,String d) throws RemoteException,SQLException;
}
