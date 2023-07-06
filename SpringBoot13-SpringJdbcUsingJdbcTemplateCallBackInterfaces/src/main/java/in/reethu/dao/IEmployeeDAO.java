package in.reethu.dao;

import java.util.List;

import in.reethu.comp.Employee;

public interface IEmployeeDAO {
	public List<Employee> getAllEmployees();
	public List<Employee> getAllEmployeesUsingRowCallBackHandler();
	public List<Employee> getAllEmployeesUsingRowMapperResultSetExtractor();
	public Employee getEmployeeDetailsByNo(int eno);
	public List<Employee> getEmployeeDeatilsByDesignation(String desg1,String desg2);
	public Employee getEmployeeDetailsByNoUsingBeanPropertyRowMapper(int eno);
}
