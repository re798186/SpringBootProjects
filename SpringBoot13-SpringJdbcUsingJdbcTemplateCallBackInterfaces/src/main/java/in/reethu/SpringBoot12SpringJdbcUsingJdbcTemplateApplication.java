package in.reethu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.reethu.service.IEmployeeMangementService;

@SpringBootApplication
public class SpringBoot12SpringJdbcUsingJdbcTemplateApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(SpringBoot12SpringJdbcUsingJdbcTemplateApplication.class, args);
		
		IEmployeeMangementService service = context.getBean(IEmployeeMangementService.class);
		System.out.println(service.getEmployeeDetailsByNo(3));
		System.out.println(service.getEmployeeDetailsByNoUsingBeanPropertyRowMapper(4));
		System.out.println(service.getEmployeeDeatilsByDesignation("manager","clerk"));
		System.out.println(service.getAllEmployees());
		System.out.println("----EmployeesUsingRowMapperResultSetExtractor--------");
		System.out.println(service.getAllEmployeesUsingRowMapperResultSetExtractor());
		
		System.out.println("----EmployeesUsingRowCallBackHandler--------");
		System.out.println(service.getAllEmployeesUsingRowCallBackHandler());
		
		
		((ConfigurableApplicationContext) context).close();
	}

}
