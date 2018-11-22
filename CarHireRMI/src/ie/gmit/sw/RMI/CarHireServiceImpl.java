package ie.gmit.sw.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CarHireServiceImpl extends UnicastRemoteObject implements CarHireService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected CarHireServiceImpl() throws RemoteException {
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
		System.out.println("Working");
		
		return null;
	}

}
