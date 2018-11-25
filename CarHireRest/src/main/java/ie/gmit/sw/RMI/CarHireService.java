package ie.gmit.sw.RMI;

//Import RMI :- To use Remote and RemoteExcpetion
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.Models.Car;
import ie.gmit.sw.Models.Car;
import ie.gmit.sw.Models.Customer;
import ie.gmit.sw.Models.Order;

public interface CarHireService extends Remote{

	//====================These will need updating =================================
	//methods 
	//this method here creates a booking 
	public void Create(int OrderNum, String d, int custId, int carId) throws RemoteException,SQLException;
	//this methods reads all the hires 
	public List<Order> Read() throws RemoteException,Exception; 
	//update hire
	public void Update(String s) throws RemoteException;
	//delete hire 
	public void Delete(int id) throws RemoteException,SQLException;
	
	//////////
	public List<Customer> ReadCust() throws RemoteException,Exception;
	public List<Car> ReadCars() throws RemoteException,Exception;
}
