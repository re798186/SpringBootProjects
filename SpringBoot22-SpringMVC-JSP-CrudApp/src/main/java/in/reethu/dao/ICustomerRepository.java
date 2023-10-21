package in.reethu.dao;

import org.springframework.data.repository.CrudRepository;

import in.reethu.model.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Integer> {

}
