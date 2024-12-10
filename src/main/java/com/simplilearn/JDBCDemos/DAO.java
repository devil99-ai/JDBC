package com.simplilearn.JDBCDemos;

import java.util.List;

import com.simplilearn.JDBCDemos.Employee;

public interface DAO {
	void createConnection();
	void closeConnection();
	void createEmployee(Employee emp);
	void updateEmployee(Employee emp);
	void deleteEmployee(Employee emp);
	List<Employee> getAllEmployee();
	
	

}
