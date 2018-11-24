package ie.gmit.sw.RMI;

//Import RMI :- To use Remote and RemoteExcpetion
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.Models.Order;

public interface CarHireService extends Remote{

	//====================These will need updating =================================
	//methods 
	//this method here creates a booking 
	public String Create(String s) throws RemoteException;
	//this methods reads all the hires 
	public List<Order> Read() throws RemoteException,Exception; 
	//update hire
	public String Update(String s) throws RemoteException;
	//delete hire 
	public void Delete(int id) throws RemoteException,SQLException;
	
}
