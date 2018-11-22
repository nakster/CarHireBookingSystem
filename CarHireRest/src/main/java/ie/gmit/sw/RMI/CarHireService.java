package ie.gmit.sw.RMI;

//Import RMI :- To use Remote and RemoteExcpetion
import java.rmi.*;

public interface CarHireService extends Remote{

	//====================These will need updating =================================
	//methods 
	//this method here creates a booking 
	public String Create(String s) throws RemoteException;
	//this methods reads all the hires 
	public void Read() throws RemoteException; 
	//update hire
	public String Update(String s) throws RemoteException;
	//delete hire 
	public String Delete(String s) throws RemoteException;
}
