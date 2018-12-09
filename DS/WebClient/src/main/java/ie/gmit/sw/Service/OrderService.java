package ie.gmit.sw.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import ie.gmit.sw.Model.Order;

@Service
public class OrderService {
	
	public List<Order> getOrder(){
		
		Client client = Client.create();
		
		WebResource web = client.resource("http://localhost:8080/RestJersey/webapi/read");
		
		return web.get(new GenericType<List<Order>>(){});
		
	}

//	public List<Order> getOrders() throws IOException, JAXBException {
//	
//		JAXBContext jc = JAXBContext.newInstance(Order.class);
//		List<Order> o = new ArrayList<>();
//		
//		URL url = new URL("http://localhost:8080/RestJersey/webapi/read");
//		HttpURLConnection http = (HttpURLConnection) url.openConnection(); 
//		http.setRequestMethod("GET");
//		http.addRequestProperty("User-Agent", "Mozilla/4.76"); 
//		InputStream is = http.getInputStream();
//		Unmarshaller jaxbUnmarshaller = jc.createUnmarshaller();
//		Order emps = (Order) jaxbUnmarshaller.unmarshal(is);
//		o.addAll(emps.getOrders());
//
//		http.disconnect();
//		return o;
//	}
}
