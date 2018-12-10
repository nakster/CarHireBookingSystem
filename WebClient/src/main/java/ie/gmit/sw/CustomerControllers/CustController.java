package ie.gmit.sw.CustomerControllers;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.gmit.sw.Model.Order;
import ie.gmit.sw.Service.OrderService;

@Controller
public class CustController {

	@Autowired
	private OrderService orderService;

	// display ships
	@RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
	public String getShips(Model m) throws IOException, JAXBException {

		List<Order> orders = orderService.getOrder();

		m.addAttribute("orders", orders);

		return "displayCust";
	}

}
