package ie.gmit.sw.CarControllers;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.gmit.sw.Model.Car;
import ie.gmit.sw.Service.OrderService;

@Controller
public class CarController {

	@Autowired
	private OrderService orderService;

	// display ships
	@RequestMapping(value = "/showCars", method = RequestMethod.GET)
	public String getShips(Model m) throws IOException, JAXBException {

		List<Car> orders = orderService.getCars();

		m.addAttribute("orders", orders);

		return "displayCars";
	}

}
