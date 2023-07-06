package in.reethu.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.reethu.bo.CoronaVaccine;
import in.reethu.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronoVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<CoronaVaccine> getVaccineBetweenPrice(Double price1, Double price2) {

		return repo.findByPriceBetween(price1, price2);
	}@Override
	public List<CoronaVaccine> fetchVaccineByCompany(String company) {

		System.out.println(repo.getClass() + " " + Arrays.toString(repo.getClass().getDeclaredMethods()));

		List<CoronaVaccine> listEntities = repo.findByCompany(company);
		return listEntities;
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByPricesLessThan(Double price) {
		return repo.findByPriceLessThan(price);
	}

	@Override
	public List<CoronaVaccine> searchVaccineByCountriesAndPriceRange(List<String> countires, double startRange,
			double endRange) {

		return repo.findByCountryInAndPriceBetween(countires, startRange, endRange);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineNotByCountry(List<String> countries) {
		return repo.findByCountryNotIn(countries);
	}
}
