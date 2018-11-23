package ie.gmit.sw.Models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	private int OrderID;
	private int OrderNumber;
	private Date Date;
	private Customer cust;
	private Car car;
	
	public Order() {
		super();
	}

	public Order(int orderID, int orderNumber, Date date, Customer customers,Car cars) {
		super();
		OrderID = orderID;
		OrderNumber = orderNumber;
		Date = date;
		cust = customers;
		car = cars;
	}
	
	

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public int getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		OrderNumber = orderNumber;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
}
