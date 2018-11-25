package ie.gmit.sw.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import ie.gmit.sw.Models.Car;

@Service
public class CarService {

	public List<Car> getCars() throws IOException, JAXBException {
		URL url = new URL("http://localhost:8080/CarHireRest/webapi/car");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		// Unmarshall the JSON response
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		FileWriter fileWriter = new FileWriter("cars.xml");
		PrintWriter printWriter = new PrintWriter(fileWriter);

		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
			printWriter.append(inputLine);
		}
		in.close();
		con.disconnect();
		printWriter.close();
		fileWriter.close();

		List<Car> o = new ArrayList<>();

		JAXBContext jc = JAXBContext.newInstance(Car.class);
		Unmarshaller ums = jc.createUnmarshaller();
		Car emps = (Car) ums.unmarshal(new File("cars.xml"));
	
		o.addAll(emps.getCars());
		return o;
	}
}
