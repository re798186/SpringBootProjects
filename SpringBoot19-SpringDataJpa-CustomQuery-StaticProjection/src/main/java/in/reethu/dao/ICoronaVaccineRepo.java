package in.reethu.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import in.reethu.bo.CoronaVaccine;
import in.reethu.type.ResultView;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long> {

	public List<ResultView> findByPriceGreaterThanEqualOrderByPrice(Double price);

}
