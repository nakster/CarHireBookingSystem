package ie.gmit.sw.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import ie.gmit.sw.Models.Order;

@Service
public class OrderService {
	
	private final String USER_AGENT = "Mozilla/5.0";

	public List<Order> getOrders() throws IOException, JAXBException {
		URL url = new URL("http://localhost:8080/CarHireRest/webapi/myresource");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		// Unmarshall the JSON response
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		FileWriter fileWriter = new FileWriter("order.xml");
		PrintWriter printWriter = new PrintWriter(fileWriter);

		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
			printWriter.append(inputLine);
		}
		in.close();
		con.disconnect();
		printWriter.close();
		fileWriter.close();

		List<Order> o = new ArrayList<>();

		JAXBContext jc = JAXBContext.newInstance(Order.class);
		Unmarshaller ums = jc.createUnmarshaller();
		Order emps = (Order) ums.unmarshal(new File("Order.xml"));
	
		o.addAll(emps.getOrders());
		return o;
	}
	
	public void delete(int id) throws IOException {
	    String username=""+id;
        StringBuilder stringBuilder = new StringBuilder("http://localhost:8080/CarHireRest/webapi/myresource");
        stringBuilder.append("/delete/");
        stringBuilder.append(URLEncoder.encode(username, "UTF-8"));
        
        URL url = new URL(stringBuilder.toString());
 
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Charset", "UTF-8");
 
		System.out.println("\nSending request to URL : " + url);
		System.out.println("Response Code : " + con.getResponseCode());
		System.out.println("Response Message : " + con.getResponseMessage());
	}
}
