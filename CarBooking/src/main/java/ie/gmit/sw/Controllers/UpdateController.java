package ie.gmit.sw.Controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import ie.gmit.sw.Models.Car;
import ie.gmit.sw.Models.Customer;
import ie.gmit.sw.Models.Order;
import ie.gmit.sw.services.CarService;
import ie.gmit.sw.services.CustomerService;
import ie.gmit.sw.services.OrderService;
import ie.gmit.sw.services.UpdateService;

@Controller
public class UpdateController {

	@Autowired
	private CustomerService cs;
	@Autowired
	private CarService carService;
	@Autowired
	private UpdateService updateService;
	@Autowired
	private OrderService orderService;
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();
	
	@RequestMapping(value = "/UpdateOrder", method = RequestMethod.GET)
	public String createOrder(Model m, @ModelAttribute("order") Order order, HttpServletRequest h) throws IOException, JAXBException {
	
		List<Order> orders = (ArrayList<Order>) orderService.getOrders();
		List<Customer> cust = (ArrayList<Customer>) cs.getCustomers();
		List<Car> cars = (ArrayList<Car>) carService.getCars();
		
		Map<Long,String> orderList = new HashMap<Long,String>();
		for (Order c : orders) {
			orderList.put((long) c.getOrderID(), "ID: " + c.getOrderID() + " Customer Id: " + c.getCust() + " Car ID: " + c.getCar());
		}
		
		Map<Long,String> custList = new HashMap<Long,String>();
		for (Customer c : cust) {
			custList.put((long) c.getCustID(), "ID: " + c.getCustID() + " Name: " + " " +  c.getFirstName() +  " " + c.getLastName());
		}
		
		Map<Long,String> carList = new HashMap<Long,String>();
		for (Car c : cars) {
			carList.put((long) c.getCarID(), "ID: " + c.getCarID() + " Brand: " + " " +  c.getCarBrand() +  " Model: " + c.getCarModel() + " Color " + c.getCarColour());
		}
		
		Map<Long, String> d = new HashMap<Long,String>();
		d.put((long) 1, dateFormat.format(date));
		
		m.addAttribute("custList", custList);
		m.addAttribute("carList", carList);
		m.addAttribute("orderList", orderList);

		return "UpdateOrder";
	}
	
	@RequestMapping(value = "/UpdateOrder", method = RequestMethod.POST)
	public String postShip(@Valid @ModelAttribute("order") Order order, BindingResult result) throws IOException {

		if (result.hasFieldErrors()) {
			return "UpdateOrder";
		} else {
			System.out.println("Update from Controlllllllller");
			//insertService.create(order.getCust(), order.getCar());
			updateService.updateOrder(order.getOrderID(), order.getCust(), order.getCar());
			return "redirect:showOrders";
		}
	}
}
