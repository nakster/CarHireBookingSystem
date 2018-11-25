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

import ie.gmit.sw.Models.Car;
import ie.gmit.sw.Models.Customer;
import ie.gmit.sw.Models.Order;
import ie.gmit.sw.services.CarService;
import ie.gmit.sw.services.CustomerService;

@Controller
public class InsertController {
	@Autowired
	private CustomerService cs;
	@Autowired
	private CarService carService;
	// for update order
	// this is the get request which directs to the add ship page
	@RequestMapping(value = "/CreateOrder", method = RequestMethod.GET)
	public String createOrder(Model m, @ModelAttribute("order") Order order, HttpServletRequest h) throws IOException, JAXBException {
	
		List<Customer> cust = (ArrayList<Customer>) cs.getCustomers();
		List<Car> cars = (ArrayList<Car>) carService.getCars();
		
		Map<Long,String> custList = new HashMap<Long,String>();
		for (Customer c : cust) {
			custList.put((long) c.getCustID(), "Name: " + " " +  c.getFirstName() +  " " + c.getLastName());
		}
		
		Map<Long,String> carList = new HashMap<Long,String>();
		for (Car c : cars) {
			carList.put((long) c.getCarID(), "Brand: " + " " +  c.getCarBrand() +  " Model: " + c.getCarModel());
		}
		
		m.addAttribute("custList", custList);
		m.addAttribute("carList", carList);
		
		return "CreateOrder";
	}
	
	// This is the post request which saves the ship object
		// then displays the new data on the display page
		@RequestMapping(value = "/CreateOrder", method = RequestMethod.POST)
		public String postShip(@Valid @ModelAttribute("order") Order order, BindingResult result) throws IOException {

			if (result.hasFieldErrors()) {
				return "CreateOrder";
			} else {
				// Pass the customer to the Customer Service for saving
				// orderService.save(ship);
				System.out.println("Delete Controlllllllller");
				//orderService.delete(order.getOrderID());
				System.out.println(order.getCust());
				System.out.println(order.getCar());
				return "redirect:showOrders";
			}
		}
}
