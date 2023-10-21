package in.reethu.service;

import java.util.List;

import in.reethu.model.Customer;

public interface ICustomerService {

	List<Customer> listAllCustomers();
	Customer getCustomerById(Integer id);
	void saveCustomer(Customer customer);
	void deleteCustomer(Integer id);
	
}
