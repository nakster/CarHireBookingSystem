package ie.gmit.sw.CarHireBookingSystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected DatabaseServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String Create(String s) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Read() throws RemoteException {
		System.out.println("Working");
		
	}

	@Override
	public String Update(String s) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Delete(String s) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
