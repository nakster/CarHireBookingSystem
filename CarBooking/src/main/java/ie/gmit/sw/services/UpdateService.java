package ie.gmit.sw.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

@Service
public class UpdateService {
	private final String USER_AGENT = "Mozilla/5.0";

	public void updateOrder(int orderid, int cust, int car) throws IOException {
		// http://localhost:8080/CarHireRest/webapi/update/1/1/1
		String oId = "" + orderid;
		String customer = "" + cust;
		String cars = "" + car;

		StringBuilder stringBuilder = new StringBuilder("http://localhost:8080/CarHireRest/webapi/update");
		stringBuilder.append("/");
		stringBuilder.append(URLEncoder.encode(oId, "UTF-8"));
		stringBuilder.append("/");
		stringBuilder.append(URLEncoder.encode(customer, "UTF-8"));
		stringBuilder.append("/");
		stringBuilder.append(URLEncoder.encode(cars, "UTF-8"));

		URL url = new URL(stringBuilder.toString());

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Charset", "UTF-8");

		// System.out.println(dateFormat.format(date));
		System.out.println("\nSending request to URL : " + url);
		System.out.println("Response Code : " + con.getResponseCode());
	}
}
