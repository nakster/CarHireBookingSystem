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
	private int cust;
	private int car;

	@XmlElement(name = "order")
	private List<Order> orders = null;

	public Order() {
		super();
	}

	public Order(int orderID, Date date, int customers, int cars) {
		super();
		OrderID = orderID;
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

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public int getCust() {
		return cust;
	}

	public void setCust(int cust) {
		this.cust = cust;
	}

	public int getCar() {
		return car;
	}

	public void setCar(int car) {
		this.car = car;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}