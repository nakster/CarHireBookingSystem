package ie.gmit.sw.CustomerControllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import ie.gmit.sw.Model.Customer;
import ie.gmit.sw.Model.Order;
import ie.gmit.sw.Service.InsertService;
import ie.gmit.sw.Service.OrderService;

@Controller
public class InsertCustController {

	@Autowired
	private InsertService insertService;
	@Autowired
	private OrderService orderService;
	// for update order
	// this is the get request which directs to the add ship page
	@RequestMapping(value = "/CreateCustomers", method = RequestMethod.GET)
	public String createOrder(Model m, @ModelAttribute("order") Order order, HttpServletRequest h) throws IOException, JAXBException {
	
		List<Order> orders = orderService.getOrder();

		m.addAttribute("orders", orders);
		
		return "CreateCustomer";
	}
	
	// This is the post request which saves the ship object
		// then displays the new data on the display page
		@RequestMapping(value = "/CreateCustomers", method = RequestMethod.POST)
		public String postShip(@Valid @ModelAttribute("order") Order order, BindingResult result) throws IOException, JAXBException {

			if (result.hasFieldErrors()) {
				return "CreateCustomer";
			} else {
				// Pass the customer to the Customer Service for saving
				System.out.println("Insert from Controlllllllller");
				System.out.println("cust id from controller" + order.getCustomer().getMobile());
				
				Customer c = new Customer(order.getCustomer().getCustID() ,order.getCustomer().getFirstName(),order.getCustomer().getLastName(),order.getCustomer().getMobile(),order.getCustomer().getCountry(),order.getCustomer().getEmail());
				insertService.createCust(c);
				
				return "redirect:showOrders";
			}
		}
}
