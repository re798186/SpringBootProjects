package in.reethu.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import in.reethu.comp.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDAO {

	private static final String GET_EMPLOYEE_BY_NO = "select eid,ename,eage,eaddress,desg,salary from employee2 where eid=:eno";
	private static final String GET_EMPLOYEE_BY_DESG = "select eid,ename,eage,eaddress,desg,salary from employee2 where desg in (:desg1,:desg2) order by salary";
	private static final String INSERT_EMPLOYEE = "insert into employee2(`ename`,`eage`,`eaddress`,`desg`,`salary`) values(:ename,:eage,:eaddress,:desg,:salary)";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public EmployeeDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Employee getEmployeeDetailsByNo(int eno) {
		Employee emp = jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_NO, Map.of("eno",eno),(rs, rowNum) -> {
			Employee e = new Employee();
			e.setEid(rs.getInt("eid"));
			e.setEname(rs.getString("ename"));
			e.setEage(rs.getInt("eage"));
			e.setEaddress(rs.getString("eaddress"));
			e.setDesg(rs.getString("desg"));
			e.setSalary(rs.getDouble("salary"));
			return e;
		});
		return emp;
	}

	@Override
	public List<Employee> getEmployeeDeatilsByDesignation(String desg1, String desg2) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("desg1",desg1);
		map.addValue("desg2", desg2);
		List<Employee> empRecords = jdbcTemplate.query(GET_EMPLOYEE_BY_DESG,map, (rs, rowNum) -> {
			Employee e = new Employee();
			e.setEid(rs.getInt("eid"));
			e.setEname(rs.getString("ename"));
			e.setEage(rs.getInt("eage"));
			e.setEaddress(rs.getString("eaddress"));
			e.setDesg(rs.getString("desg"));
			e.setSalary(rs.getDouble("salary"));
			return e;
		});
		return empRecords;
	}

	@Override
	public int registerEmployee(Employee emp) {
		return jdbcTemplate.update(INSERT_EMPLOYEE, new BeanPropertySqlParameterSource(emp));
	}

}
