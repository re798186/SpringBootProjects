package in.reethu.service;

import java.util.Date;
import java.util.List;

import in.reethu.bo.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	List<CoronaVaccine> fetchVaccinesByCompany(String company);

	List<CoronaVaccine> fetchVaccinesByCompanies(String comp1, String comp2);

	List<String> fetchVaccinesByPriceRange(double min, double max);

	List<Object[]> fetchVaccinesByName(String name1, String name2);

	int modifyingPriceByCountry(double newPrice, String country);

	int removeVacinesByPrice(double startPrice, double endPrice);

	int registerVaccine(String company, String country, String name, Double price, Integer required_dose_count);

	Date fetchSystemDate();}
