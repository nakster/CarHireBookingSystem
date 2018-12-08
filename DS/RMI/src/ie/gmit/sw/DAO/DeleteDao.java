package ie.gmit.sw.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDao {
	
	private Connection conn;
	private PreparedStatement p = null;
	
	public DeleteDao() throws SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carhire?useSSL=false", "root", "");
	}

	public void deleteOrder(int id) throws SQLException {
		System.out.println("Delete from DataBase with ID " + id);
		
		p = conn.prepareStatement("Delete from orders where OrderID = ?");
		p.setInt(1, id);
		p.executeUpdate();
		
		p.close();
		System.out.println("Deleted");
		
	}

}
