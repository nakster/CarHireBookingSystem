package ie.gmit.sw.Service;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import ie.gmit.sw.Model.Order;
@Service
public class UpdateService {

	private String url = "http://localhost:8080/RestJersey/webapi/update";

	public void updateOrder(Order order) {
		Client client = Client.create();

		WebResource webResource = client.resource(this.url);

		ClientResponse response = webResource.type("application/xml").put(ClientResponse.class, order);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
	}
}
