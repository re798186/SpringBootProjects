package in.reethu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.reethu.dao.EmployeeDao;

@SpringBootApplication
public class SpringAopAspctJAppApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(SpringAopAspctJAppApplication.class, args);
		
		
		EmployeeDao dao = context.getBean(EmployeeDao.class);
		dao.saveEmployee();
		dao.deleteEmployee();
		
		
	}

}
