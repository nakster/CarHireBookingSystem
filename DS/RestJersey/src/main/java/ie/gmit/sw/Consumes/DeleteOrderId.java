package ie.gmit.sw.Consumes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Order")
public class DeleteOrderId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "OrderID")
	private int orderID;

	public DeleteOrderId() {
		super();
	}

	public DeleteOrderId(int orderID) {
		super();
		this.orderID = orderID;
	}

	public int getOrderId() {
		return orderID;
	}

	public void setOrderId(int orderID) {
		this.orderID = orderID;
	}
}
