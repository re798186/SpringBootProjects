package in.reethu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.reethu.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class SpringBoot17SpringDataJpaJpaRepositoryApplication {
	public static void main(String[] args) throws Exception {

		ApplicationContext factory = SpringApplication.run(SpringBoot17SpringDataJpaJpaRepositoryApplication.class,
				args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);
		service.getVaccineBetweenPrice(500.0, 700.0).forEach(System.out::println);

		service.fetchVaccineByCompany("serum").forEach(System.out::println);
		service.fetchVaccineByPricesLessThan(550.5).forEach(System.out::println);

		List<String> countries = new ArrayList<String>();
		countries.add("CHINA");
		countries.add("Russia");
		service.searchVaccineByCountriesAndPriceRange(countries, 200.0, 700.0).forEach(System.out::println);

		service.fetchVaccineNotByCountry(countries).forEach(System.out::println);
		;
		((ConfigurableApplicationContext) factory).close();
	}
}
