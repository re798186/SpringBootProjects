package in.reethu.service;

import java.util.List;

import in.reethu.bo.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine vaccine, boolean ascOrder,String... properties);
	public CoronaVaccine getVaccineById(Long regNo);
	public String removeVaccinesByRegNo(Iterable<Long> regNo);

}
