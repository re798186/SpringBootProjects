package in.reethu;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.reethu.dependent.JavaCourseMaterial;
import in.reethu.target.Student;

@SpringBootApplication
public class SpringBoot7DiUsingJavaAnnotationsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBoot7DiUsingJavaAnnotationsApplication.class, args);
		System.out.println("Beans info are :: " + Arrays.toString(context.getBeanDefinitionNames()));
		Student student = context.getBean(Student.class);
		JavaCourseMaterial material = context.getBean(JavaCourseMaterial.class);
		System.out.println(student);
		System.out.println(material);
		((ConfigurableApplicationContext) context).close();
	}

}
