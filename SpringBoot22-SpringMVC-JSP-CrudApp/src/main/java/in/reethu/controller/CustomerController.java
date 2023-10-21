package in.reethu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.reethu.model.Customer;
import in.reethu.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	ICustomerService service;
	
	@GetMapping("/list")
	public String listCustomers(Map<String, Object> model) {
		List<Customer> customers = service.listAllCustomers();
		customers.forEach(System.out::println);
		model.put("customers", customers);
		return "list-customers";
	}
	
	@GetMapping("/showForm")
	public String showForm(Map<String, Object> model , @ModelAttribute Customer customer) {
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(Map<String, Object> model , @ModelAttribute Customer customer) {
		service.saveCustomer(customer);
		System.out.println("In Controller");
		return "redirect:list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(Map<String, Object> model, @RequestParam Integer customerId) {
		Customer customer = service.getCustomerById(customerId);
		model.put("customer", customer);
		return "customer-form";
	}
	@GetMapping("/showFormForDelete")
	public String showFormForDelete(Map<String, Object> model, @RequestParam Integer customerId) {
		service.deleteCustomer(customerId);
		return "redirect:list";
	}
}
