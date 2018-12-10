package ie.gmit.sw.Controller;

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

import ie.gmit.sw.Model.Order;
import ie.gmit.sw.Service.OrderService;
import ie.gmit.sw.Service.UpdateService;

@Controller
public class UpdateController {


	@Autowired
	private UpdateService updateService;
	@Autowired
	private OrderService orderService;
	
	
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();
	
	@RequestMapping(value = "/UpdateOrder", method = RequestMethod.GET)
	public String createOrder(Model m, @ModelAttribute("order") Order order, HttpServletRequest h) throws IOException, JAXBException {
	
		
		List<Order> orders = orderService.getOrder();
		
		Map<Long,String> orderList = new HashMap<Long,String>();
		Map<Long,String> custList = new HashMap<Long,String>();
		Map<Long,String> carList = new HashMap<Long,String>();
		
		for (Order order2 : orders) {
			orderList.put((long) order2.getOrderID(), "ID: " + order2.getOrderID() + " Customer Id: " + order2.getCustomer().getCustID() + " Car ID: " + order2.getCar().getCarID());
			custList.put((long) order2.getCustomer().getCustID(), "Name: " + " " +  order2.getCustomer().getFirstName() +  " " + order2.getCustomer().getLastName());
			carList.put((long) order2.getCar().getCarID(), "Brand: " + " " +  order2.getCar().getCarBrand() +  " Model: " + order2.getCar().getCarModel());
		}
		
//		List<Order> orders = (ArrayList<Order>) orderService.getOrders();
//		List<Customer> cust = (ArrayList<Customer>) cs.getCustomers();
//		List<Car> cars = (ArrayList<Car>) carService.getCars();
//		
//		Map<Long,String> orderList = new HashMap<Long,String>();
//		for (Order c : orders) {
//			orderList.put((long) c.getOrderID(), "ID: " + c.getOrderID() + " Customer Id: " + c.getCust() + " Car ID: " + c.getCar());
//		}
//		
//		Map<Long,String> custList = new HashMap<Long,String>();
//		for (Customer c : cust) {
//			custList.put((long) c.getCustID(), "ID: " + c.getCustID() + " Name: " + " " +  c.getFirstName() +  " " + c.getLastName());
//		}
//		
//		Map<Long,String> carList = new HashMap<Long,String>();
//		for (Car c : cars) {
//			carList.put((long) c.getCarID(), "ID: " + c.getCarID() + " Brand: " + " " +  c.getCarBrand() +  " Model: " + c.getCarModel() + " Color " + c.getCarColour());
//		}
		
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
			updateService.updateOrder(order);
			return "redirect:showOrders";
		}
	}
}
