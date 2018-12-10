package ie.gmit.sw.CustomerDAO;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ie.gmit.sw.Model.Customer;

public class CreateCustDao {
	
	private Connection conn;
	private PreparedStatement p = null;
	
	public CreateCustDao() throws SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carhire?useSSL=false", "root", "");
	}

	public void Create(Customer c) throws RemoteException, SQLException {
		// get the current date
		System.out.println("inserting into mysql");
		System.out.println("cust added: " + c.getFirstName() + c.getLastName());

		String sql = "INSERT INTO Customers (FirstName, LastName, Mobile, Country, Email) values (?, ?, ?,?,?)";
		p = conn.prepareStatement(sql);
		p.setString(1, c.getFirstName());
		p.setString(2, c.getLastName());
		p.setInt(3, c.getMobile());
		p.setString(4, c.getCountry());
		p.setString(5, c.getEmail());
		p.execute();
		p.close();
		conn.close();
		System.out.println("Inserted");
	}
}
