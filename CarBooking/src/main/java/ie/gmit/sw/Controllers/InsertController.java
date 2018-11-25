package ie.gmit.sw.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.gmit.sw.Models.Order;

@Controller
public class InsertController {
	
	// for update order
	// this is the get request which directs to the add ship page
	@RequestMapping(value = "/CreateOrder", method = RequestMethod.GET)
	public String getAddShip(Model m, @ModelAttribute("order") Order order, HttpServletRequest h) throws IOException, JAXBException {

//		List<Order> orders = (ArrayList<Order>) orderService.getOrders();
//
//		Map<Long,String> shipList = new HashMap<Long,String>();
//		for (Order c : orders) {
//				shipList.put((long) c.getOrderID(), "Id: " + " " +  c.getOrderID() +  " Order Number: " + c.getOrderNumber());
//		}
//		
//		m.addAttribute("shipList", shipList);
//		
		return "CreateOrder";
	}

}
