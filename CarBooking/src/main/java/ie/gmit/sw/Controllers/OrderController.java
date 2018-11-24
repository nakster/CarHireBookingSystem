package ie.gmit.sw.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.gmit.sw.Models.Order;
import ie.gmit.sw.services.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	//display ships 
	@RequestMapping(value = "/showOrders", method=RequestMethod.GET)
	public String getShips(Model m) throws IOException, JAXBException{

		List<Order> orders = (ArrayList<Order>) orderService.getOrders();

		m.addAttribute("orders", orders);
		
		System.out.println("In the Controller");
		for (Order order : orders) {
			System.out.println(order.getOrderID());
		}

		return "displayorders";
	}

	//add ship
	// this is the get request which directs to the add ship page
	@RequestMapping(value = "/UpdateOrder", method = RequestMethod.GET)
	public String getAddShip(@ModelAttribute("order") Order order, HttpServletRequest h) {

		return "UpdateOrder";
	}

	// This is the post request which saves the ship object 
	// then displays the new data on the display page 
//	@RequestMapping(value = "/addShip", method = RequestMethod.POST)
//	public String postShip(@Valid @ModelAttribute("ship") Ship ship,BindingResult result) {
//
//		if(result.hasFieldErrors()) {			
//			return "addShip";
//		}else{
//			// Pass the customer to the Customer Service for saving
//			shipService.save(ship);
//			return "redirect:showShips";
//		}
//		
//	}

}
