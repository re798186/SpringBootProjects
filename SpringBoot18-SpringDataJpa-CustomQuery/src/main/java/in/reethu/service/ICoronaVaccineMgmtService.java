package in.reethu.service;

import java.util.List;

import in.reethu.bo.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public List<CoronaVaccine> getVaccineBetweenPrice(Double price1, Double price2);

	public List<CoronaVaccine> fetchVaccineByCompany(String company);

	public List<CoronaVaccine> fetchVaccineByPricesLessThan(Double price);

	public List<CoronaVaccine> searchVaccineByCountriesAndPriceRange(List<String> countires, double startRange,
			double endRange);

	public List<CoronaVaccine> fetchVaccineNotByCountry(List<String> countries);
}
