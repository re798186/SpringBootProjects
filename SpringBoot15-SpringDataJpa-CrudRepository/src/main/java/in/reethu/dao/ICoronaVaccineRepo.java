package in.reethu.dao;

import org.springframework.data.repository.CrudRepository;

import in.reethu.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long> {

}
