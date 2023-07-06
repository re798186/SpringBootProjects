package in.reethu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.reethu.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class SpringBoot15SpringDataJpaPagingAndSortingRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication
				.run(SpringBoot15SpringDataJpaPagingAndSortingRepositoryApplication.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);
		System.out.println("@@@@@@@@@@@@@@@@");
		service.fetchDetails(true, "country", "price")
				.forEach((vaccine) -> System.out.println(vaccine.getPrice() + " == " + vaccine.getCountry()));
		System.out.println("################");

		service.fetchDetailsByPageNo(2, 2, true, "price", "name").forEach((vaccine) -> System.out
				.println(vaccine.getName() + " " + vaccine.getPrice() + " " + vaccine.getCountry()));

		System.out.println("%%%%%%%%%%%%%%%%%%%%%");
		service.fetchDetailsByPagination(3);
		((ConfigurableApplicationContext) factory).close();
	}

}
