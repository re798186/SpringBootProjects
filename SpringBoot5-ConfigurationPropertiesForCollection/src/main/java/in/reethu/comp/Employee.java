package in.reethu.comp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "in.reethu")
public class Employee {
private String name;
private long  id;
private Company company;
private Set<String> mobileNos;
private String[] skillSet;
private List<String> projectNames;
private Map<String, String> idDetails;

public String[] getSkillSet() {
	return skillSet;
}
public void setSkillSet(String[] skillSet) {
	this.skillSet = skillSet;
}
public List<String> getProjectNames() {
	return projectNames;
}
public void setProjectNames(List<String> projectNames) {
	this.projectNames = projectNames;
}
public Map<String, String> getIdDetails() {
	return idDetails;
}
public void setIdDetails(Map<String, String> idDetails) {
	this.idDetails = idDetails;
}
public Set<String> getMobileNos() {
	return mobileNos;
}
public void setMobileNos(Set<String> mobileNos) {
	this.mobileNos = mobileNos;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public Company getCompany() {
	return company;
}
public void setCompany(Company company) {
	this.company = company;
}
@Override
public String toString() {
	return "Employee [name=" + name + ", id=" + id + ", company=" + company + ", mobileNos=" + mobileNos + ", skillSet="
			+ Arrays.toString(skillSet) + ", projectNames=" + projectNames + ", idDetails=" + idDetails + "]";
}


}
