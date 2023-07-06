package in.reethu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.reethu.comp.Employee;
import in.reethu.dao.IEmployeeDAO;

@Service
public class EmloyeeMgmtServiceImpl implements IEmployeeMangementService {

	@Autowired
	private IEmployeeDAO dao;

	public EmloyeeMgmtServiceImpl(IEmployeeDAO dao) {
		this.dao = dao;
	}


	@Override
	public Employee getEmployeeDetailsByNo(int eno) {
		return dao.getEmployeeDetailsByNo(eno);
	}

	@Override
	public List<Employee> getEmployeeDeatilsByDesignation(String desg1, String desg2) {
		return dao.getEmployeeDeatilsByDesignation(desg1, desg2);
	}


	@Override
	public Employee getEmployeeDetailsByNoUsingBeanPropertyRowMapper(int eno) {
		return dao.getEmployeeDetailsByNoUsingBeanPropertyRowMapper(eno);
	}


	@Override
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}


	@Override
	public List<Employee> getAllEmployeesUsingRowMapperResultSetExtractor() {
		return dao.getAllEmployeesUsingRowMapperResultSetExtractor();
	}


	@Override
	public List<Employee> getAllEmployeesUsingRowCallBackHandler() {
		return dao.getAllEmployeesUsingRowCallBackHandler();
	}
}
