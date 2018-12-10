package ie.gmit.sw.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import ie.gmit.sw.Model.Car;
import ie.gmit.sw.Model.Customer;
import ie.gmit.sw.Model.Order;

@Service
public class OrderService {

	public List<Order> getOrder() {

		Client client = Client.create();

		WebResource web = client.resource("http://localhost:8080/RestJersey/webapi/read");

		return web.get(new GenericType<List<Order>>() {
		});

	}

	public List<Customer> getCustomer() {

		Client client = Client.create();

		WebResource web = client.resource("http://localhost:8080/RestJersey/webapi/readCust");

		return web.get(new GenericType<List<Customer>>() {
		});
	}
	
	public List<Car> getCars() {

		Client client = Client.create();

		WebResource web = client.resource("http://localhost:8080/RestJersey/webapi/readCar");

		return web.get(new GenericType<List<Car>>() {
		});
	}

}
