package in.reethu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.reethu.service.ICoronaVaccineMgmtService;
import in.reethu.type.ResultView1;
import in.reethu.type.ResultView2;
import in.reethu.type.ResultView3;

@SpringBootApplication
public class SpringBoot17SpringDataJpaJpaRepositoryApplication {
	public static void main(String[] args) throws Exception {

		ApplicationContext factory = SpringApplication.run(SpringBoot17SpringDataJpaJpaRepositoryApplication.class,
				args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

		service.searchVaccineByCompany("bharathbiotech", ResultView2.class).forEach(view -> {
			System.out.println(view.getName() + " " + view.getPrice() + " " + view.getPrice());
		});

		service.searchVaccineByCompany("serum", ResultView1.class).forEach(view -> {
			System.out.println(view.getName() + " " + view.getCountry());
		});
		service.searchVaccineByCompany("serum", ResultView3.class).forEach(view -> {
			System.out.println(view.getCompany()+" "+view.getName()+" "+view.getPrice());
		});
		
		((ConfigurableApplicationContext) factory).close();
	}
}
