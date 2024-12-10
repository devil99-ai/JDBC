package com.simplilearn.JDBCDemos;

public class Employee {
	Integer Eid;
	String EName;
	String Address;
	String phone;
	String email;
	Integer Age;
	String Birthdate;
	Integer salary;
	public Employee(Integer eid, String eName, String address, String phone, String email, Integer age,
			String birthdate, Integer salary) {
		Eid = eid;
		EName = eName;
		Address = address;
		this.phone = phone;
		this.email = email;
		Age = age;
		Birthdate = birthdate;
		this.salary = salary;
	}
	public Employee() {
	}
	public Integer getEid() {
		return Eid;
	}
	public void setEid(Integer eid) {
		Eid = eid;
	}
	public String getEName() {
		return EName;
	}
	public void setEName(String eName) {
		EName = eName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}
	public String getBirthdate() {
		return Birthdate;
	}
	public void setBirthdate(String birthdate) {
		Birthdate = birthdate;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [Eid=" + Eid + ", EName=" + EName + ", Address=" + Address + ", phone=" + phone + ", email="
				+ email + ", Age=" + Age + ", Birthdate=" + Birthdate + ", salary=" + salary + "]";
	}
	
	

}
