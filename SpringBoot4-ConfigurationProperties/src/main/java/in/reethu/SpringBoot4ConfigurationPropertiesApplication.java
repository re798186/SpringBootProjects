package in.reethu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.reethu.comp.Company;

@SpringBootApplication
public class SpringBoot4ConfigurationPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBoot4ConfigurationPropertiesApplication.class, args);
	Company company = context.getBean(Company.class);
	System.out.println(company);
	
	}

}
