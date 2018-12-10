package ie.gmit.sw.DAO;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateDao {

	// variables
	private Connection conn;
	private PreparedStatement p = null;
	// date
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();

	// make a connection
	public CreateDao() throws SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carhire?useSSL=false", "root", "");
	}

	//this creates a new order
	public void Create(int custId, int carId) throws RemoteException, SQLException {

		String d = dateFormat.format(date);

		// get the current date
		System.out.println("inserting into mysql");
		System.out.println("Date: " + d);
		System.out.println("custId: " + custId + " carID: " + carId);

		String sql = "insert into Orders(Date, CustID, CarID) values (?, ?, ?)";
		p = conn.prepareStatement(sql);
		p.setString(1, d);
		p.setInt(2, custId);
		p.setInt(3, carId);
		p.execute();
		p.close();
		conn.close();
		System.out.println("Inserted");
	}
}
