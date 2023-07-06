package in.reethu.service;

import java.util.List;

import in.reethu.dto.EmployeeDTO;

public interface IEmployeeService {
	public List<EmployeeDTO>  fetchEmpsByDesgs(String desgs[])throws Exception;
}
