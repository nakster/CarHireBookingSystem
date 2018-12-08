package ie.gmit.sw.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ie.gmit.sw.Model.Car;
import ie.gmit.sw.Model.Customer;
import ie.gmit.sw.Model.Order;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmt;

	protected DatabaseServiceImpl() throws RemoteException, SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carhire?useSSL=false", "root", "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Order> read() throws RemoteException, SQLException {
		System.out.println("In read");

		stmt = conn.createStatement();

		List<Order> orderList = new ArrayList<Order>();
		List<Customer> custList = new ArrayList<Customer>();
		List<Car> carList = new ArrayList<Car>();
	
		String strSelect = "select orderid , Date, \r\n" + 
				"c.CustID,c.FirstName,c.LastName,c.Mobile,c.Country,c.Email,\r\n" + 
				"ca.CarID, ca.CarColour, ca.CarBrand, ca.CarModel, ca.PurchaseDate\r\n" + 
				"FROM Orders\r\n" + 
				"INNER JOIN Customers as c\r\n" + 
				"ON Orders.CustID=c.CustID\r\n" + 
				"INNER JOIN CAR as ca\r\n" + 
				"ON Orders.CarID=ca.CarID";

		ResultSet rset = stmt.executeQuery(strSelect);

		while (rset.next()) { 
			int OrderID = rset.getInt("OrderID");
			Date Date = rset.getDate("Date");
			
			int cust = rset.getInt("c.CustID");
			String name = rset.getString("c.FirstName");
			String lname = rset.getString("c.LastName");
			int mobile = rset.getInt("c.Mobile");
			String country = rset.getString("c.Country");
			String email = rset.getString("c.Email");

			
			int car = rset.getInt("ca.CarID");
			String carColour = rset.getString("ca.CarColour");
			String carBrand = rset.getString("ca.CarBrand");
			String carModel = rset.getString("ca.CarModel");
			Date purchaseDate = rset.getDate("ca.PurchaseDate");
			
			Customer c = new Customer(cust,name,lname,mobile,country,email);
			
			Car ca = new Car(car, carColour,carBrand,carModel,purchaseDate);
		
			Order s = new Order(OrderID, Date,ca, c);
			orderList.add(s);
		}
		return orderList;
	}

}
