package ie.gmit.sw.Models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 2438158765739915938L;
	private int CustID;
	private String FirstName;
	private String LastName;
	private int Mobile;
	private String Country;
	private String Email;

	public Customer() {
		super();
	}
	
	public Customer(int custID, String firstName, String lastName, int mobile, String country, String email) {
		super();
		CustID = custID;
		FirstName = firstName;
		LastName = lastName;
		Mobile = mobile;
		Country = country;
		Email = email;
	}

	public int getCustID() {
		return CustID;
	}

	public void setCustID(int custID) {
		CustID = custID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getMobile() {
		return Mobile;
	}

	public void setMobile(int mobile) {
		Mobile = mobile;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}


	@Override
	public String toString() {
		return "Customer [CustID=" + CustID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Mobile="
				+ Mobile + ", Country=" + Country + ", Email=" + Email + "]";
	}
}