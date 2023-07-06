package in.reethu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.reethu.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
	
}
