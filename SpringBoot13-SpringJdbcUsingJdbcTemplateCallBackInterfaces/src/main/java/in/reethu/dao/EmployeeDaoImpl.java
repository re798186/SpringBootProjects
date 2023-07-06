package in.reethu.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import in.reethu.comp.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDAO {

	private static final String GET_ALL_EMPLOYEES = "select eid,ename,eage,eaddress,desg,salary from employee2";
	private static final String GET_EMPLOYEE_BY_NO = "select eid,ename,eage,eaddress,desg,salary from employee2 where eid=?";
	private static final String GET_EMPLOYEE_BY_DESG = "select eid,ename,eage,eaddress,desg,salary from employee2 where desg in (?,?) order by salary";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Employee getEmployeeDetailsByNo(int eno) {
		Employee emp = jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_NO, (rs, rowNum) -> {
			Employee e = new Employee();
			e.setEid(rs.getInt("eid"));
			e.setEname(rs.getString("ename"));
			e.setEage(rs.getInt("eage"));
			e.setEaddress(rs.getString("eaddress"));
			e.setDesg(rs.getString("desg"));
			e.setSalary(rs.getDouble("salary"));
			return e;
		}, eno);
		return emp;
	}

	@Override
	public List<Employee> getEmployeeDeatilsByDesignation(String desg1, String desg2) {
		List<Employee> empRecords = jdbcTemplate.query(GET_EMPLOYEE_BY_DESG, (rs, rowNum) -> {
			Employee e = new Employee();
			e.setEid(rs.getInt("eid"));
			e.setEname(rs.getString("ename"));
			e.setEage(rs.getInt("eage"));
			e.setEaddress(rs.getString("eaddress"));
			e.setDesg(rs.getString("desg"));
			e.setSalary(rs.getDouble("salary"));
			return e;
		}, desg1, desg2);
		return empRecords;
	}

	@Override
	public Employee getEmployeeDetailsByNoUsingBeanPropertyRowMapper(int eno) {
		Employee emp = jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_NO,
				new BeanPropertyRowMapper<Employee>(Employee.class), eno);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empRecords = jdbcTemplate.query(GET_ALL_EMPLOYEES, (rs) -> {
			List<Employee> emps = new ArrayList<Employee>();
			while (rs.next()) {
				Employee e = new Employee();
				e.setEid(rs.getInt("eid"));
				e.setEname(rs.getString("ename"));
				e.setEage(rs.getInt("eage"));
				e.setEaddress(rs.getString("eaddress"));
				e.setDesg(rs.getString("desg"));
				e.setSalary(rs.getDouble("salary"));
				emps.add(e);
			}
			return emps;
		});
		return empRecords;
	}

	@Override
	public List<Employee> getAllEmployeesUsingRowMapperResultSetExtractor() {
		List<Employee> empRecords = jdbcTemplate.query(GET_ALL_EMPLOYEES,
				new RowMapperResultSetExtractor<Employee>(new BeanPropertyRowMapper<Employee>(Employee.class)));
		return empRecords;
	}

	@Override
	public List<Employee> getAllEmployeesUsingRowCallBackHandler() {
		List<Employee> emps = new ArrayList<Employee>();
		jdbcTemplate.query(GET_ALL_EMPLOYEES, (rs) -> {
			Employee e = new Employee();
			e.setEid(rs.getInt("eid"));
			e.setEname(rs.getString("ename"));
			e.setEage(rs.getInt("eage"));
			e.setEaddress(rs.getString("eaddress"));
			e.setDesg(rs.getString("desg"));
			e.setSalary(rs.getDouble("salary"));
			emps.add(e);
		});
		return emps;
	}

}
