package in.reethu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import in.reethu.target.Student;

@SpringBootApplication
@ImportResource(locations = "in/reethu/cfg/applicationContext.xml")
public class SpringBoot2DiProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(SpringBoot2DiProjectApplication.class, args);

		System.out.println("*****Container started");

		Student student = context.getBean(Student.class);
		System.out.println(student);

		student.preparation(student.getMaterial().getClass().getName());

		((ConfigurableApplicationContext) context).close();

	
	}

}
