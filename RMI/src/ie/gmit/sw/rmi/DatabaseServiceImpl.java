package ie.gmit.sw.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.CarDAO.CreateCarDao;
import ie.gmit.sw.CarDAO.ReadCarDao;
import ie.gmit.sw.CustomerDAO.CreateCustDao;
import ie.gmit.sw.CustomerDAO.ReadCustDao;
import ie.gmit.sw.DAO.CreateDao;
import ie.gmit.sw.DAO.DeleteDao;
import ie.gmit.sw.DAO.ReadDao;
import ie.gmit.sw.DAO.UpdateDao;
import ie.gmit.sw.Model.Car;
import ie.gmit.sw.Model.Customer;
import ie.gmit.sw.Model.Order;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	//variables 
	private static final long serialVersionUID = 1L;
	private ReadDao readDao;
	private DeleteDao deleteDao;
	private UpdateDao updateDao;
	private CreateDao createDao;
	private CreateCustDao createCustDao;
	private CreateCarDao createCarDao;
	private ReadCustDao readCustDao;
	private ReadCarDao readCarDao;

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
	public void create(int custId, int carId) throws RemoteException, SQLException {
		
		//adds a new order
		createDao = new CreateDao();
		createDao.Create(custId, carId);
	}

	@Override
	public void createCust(Customer c) throws RemoteException, SQLException {
		//create new customer 
		createCustDao = new CreateCustDao();
		createCustDao.Create(c);
	}

	//creates a new car
	@Override
	public void createCar(Car c) throws RemoteException, SQLException {
		createCarDao = new CreateCarDao();
		createCarDao.Create(c);
	}

	// reads all the customers 
	@Override
	public List<Customer> readCust() throws RemoteException, SQLException {
		readCustDao = new ReadCustDao();
		return readCustDao.read();
	}

	//reads all the cars 
	@Override
	public List<Car> readCar() throws RemoteException, SQLException {
		readCarDao = new ReadCarDao();
		return readCarDao.read();
	}

}
