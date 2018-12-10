package ie.gmit.sw.Service;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import ie.gmit.sw.Model.Car;
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
	
	public void createCar(Car order) {
		String urls = "http://localhost:8080/RestJersey/webapi/createCar";

		Client client = Client.create();

		WebResource webResource = client.resource(urls);

		ClientResponse response = webResource.type("application/xml").post(ClientResponse.class, order);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

	}

}
