package ie.gmit.sw.Consumes;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Order")
public class CreateOrderxml implements Serializable{

	private static final long serialVersionUID = 1L;
	@XmlElement(required = true)
	private int car;
	@XmlElement(required = true)
	private int customer;
	
	
	public CreateOrderxml() {
		super();
	}

	public CreateOrderxml(int car, int customer) {
		super();
		this.car = car;
		this.customer = customer;
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
