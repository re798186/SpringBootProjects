package in.reethu;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.reethu.service.ICoronaVaccineMgmtService;
import in.reethu.type.ResultView;

@SpringBootApplication
public class SpringBoot17SpringDataJpaJpaRepositoryApplication {
	public static void main(String[] args) throws Exception {

		ApplicationContext factory = SpringApplication.run(SpringBoot17SpringDataJpaJpaRepositoryApplication.class,
				args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

		List<ResultView> listVaccines = service.searchVaccineByStartPrice(500.0);
		listVaccines.forEach(vaccine -> {
			System.out.println(
					vaccine.getClass().getName() + " " + Arrays.toString(vaccine.getClass().getDeclaredMethods()));
			System.out.println(vaccine.getName() + " " + vaccine.getCountry());
		});
		((ConfigurableApplicationContext) factory).close();
	}
}
