package in.reethu.service;

import java.util.List;

import in.reethu.comp.Employee;

public interface IEmployeeMangementService {
	public Employee getEmployeeDetailsByNo(int eno);

	public List<Employee> getEmployeeDeatilsByDesignation(String desg1, String desg2);

	public int registerEmployee(Employee emp);
}
