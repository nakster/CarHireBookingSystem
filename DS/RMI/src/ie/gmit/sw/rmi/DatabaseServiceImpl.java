package ie.gmit.sw.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.DAO.DeleteDao;
import ie.gmit.sw.DAO.ReadDao;
import ie.gmit.sw.DAO.UpdateDao;
import ie.gmit.sw.Model.Order;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	private static final long serialVersionUID = 1L;
	private ReadDao readDao;
	private DeleteDao deleteDao;
	private UpdateDao updateDao;

	protected DatabaseServiceImpl() throws RemoteException, SQLException {
		super();
	}

	@Override
	public List<Order> read() throws RemoteException, SQLException {
		//here it sends all the order class objects to jersey
		readDao = new ReadDao();
		return readDao.read();
	}
	
	@Override
	public void delete(int id) throws RemoteException, SQLException {
		System.out.println("In delete");
		// the order will be deleted from mysql 
		deleteDao = new DeleteDao();
		deleteDao.deleteOrder(id);
	}

	@Override
	public void update(int orderId, int custId, int carId) throws RemoteException, SQLException {
		// This updates a object in mysql
		updateDao = new UpdateDao();
		updateDao.Update(orderId, custId, carId);
	}

	@Override
	public void Create(int custId, int carId, String d) throws RemoteException, SQLException {
		// TODO Auto-generated method stub
		
	}

}
