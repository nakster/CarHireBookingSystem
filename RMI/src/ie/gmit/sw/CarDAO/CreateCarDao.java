package ie.gmit.sw.CarDAO;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ie.gmit.sw.Model.Car;

public class CreateCarDao {
	
	private Connection conn;
	private PreparedStatement p = null;
	
	public CreateCarDao() throws SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carhire?useSSL=false", "root", "");
	}

	public void Create(Car c) throws RemoteException, SQLException {
		// get the current date
		System.out.println("inserting into mysql");
		System.out.println("car added: " + c.getCarBrand());

		String sql = "INSERT INTO CAR (CarColour, CarBrand, CarModel, PurchaseDate) values (?, ?, ?,curdate())";
		p = conn.prepareStatement(sql);
		p.setString(1, c.getCarColour());
		p.setString(2, c.getCarBrand());
		p.setString(3, c.getCarModel());
		p.execute();
		p.close();
		conn.close();
		System.out.println("Inserted");
	}
}
