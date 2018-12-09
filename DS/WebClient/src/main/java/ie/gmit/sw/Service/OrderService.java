package ie.gmit.sw.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import ie.gmit.sw.Models.Order;

@Service
public class OrderService {

	public List<Order> getOrders() throws IOException, JAXBException {
	
		JAXBContext jc = JAXBContext.newInstance(Order.class);
		List<Order> o = new ArrayList<>();
		
		URL url = new URL("http://localhost:8080/RestJersey/webapi/read");
		HttpURLConnection http = (HttpURLConnection) url.openConnection(); 
		http.setRequestMethod("GET");
		http.addRequestProperty("User-Agent", "Mozilla/4.76"); 
		InputStream is = http.getInputStream();
		Unmarshaller jaxbUnmarshaller = jc.createUnmarshaller();
		Order emps = (Order) jaxbUnmarshaller.unmarshal(is);
		o.addAll(emps.getOrders());

		http.disconnect();
		return o;
	}
}
