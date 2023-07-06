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
		System.out.println(service.fetchEmpsCount());
		System.out.println(service.getEmployeeNameByNo(3));
		System.out.println(service.getEmployeeDetailsByNo(3));
		System.out.println(service.getEmployeeDeatilsByDesignation("manager","clerk"));
		System.out.println(service.addBonusToEmpByDesg("manager",5000));
		System.out.println(service.insertEmp("puppa",62,"knr","homemaker",20000));
		
		
		((ConfigurableApplicationContext) context).close();
	}

}
