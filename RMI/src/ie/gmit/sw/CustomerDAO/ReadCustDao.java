package ie.gmit.sw.CustomerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.Model.Customer;

public class ReadCustDao {
	
	// Declared Variables 
	private Connection conn;
	private Statement stmt;
	private List<Customer> orderList;
	// prepare statement
	String strSelect = "select * from customers";

	//constructor to instaicate the connection 
	public ReadCustDao() throws SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carhire?useSSL=false", "root", "");
	}

	//method that returns list of order objects 
	public List<Customer> read() throws SQLException {

		System.out.println("In read");

		// create connection
		stmt = conn.createStatement();
		// create a list to store the mysql objects
		orderList = new ArrayList<Customer>();

		// execute the query
		ResultSet rset = stmt.executeQuery(strSelect);

		// this add the objects the the order class
		while (rset.next()) {
			
			// get the customer class objects
			int cust = rset.getInt("CustID");
			String name = rset.getString("FirstName");
			String lname = rset.getString("LastName");
			int mobile = rset.getInt("Mobile");
			String country = rset.getString("Country");
			String email = rset.getString("Email");

			// this adds all the customer objects to the class in the constructor
			Customer c = new Customer(cust, name, lname, mobile, country, email);
			// this adds all the car objects to the class in the constructor
		
			orderList.add(c);
		}

		stmt.close();
		conn.close();
		return orderList;
	}

}
