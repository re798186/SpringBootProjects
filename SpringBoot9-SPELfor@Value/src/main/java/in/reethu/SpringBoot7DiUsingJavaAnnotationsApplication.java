package in.reethu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.reethu.target.BillGenerator;

@SpringBootApplication
public class SpringBoot7DiUsingJavaAnnotationsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBoot7DiUsingJavaAnnotationsApplication.class, args);
		BillGenerator billGenerator = context.getBean(BillGenerator.class);
		System.out.println(billGenerator);
		((ConfigurableApplicationContext) context).close();
	}

}
