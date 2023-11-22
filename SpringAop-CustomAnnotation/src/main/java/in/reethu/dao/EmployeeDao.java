package in.reethu.dao;

import org.springframework.stereotype.Component;

import in.reethu.annotation.MyTransaction;

@Component
public class EmployeeDao {
	@MyTransaction
	public String saveEmployee() {
		System.out.println("save employee");
		return "save";
	}
	public String deleteEmployee() {
		System.out.println("delete employee");
		return "delete";
	}
}
