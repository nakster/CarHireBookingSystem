package ie.gmit.sw.Controller;

import java.io.IOException;
import java.util.ArrayList;
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
public class OrderController {

	@Autowired
	private OrderService orderService;

	// display ships
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String getShips(Model m) throws IOException, JAXBException {

//		List<Order> orders = (ArrayList<Order>) orderService.getOrder();
		List<Order> orders = orderService.getOrder();

//		for (Order order : orders) {
//			System.out.println(order.getOrderID());
//			System.out.println(order.getCar().toString());
//			System.out.println(order.getCustomer().toString());
//		}

		m.addAttribute("orders", orders);

		return "displayorders";
	}

}
