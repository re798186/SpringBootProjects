package in.reethu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.reethu.dao.ICustomerRepository;
import in.reethu.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository repo;

	@Override
	public List<Customer> listAllCustomers() {
		return (List<Customer>) repo.findAll();
	}

	@Override
	public Customer getCustomerById(Integer id) {
		Optional<Customer> opt = repo.findById(id);
		return opt.get();
	}

	@Override
	public void saveCustomer(Customer customer) {
		repo.save(customer);
	}

	@Override
	public void deleteCustomer(Integer id) {
		repo.deleteById(id);
	}

}
