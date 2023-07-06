package in.reethu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import in.reethu.controller.EmployeeController;
import in.reethu.vo.EmployeeVO;

@SpringBootApplication
public class SpringBoot10DiUsingProfilesApplication {
	@Autowired
	private Environment env;

	@Bean
	@Profile({"dev","uat"})
	public ComboPooledDataSource createDS() throws Exception {
		System.out.println("BootProj11RealTimeDiAutoConfigurationProfilesApplication.createDS()");
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUser(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(SpringBoot10DiUsingProfilesApplication.class, args);
		System.out.println(context);
		System.out.println("No of beans is :: " + Arrays.toString(context.getBeanDefinitionNames()));

		// read inputs from enduser
		Scanner sc = new Scanner(System.in);
		System.out.print("Desgs count:: ");
		int count = sc.nextInt();
		String desgs[] = null;
		if (count >= 1)
			desgs = new String[count];
		else {
			System.out.println("invalid desg count ");
			return;
		}
		for (int i = 0; i < count; ++i) {
			System.out.print("enter desg" + (i + 1) + ":: ");
			String desg = sc.next();
			desgs[i] = desg;
		}

		// get Controller class obj
		EmployeeController controller = context.getBean("empController", EmployeeController.class);

		// invoke business method
		try {
			List<EmployeeVO> listVO = controller.showEmpsByDesgs(desgs);
			System.out.println("Emp details having " + Arrays.toString(desgs));
			listVO.forEach(vo -> {
				System.out.println(vo);
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some Internal problem::" + e.getMessage());
		}

		// close IOC container
		((ConfigurableApplicationContext) context).close();
		sc.close();
}

}
