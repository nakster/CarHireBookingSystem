package ie.gmit.sw.DAO;

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

public class ReadDao {
	private Connection conn;
	private Statement stmt;
	private List<Order> orderList;

	public ReadDao() throws SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carhire?useSSL=false", "root", "");
	}

	public List<Order> read() throws SQLException {

		System.out.println("In read");

		// create connection
		stmt = conn.createStatement();
		// create a list to store the mysql objects
		orderList = new ArrayList<Order>();

		// prepare statement
		String strSelect = "select orderid , Date, \r\n"
				+ "c.CustID,c.FirstName,c.LastName,c.Mobile,c.Country,c.Email,\r\n"
				+ "ca.CarID, ca.CarColour, ca.CarBrand, ca.CarModel, ca.PurchaseDate\r\n" + "FROM Orders\r\n"
				+ "INNER JOIN Customers as c\r\n" + "ON Orders.CustID=c.CustID\r\n" + "INNER JOIN CAR as ca\r\n"
				+ "ON Orders.CarID=ca.CarID ORDER BY orderid";

		// execute the query
		ResultSet rset = stmt.executeQuery(strSelect);

		// this add the objects the the order class
		while (rset.next()) {
			// get the order class obkects
			int OrderID = rset.getInt("OrderID");
			Date Date = rset.getDate("Date");

			// get the customer class objects
			int cust = rset.getInt("c.CustID");
			String name = rset.getString("c.FirstName");
			String lname = rset.getString("c.LastName");
			int mobile = rset.getInt("c.Mobile");
			String country = rset.getString("c.Country");
			String email = rset.getString("c.Email");

			// get the car class objects
			int car = rset.getInt("ca.CarID");
			String carColour = rset.getString("ca.CarColour");
			String carBrand = rset.getString("ca.CarBrand");
			String carModel = rset.getString("ca.CarModel");
			Date purchaseDate = rset.getDate("ca.PurchaseDate");

			// this adds all the customer objects to the class in the constructor
			Customer c = new Customer(cust, name, lname, mobile, country, email);
			// this adds all the car objects to the class in the constructor
			Car ca = new Car(car, carColour, carBrand, carModel, purchaseDate);
			// this adds all the order objects to the class in the constructor
			Order s = new Order(OrderID, Date, ca, c);
			// this here adds the order object to the arraylist which is going to be sent to
			// the jersey project
			orderList.add(s);
		}
		
		conn.close();
		return orderList;
	}

}
