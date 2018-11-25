package ie.gmit.sw.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class InsertService {
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();
	private final String USER_AGENT = "Mozilla/5.0";
	
	public void create(int cust, int car) throws IOException {
	    
		//http://localhost:8080/CarHireRest/webapi/Create/3/2/2018-11-25
		String d =""+dateFormat.format(date);
		String customer = "" +cust;
		String cars = ""+car;
		
        StringBuilder stringBuilder = new StringBuilder("http://localhost:8080/CarHireRest/webapi/Create");
        stringBuilder.append("/");
        stringBuilder.append(URLEncoder.encode(customer, "UTF-8"));
        stringBuilder.append("/");
        stringBuilder.append(URLEncoder.encode(cars, "UTF-8"));
        stringBuilder.append("/");
        stringBuilder.append(URLEncoder.encode(d, "UTF-8"));
        
        URL url = new URL(stringBuilder.toString());
 
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Charset", "UTF-8");
 
        System.out.println(dateFormat.format(date));
		System.out.println("\nSending request to URL : " + url);
		System.out.println("Response Code : " + con.getResponseCode());
		System.out.println("Response Message : " + con.getResponseMessage());
	}
}
