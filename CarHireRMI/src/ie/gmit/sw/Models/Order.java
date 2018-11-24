package ie.gmit.sw.Models;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	private int OrderID;
	private int OrderNumber;
	private Date Date;
	private int cust;
	private int car;
	
	public Order() {
		super();
	}

	public Order(int orderID, int orderNumber, Date date, int customers,int cars) {
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
	
}