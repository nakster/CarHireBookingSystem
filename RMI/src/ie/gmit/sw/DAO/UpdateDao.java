package ie.gmit.sw.DAO;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateDao {
	
	// variables
	private Connection conn;
	private PreparedStatement p = null;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();
	
	//make a connection
	public UpdateDao() throws SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carhire?useSSL=false", "root", "");
	}

	// this updates a order
	public void Update(int orderId, int custId, int carId) throws RemoteException, SQLException {
		String d = dateFormat.format(date);
		
		String sql = "update orders set CustID = ?,  CarID = ?, Date = ?  where OrderID = ?";
		p = conn.prepareStatement(sql);
		p.setInt(1, custId);
		p.setInt(2, carId);
		p.setString(3, d);
		p.setInt(4, orderId);
		p.execute();
		p.close();
		conn.close();
		System.out.println("Updated");
	}
}
