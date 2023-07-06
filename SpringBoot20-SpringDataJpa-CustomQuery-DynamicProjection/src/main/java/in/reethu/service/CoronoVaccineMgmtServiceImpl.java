package in.reethu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.reethu.dao.ICoronaVaccineRepo;
import in.reethu.type.View;

@Service("service")
public class CoronoVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;
	
	@Override
	public <T extends View> List<T> searchVaccineByCompany(String company, Class<T> clazz) {
		return repo.findByCompanyOrderByCompanyDesc(company, clazz);
	}}
