package ie.gmit.sw.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	private int OrderID;
	private Date Date;
	private Customer cust;
	private Car car;
	
	//for just displaying it in spring
	private String d;

	@XmlElement(name = "Order")
	private List<Order> orders = null;

	public Order() {
		super();
	}

	public Order(int orderID, java.util.Date date, Customer cust, Car car, String d) {
		super();
		OrderID = orderID;
		Date = date;
		this.cust = cust;
		this.car = car;
		this.d = d;
	}



	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
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