package ie.gmit.sw.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

@Service
public class InsertService {
	
	private final String USER_AGENT = "Mozilla/5.0";
	
	public void delete(int id) throws IOException {
	    String username=""+id;
        StringBuilder stringBuilder = new StringBuilder("http://localhost:8080/CarHireRest/webapi/myresource");
        stringBuilder.append("/delete/");
        stringBuilder.append(URLEncoder.encode(username, "UTF-8"));
        
        URL url = new URL(stringBuilder.toString());
 
//		HttpURLConnection con = (HttpURLConnection) url.openConnection();
//		con.setRequestMethod("GET");
//		con.setRequestProperty("User-Agent", USER_AGENT);
//		con.setRequestProperty("Accept-Charset", "UTF-8");
 
		System.out.println("\nSending request to URL : " + url);
//		System.out.println("Response Code : " + con.getResponseCode());
//		System.out.println("Response Message : " + con.getResponseMessage());
	}

}
