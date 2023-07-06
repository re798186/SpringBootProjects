package in.reethu.bo;

public class EmployeeBO {
	private Integer eno;
	private String ename;
	private Double sal;
	private String job;
	private Integer deptNo;
	private Integer mgrNo;
	@Override
	public String toString() {
		return "EmployeeBO [eno=" + eno + ", ename=" + ename + ", sal=" + sal + ", job=" + job + ", deptNo=" + deptNo
				+ ", mgrNo=" + mgrNo + "]";
	}
	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public Integer getMgrNo() {
		return mgrNo;
	}
	public void setMgrNo(Integer mgrNo) {
		this.mgrNo = mgrNo;
	}

	}
