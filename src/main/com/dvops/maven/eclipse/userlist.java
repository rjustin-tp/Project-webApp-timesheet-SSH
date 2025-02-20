package com.dvops.maven.eclipse;

public class userlist {
//declare attributes
	protected String empID;
	protected String FirstName;
	protected String LastName;
	protected String DOB;
	protected String PayGrade;
	protected String EmpDate;
	protected String ComEmail;
	protected String Mobileph;
	protected String pssword;
	protected String AnnualLeave;
	protected String StatLeave;
	protected String SickLeave;
	
	//generate constructor with fields	
public userlist(String empID, String firstName, String lastName, String dOB, String payGrade, String empDate,
			String comEmail, String mobileph, String pssword, String annualLeave, String statLeave, String sickLeave) {
		super();
		this.empID = empID;
		FirstName = firstName;
		LastName = lastName;
		DOB = dOB;
		PayGrade = payGrade;
		EmpDate = empDate;
		ComEmail = comEmail;
		Mobileph = mobileph;
		this.pssword = pssword;
		AnnualLeave = annualLeave;
		StatLeave = statLeave;
		SickLeave = sickLeave;
	}

//Generate getter and setter	
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getPayGrade() {
		return PayGrade;
	}
	public void setPayGrade(String payGrade) {
		PayGrade = payGrade;
	}
	public String getEmpDate() {
		return EmpDate;
	}
	public void setEmpDate(String empDate) {
		EmpDate = empDate;
	}
	public String getComEmail() {
		return ComEmail;
	}
	public void setComEmail(String comEmail) {
		ComEmail = comEmail;
	}
	public String getMobileph() {
		return Mobileph;
	}
	public void setMobileph(String mobileph) {
		Mobileph = mobileph;
	}
	public String getPssword() {
		return pssword;
	}
	public void setPssword(String pssword) {
		this.pssword = pssword;
	}
	public String getAnnualLeave() {
		return AnnualLeave;
	}
	public void setAnnualLeave(String annualLeave) {
		AnnualLeave = annualLeave;
	}
	public String getStatLeave() {
		return StatLeave;
	}
	public void setStatLeave(String statLeave) {
		StatLeave = statLeave;
	}
	public String getSickLeave() {
		return SickLeave;
	}
	public void setSickLeave(String sickLeave) {
		SickLeave = sickLeave;
	}
	


}
