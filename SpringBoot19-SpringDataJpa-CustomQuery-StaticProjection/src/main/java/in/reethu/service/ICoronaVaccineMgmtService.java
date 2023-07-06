package in.reethu.service;

import java.util.List;

import in.reethu.bo.CoronaVaccine;
import in.reethu.type.ResultView;

public interface ICoronaVaccineMgmtService {

	List<ResultView> searchVaccineByStartPrice(Double price);}
