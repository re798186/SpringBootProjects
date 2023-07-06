package in.reethu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.reethu.comp.Employee;
import in.reethu.service.IEmployeeMangementService;

@SpringBootApplication
public class SpringBoot12SpringJdbcUsingJdbcTemplateApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(SpringBoot12SpringJdbcUsingJdbcTemplateApplication.class, args);
		
		IEmployeeMangementService service = context.getBean(IEmployeeMangementService.class);
		System.out.println(service.getEmployeeDetailsByNo(3));
		System.out.println("----EmployeesUsingMapSqlParameterSource--------");
		System.out.println(service.getEmployeeDeatilsByDesignation("manager","clerk"));
		
		System.out.println("----EmployeesUsingBeanPropertySqlParameterSource--------");
		Employee e=new Employee();
		e.setEname("Kittu");
		e.setEage(8);
		e.setEaddress("Auh");
		e.setDesg("Student");
		e.setSalary(5000);
		System.out.println(service.registerEmployee(e));
		
		
		((ConfigurableApplicationContext) context).close();
	}

}
