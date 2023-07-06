package in.reethu.dao;

import java.util.List;

import in.reethu.bo.EmployeeBO;

public interface IEmployeeDao {
	public  List<EmployeeBO>  getEmpsByDesg(String cond)throws Exception;
}
