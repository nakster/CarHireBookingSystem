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
	private Customer customer;//these names have to be the same as in the xml format
	private Car car;// same here or it will not work 
	
//<orders>	 //@XmlRootElement(name = "orders")
//		<Order>
//			<OrderID>1</OrderID>
//			<Date>2018-11-25Z</Date>
//			<car>
//				<CarID>2</CarID>
//				<CarColour>red</CarColour>
//				<CarBrand>Ford Fiesta </CarBrand>
//				<CarModel>Fiesta</CarModel>
//				<PurchaseDate>2018-11-25Z</PurchaseDate>
//			</car>
//			<customer> //	private Customer customer;
//				<CustID>3</CustID>
//				<FirstName>Mark</FirstName>
//				<LastName>Healy</LastName>
//				<Mobile>896757835</Mobile>
//				<Country>Ireland</Country>
//				<Email>Mark@gmail.com</Email>
//			</customer>
//		</Order>
//</orders>	
	//for just displaying it in spring
	private String d;

	@XmlElement(name = "Order")
	private List<Order> orders = null;

	public Order() {
		super();
	}

	public Order(int orderID, java.util.Date date, Customer customer, Car car, String d) {
		super();
		OrderID = orderID;
		Date = date;
		this.customer = customer;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}