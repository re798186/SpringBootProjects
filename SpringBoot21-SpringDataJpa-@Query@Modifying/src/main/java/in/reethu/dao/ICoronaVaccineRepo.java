package in.reethu.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.reethu.bo.CoronaVaccine;
import jakarta.transaction.Transactional;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long> {

	// @Query("FROM CoronaVaccine WHERE COMPANY = ?1")
	@Query("From in.reethu.bo.CoronaVaccine WHERE company=:vendor")

	// @Query("FROM CoronaVaccine WHERE company=:comp")
	public List<CoronaVaccine> searchVaccinesByCompany(String vendor);
	
	
	@Query("FROM CoronaVaccine WHERE company IN(:comp1,:comp2)")
	public List<CoronaVaccine> searchVaccinesByComapnies(String comp1,String comp2);
	
	@Query("SELECT name FROM CoronaVaccine WHERE price BETWEEN :min AND :max")
	public List<String> searchVaccinesByPriceRange(double min,double max);
	
	@Query("SELECT name,company,price from CoronaVaccine WHERE name IN(:name1,:name2)")
	public List<Object[]> searchVaccinesByName(String name1,String name2);
	
	@Modifying
	@Query("UPDATE CoronaVaccine SET price=:newPrice WHERE country=:country ")
	public int updatePriceByCountry(double newPrice,String country);
	
	@Modifying
	@Query("DELETE FROM CoronaVaccine WHERE price BETWEEN :startPrice AND :endPrice")
	@Transactional
	public int deleteVaccineByPrice(double startPrice,double endPrice);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO corona_vaccine(`company`,`country`,`name`,`price`,`requried_dose_count`) values(?,?,?,?,?)",nativeQuery = true)
	public int insertVaccine(String company,String country,String name, Double price,Integer requried_dose_count);
	
	@Query(value="SELECT NOW() FROM DUAL",nativeQuery = true)
	public Date getSystemDate();}
