package ie.gmit.sw.CarDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ie.gmit.sw.Model.Car;

public class ReadCarDao {
	
	// Declared Variables 
	private Connection conn;
	private Statement stmt;
	private List<Car> orderList;
	// prepare statement
	String strSelect = "select * from car";

	//constructor to instaicate the connection 
	public ReadCarDao() throws SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carhire?useSSL=false", "root", "");
	}

	//method that returns list of order objects 
	public List<Car> read() throws SQLException {

		System.out.println("In read");

		// create connection
		stmt = conn.createStatement();
		// create a list to store the mysql objects
		orderList = new ArrayList<Car>();

		// execute the query
		ResultSet rset = stmt.executeQuery(strSelect);

		// this add the objects the the order class
		while (rset.next()) {
			
			int car = rset.getInt("CarID");
			String carColour = rset.getString("CarColour");
			String carBrand = rset.getString("CarBrand");
			String carModel = rset.getString("CarModel");
			Date purchaseDate = rset.getDate("PurchaseDate");

			// this adds all the car objects to the class in the constructor
			Car ca = new Car(car, carColour, carBrand, carModel, purchaseDate);
			
			
			orderList.add(ca);
		}

		stmt.close();
		conn.close();
		return orderList;
	}

}
