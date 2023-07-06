package in.reethu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.reethu.comp.Employee;

@SpringBootApplication
public class SpringBoot5ConfigurationPropertiesForCollectionApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBoot5ConfigurationPropertiesForCollectionApplication.class, args);
	Employee employee = context.getBean(Employee.class);
	System.out.println(employee);
	System.out.println(employee.getProjectNames().get(0));
	}

}
