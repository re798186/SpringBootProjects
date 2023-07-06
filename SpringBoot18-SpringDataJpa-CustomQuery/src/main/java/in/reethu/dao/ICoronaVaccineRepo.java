package in.reethu.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import in.reethu.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long> {

	public List<CoronaVaccine> findByPriceBetween(Double price1, Double price2);

	public List<CoronaVaccine> findByCompany(String company);

	public List<CoronaVaccine> findByPriceLessThan(Double price);

	public List<CoronaVaccine> findByCountryInAndPriceBetween(Collection<String> countries, double startRange,
			double endRange);

	public List<CoronaVaccine> findByCountryNotIn(Collection<String> countries);

}
