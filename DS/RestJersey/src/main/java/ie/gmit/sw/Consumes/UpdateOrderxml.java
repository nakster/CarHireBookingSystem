package ie.gmit.sw.Consumes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Order")
public class UpdateOrderxml implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "OrderID", required = true)
	private int orderID;
	@XmlElement(required = true)
	private int car;
	@XmlElement(required = true)
	private int customer;	
	
	public UpdateOrderxml() {
		super();
	}

	public UpdateOrderxml(int orderID, int customer, int car) {
		super();
		this.orderID = orderID;
		this.car = car;
		this.customer = customer;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public int getCar() {
		return car;
	}


	public void setCar(int car) {
		this.car = car;
	}


	public int getCustomer() {
		return customer;
	}


	public void setCustomer(int customer) {
		this.customer = customer;
	}

}
