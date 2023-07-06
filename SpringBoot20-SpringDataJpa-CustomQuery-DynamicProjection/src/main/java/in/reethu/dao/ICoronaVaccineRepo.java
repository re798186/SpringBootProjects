package in.reethu.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import in.reethu.bo.CoronaVaccine;
import in.reethu.type.View;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long> {

	public <T extends View> List<T> findByCompanyOrderByCompanyDesc(String company, Class<T> clazz);

}
