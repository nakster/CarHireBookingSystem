package ie.gmit.sw.Service;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import ie.gmit.sw.Model.Customer;
import ie.gmit.sw.Model.Order;

@Service
public class InsertService {

	private String url = "http://localhost:8080/RestJersey/webapi/create";

	public void createOrder(Order order) {
		Client client = Client.create();

		WebResource webResource = client.resource(this.url);

		ClientResponse response = webResource.type("application/xml").post(ClientResponse.class, order);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
	}

	public void createCust(Customer order) {
		String urls = "http://localhost:8080/RestJersey/webapi/createCust";

		Client client = Client.create();

		WebResource webResource = client.resource(urls);

		ClientResponse response = webResource.type("application/xml").post(ClientResponse.class, order);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

	}

//	public void create(int cust, int car) throws IOException, JAXBException {
//
////		
////		<Order>
////		<car>2</car>
////		<customer>3</customer>
////	</Order>
//
//		Car carid = new Car();
//		carid.setCarID(car);
//
//		Customer customer = new Customer();
//		customer.setCustID(cust);
//
//		order.setCar(carid);
//		order.setCustomer(customer);
//
//		JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
//		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//		// Marshal the employees list in console
//		jaxbMarshaller.marshal(order, System.out);
//
//		System.out.println(cust);
//		System.out.println(car);
//
//		URL url = new URL("http://localhost:8080/RestJersey/webapi/create");
//		HttpURLConnection con = (HttpURLConnection) url.openConnection();
//		con.setRequestMethod("POST");
//		con.setRequestProperty("Content-Type", "application/xml");
//
//		con.setDoOutput(true);
//		OutputStream output = new BufferedOutputStream(con.getOutputStream());
////		output.write(str.getBytes());
//		output.flush();
//
//		con.disconnect();
//
//	}
}
