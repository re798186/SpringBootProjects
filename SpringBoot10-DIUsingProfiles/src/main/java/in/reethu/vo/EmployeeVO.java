package in.reethu.vo;

public class EmployeeVO {
	
	private String srNo;
private String eno;
private String ename;
private String sal;
private String job;
private String deptNo;
private String mgrNo;


public String getSrNo() {
	return srNo;
}


public void setSrNo(String srNo) {
	this.srNo = srNo;
}


public String getEno() {
	return eno;
}


public void setEno(String eno) {
	this.eno = eno;
}


public String getEname() {
	return ename;
}


public void setEname(String ename) {
	this.ename = ename;
}


public String getSal() {
	return sal;
}


public void setSal(String sal) {
	this.sal = sal;
}


public String getJob() {
	return job;
}


public void setJob(String job) {
	this.job = job;
}


public String getDeptNo() {
	return deptNo;
}


public void setDeptNo(String deptNo) {
	this.deptNo = deptNo;
}


public String getMgrNo() {
	return mgrNo;
}


public void setMgrNo(String mgrNo) {
	this.mgrNo = mgrNo;
}


@Override
public String toString() {
	return "EmployeeVO [srNo=" + srNo + ", eno=" + eno + ", ename=" + ename + ", sal=" + sal + ", job=" + job
			+ ", deptNo=" + deptNo + ", mgrNo=" + mgrNo + "]";
}


}
