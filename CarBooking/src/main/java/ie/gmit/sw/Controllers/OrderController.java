package ie.gmit.sw.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.gmit.sw.Models.Order;
import ie.gmit.sw.services.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	// display ships
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String getShips(Model m) throws IOException, JAXBException {

		List<Order> orders = (ArrayList<Order>) orderService.getOrders();

		m.addAttribute("orders", orders);

		return "displayorders";
	}

	// for update order
	// this is the get request which directs to the add ship page
	@RequestMapping(value = "/DeleteOrder", method = RequestMethod.GET)
	public String getAddShip(Model m, @ModelAttribute("order") Order order, HttpServletRequest h) throws IOException, JAXBException {

		List<Order> orders = (ArrayList<Order>) orderService.getOrders();

		Map<Long,String> shipList = new HashMap<Long,String>();
		for (Order c : orders) {
				shipList.put((long) c.getOrderID(), "Id: " + " " +  c.getOrderID() +  " Order Date: " + c.getDate());
		}
		
		m.addAttribute("shipList", shipList);
		
		return "DeleteOrder";
	}

	// This is the post request which saves the ship object
	// then displays the new data on the display page
	@RequestMapping(value = "/DeleteOrder", method = RequestMethod.POST)
	public String postShip(@Valid @ModelAttribute("order") Order order, BindingResult result) throws IOException {

		if (result.hasFieldErrors()) {
			return "DeleteOrder";
		} else {
			// Pass the customer to the Customer Service for saving
			// orderService.save(ship);
			System.out.println("Delete Controlllllllller");
			orderService.delete(order.getOrderID());
			//System.out.println(order.getOrderID());
			return "redirect:showOrders";
		}
	}

}
