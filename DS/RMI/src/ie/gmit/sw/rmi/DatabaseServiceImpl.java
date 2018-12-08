package ie.gmit.sw.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.DAO.ReadDao;
import ie.gmit.sw.Model.Order;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	private static final long serialVersionUID = 1L;

	protected DatabaseServiceImpl() throws RemoteException, SQLException {
		super();
	}

	@Override
	public List<Order> read() throws RemoteException, SQLException {
		//here it sends all the order class objects to jersey
		ReadDao readDao = new ReadDao();
		return readDao.read();
	}

	@Override
	public void update(int orderId, int custId, int carId) throws RemoteException, SQLException {
		
	}

	@Override
	public void delete(int id) throws RemoteException, SQLException {
		
	}

	@Override
	public void Delete(int id) throws RemoteException, SQLException {
		
	}

}
