package ie.gmit.sw.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.Models.Car;
import ie.gmit.sw.Models.Customer;
import ie.gmit.sw.Models.Order;

public class CarHireServiceImpl extends UnicastRemoteObject implements CarHireService {

	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmt;

	protected CarHireServiceImpl() throws RemoteException, SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CARHIRE?useSSL=false", "root", "");
		stmt = conn.createStatement();
	}

	@Override
	public List<Order> Read() throws RemoteException, Exception {
		System.out.println("Working");

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
	public String Create(String s) throws RemoteException {
		return null;
	}

	@Override
	public String Update(String s) throws RemoteException {
		return null;
	}

	@Override
	public String Delete(String s) throws RemoteException {
		System.out.println("Working");

		return null;
	}

}
