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

		String strSelect = "select * from orders";

		ResultSet rset = stmt.executeQuery(strSelect);

		while (rset.next()) { // Move the cursor to the next row, return false if no more row

			int OrderID = rset.getInt("OrderID");
			int OrderNumber = rset.getInt("OrderNumber");
			Date Date = rset.getDate("Date");
			int cust = rset.getInt("CustID");
			int car = rset.getInt("CarID");

			Order s = new Order(OrderID, OrderNumber, Date, cust, car);
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
	public String Create(String s) throws RemoteException {
		return null;
	}

	@Override
	public String Update(String s) throws RemoteException {
		return null;
	}

}
