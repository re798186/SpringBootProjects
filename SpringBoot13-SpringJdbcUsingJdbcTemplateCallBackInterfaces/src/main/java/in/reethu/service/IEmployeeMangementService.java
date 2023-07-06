package in.reethu.service;

import java.util.List;

import in.reethu.comp.Employee;

public interface IEmployeeMangementService {
	public List<Employee> getAllEmployees();
	public List<Employee> getAllEmployeesUsingRowCallBackHandler();
	public List<Employee> getAllEmployeesUsingRowMapperResultSetExtractor();
	public Employee getEmployeeDetailsByNo(int eno);
	public Employee getEmployeeDetailsByNoUsingBeanPropertyRowMapper(int eno);
	public List<Employee> getEmployeeDeatilsByDesignation(String desg1,String desg2);
}
