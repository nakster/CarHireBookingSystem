package ie.gmit.sw.Models;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Car implements Serializable{

	private static final long serialVersionUID = 1L;
	private int CarID;
	private String CarColour;
	private String CarModel;
	private Date PurchaseDate;
	
	public Car() {
		super();
	}
	
	public Car(int carID, String carColour, String carModel, Date purchaseDate) {
		super();
		CarID = carID;
		CarColour = carColour;
		CarModel = carModel;
		PurchaseDate = purchaseDate;
	}

	public int getCarID() {
		return CarID;
	}

	public void setCarID(int carID) {
		CarID = carID;
	}

	public String getCarColour() {
		return CarColour;
	}

	public void setCarColour(String carColour) {
		CarColour = carColour;
	}

	public String getCarModel() {
		return CarModel;
	}

	public void setCarModel(String carModel) {
		CarModel = carModel;
	}

	public Date getPurchaseDate() {
		return PurchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		PurchaseDate = purchaseDate;
	}
}