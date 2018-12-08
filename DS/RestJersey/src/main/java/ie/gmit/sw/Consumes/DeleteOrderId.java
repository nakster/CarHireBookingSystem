package ie.gmit.sw.Consumes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="Order")
public class DeleteOrderId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int orderId;
	
	
	public DeleteOrderId() {
		super();
	}

	public DeleteOrderId(int orderId) {
		super();
		this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
