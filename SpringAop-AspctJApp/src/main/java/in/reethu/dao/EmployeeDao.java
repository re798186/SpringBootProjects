package in.reethu.dao;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	public String saveEmployee() {
		System.out.println("save employee");
		return "save";
	}
	public String deleteEmployee() {
		System.out.println("delete employee");
		return "delete";
	}
}
