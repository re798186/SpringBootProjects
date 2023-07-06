package in.reethu.service;

import java.util.List;

import in.reethu.type.View;

public interface ICoronaVaccineMgmtService {

	<T extends View> List<T> searchVaccineByCompany(String company, Class<T> clazz);
}
