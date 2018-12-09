package ie.gmit.sw.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Service;

import ie.gmit.sw.Model.Car;
import ie.gmit.sw.Model.Customer;
import ie.gmit.sw.Model.Order;

@Service
public class InsertService {
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();
	private final String USER_AGENT = "Mozilla/5.0";
	static Order order = new Order();
	
	public void create(int cust, int car) throws IOException, JAXBException {
		
//		
//		<Order>
//		<car>2</car>
//		<customer>3</customer>
//	</Order>
		
		Car carid = new Car();
		carid.setCarID(car);
		
		Customer customer = new Customer();
		customer.setCustID(cust);
		
		order.setCar(carid);
		order.setCustomer(customer);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	     
	    //Marshal the employees list in console
	    jaxbMarshaller.marshal(order, System.out);
		
	    System.out.println(cust);
	    System.out.println(car);
	    
//		//http://localhost:8080/CarHireRest/webapi/Create/3/2/2018-11-25
//		String d =""+dateFormat.format(date);
//		String customer = "" +cust;
//		String cars = ""+car;
//		
//        StringBuilder stringBuilder = new StringBuilder("http://localhost:8080/CarHireRest/webapi/Create");
//        stringBuilder.append("/");
//        stringBuilder.append(URLEncoder.encode(customer, "UTF-8"));
//        stringBuilder.append("/");
//        stringBuilder.append(URLEncoder.encode(cars, "UTF-8"));
//        stringBuilder.append("/");
//        stringBuilder.append(URLEncoder.encode(d, "UTF-8"));
//        
//        URL url = new URL(stringBuilder.toString());
// 
//		HttpURLConnection con = (HttpURLConnection) url.openConnection();
//		con.setRequestMethod("GET");
//		con.setRequestProperty("User-Agent", USER_AGENT);
//		con.setRequestProperty("Accept-Charset", "UTF-8");
// 
//        System.out.println(dateFormat.format(date));
//		System.out.println("\nSending request to URL : " + url);
//		System.out.println("Response Code : " + con.getResponseCode());
	}
}
