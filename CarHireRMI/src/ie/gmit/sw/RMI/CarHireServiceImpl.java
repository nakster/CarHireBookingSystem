package ie.gmit.sw.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ie.gmit.sw.Models.Car;
import ie.gmit.sw.Models.Customer;
import ie.gmit.sw.Models.Order;

public class CarHireServiceImpl extends UnicastRemoteObject implements CarHireService {

	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmt;
	private PreparedStatement p = null;

	protected CarHireServiceImpl() throws RemoteException, SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CARHIRE?useSSL=false", "root", "");
	}

	@Override
	public List<Order> Read() throws RemoteException, Exception {
		System.out.println("Reading the DataBase");

		stmt = conn.createStatement();
		List<Order> List = new ArrayList<Order>();

		String strSelect = "select * from orders ORDER BY OrderID";

		ResultSet rset = stmt.executeQuery(strSelect);

		while (rset.next()) { // Move the cursor to the next row, return false if no more row

			int OrderID = rset.getInt("OrderID");
			Date Date = rset.getDate("Date");
			int cust = rset.getInt("CustID");
			int car = rset.getInt("CarID");

			Order s = new Order(OrderID, Date, cust, car);
			List.add(s);
		}
		return List;
	}
	
	@Override
	public void Delete(int id) throws RemoteException, SQLException {
		System.out.println("Delete from DataBase with ID " + id);
		
		p = conn.prepareStatement("Delete from orders where OrderID = ?");
		p.setInt(1, id);
		p.executeUpdate();
		
		p.close();
		System.out.println("Deleted");
		
	}

	@Override
	public void Create(int custId, int carId,String d) throws RemoteException, SQLException {
		//get the current date 
		System.out.println("inserting into mysql");
		System.out.println("Date: " + d);
		System.out.println("custId: " + custId + " carID: " + carId);
		
//		INSERT INTO Orders (OrderNumber, Date, CustID, CarID)
//		VALUES (7839,CURDATE(),1,1),
		
		String sql = "insert into Orders(Date, CustID, CarID) values (?, ?, ?)";
		p = conn.prepareStatement(sql);
		p.setString(1, d);
		p.setInt(2, custId);
		p.setInt(3, carId);
		p.execute();
		p.close();
		System.out.println("Inserted");
	}

	@Override
	public void Update(String s) throws RemoteException {
		
	}

	@Override
	public List<Customer> ReadCust() throws RemoteException, Exception {
		System.out.println("Reading Customers the DataBase");

		stmt = conn.createStatement();
		List<Customer> List = new ArrayList<Customer>();

		String strSelect = "select * from customers";

		ResultSet rset = stmt.executeQuery(strSelect);

		while (rset.next()) { // Move the cursor to the next row, return false if no more row

			int CustID = rset.getInt("CustID");
			String FirstName = rset.getString("FirstName");
			String LastName = rset.getString("LastName");
			int Mobile = rset.getInt("Mobile");
			String Country = rset.getString("Country");
			String Email = rset.getString("Email");

			Customer s = new Customer(CustID,FirstName,LastName,Mobile,Country,Email);
			List.add(s);
		}
		return List;
	}

	@Override
	public List<Car> ReadCars() throws RemoteException, Exception {
		System.out.println("Reading the DataBase");

		stmt = conn.createStatement();
		List<Car> List = new ArrayList<Car>();

		String strSelect = "select * from car";

		ResultSet rset = stmt.executeQuery(strSelect);

		while (rset.next()) { // Move the cursor to the next row, return false if no more row

			int CarID = rset.getInt("CarID");
			String CarColour = rset.getString("CarColour");
			String CarBrand = rset.getString("CarBrand");
			String CarModel = rset.getString("CarModel");
			Date PurchaseDate = rset.getDate("PurchaseDate");
			
			Car s = new Car(CarID,CarColour,CarBrand,CarModel,PurchaseDate);
			List.add(s);
		}
		return List;
	}
}
