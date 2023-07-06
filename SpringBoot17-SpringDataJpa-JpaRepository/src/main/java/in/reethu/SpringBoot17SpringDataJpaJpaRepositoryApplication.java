package in.reethu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import in.reethu.bo.CoronaVaccine;
import in.reethu.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class SpringBoot17SpringDataJpaJpaRepositoryApplication {
	public static void main(String[] args) throws Exception {

		ApplicationContext factory = SpringApplication.run(SpringBoot17SpringDataJpaJpaRepositoryApplication.class,
				args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

// CoronaVaccine vaccine = new
// CoronaVaccine("covidshield","serum","IND",450.0,2);

		CoronaVaccine vaccine = new CoronaVaccine();
		vaccine.setCountry("USA");
		vaccine.setCompany(null);
		service.searchVaccinesByGivenData(vaccine, false, "price", "name").forEach(System.out::println);

		try {
			CoronaVaccine vaccine1 = service.getVaccineById(1L);
			if (vaccine1 != null) {
				System.out.println("vaccine details are :: " + vaccine1);
			} else {
				System.out.println("Record not available for the given id");
			}
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}

		List<Long> list = new ArrayList<Long>();
		list.add(6L);
		list.add(7L);
		list.add(8L);
		 System.out.println(service.removeVaccinesByRegNo(list));

		((ConfigurableApplicationContext) factory).close();
	}
}
