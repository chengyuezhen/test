package cn.edu.jsu.cyz.vo;

import java.io.Serializable;

public class staff implements Serializable {
	private String JobNumber;
	private String Name;
	private int Age;
	private String DepartmentNumber;
	private String DepartmentName;
	private int WageId;
	
	public staff(String jobNumber, String name, int age, String departmentNumber, String departmentName, int wageId) {
		super();
		JobNumber = jobNumber;
		Name = name;
		Age = age;
		DepartmentNumber = departmentNumber;
		DepartmentName = departmentName;
		WageId = wageId;
	}

	public staff() {
		super();
	}

	public String getJobNumber() {
		return JobNumber;
	}

	public void setJobNumber(String jobNumber) {
		JobNumber = jobNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) { 
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getDepartmentNumber() {
		return DepartmentNumber;
	}

	public void setDepartmentNumber(String departmentNumber) {
		DepartmentNumber = departmentNumber;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	public int getWageId() {
		return WageId;
	}

	public void setWageId(int wageId) {
		WageId = wageId;
	}

	@Override
	public String toString() {
		return "staff [JobNumber=" + JobNumber + ", Name=" + Name + ", Age=" + Age + ", DepartmentNumber="
				+ DepartmentNumber + ", DepartmentName=" + DepartmentName + ", WageId=" + WageId + "]";
	}
	

}
