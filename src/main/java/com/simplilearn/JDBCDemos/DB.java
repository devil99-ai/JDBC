package com.simplilearn.JDBCDemos;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;

import com.simplilearn.JDBCDemos.Employee;

public class DB implements DAO{
	Connection connection;
	Statement stmt;
	PreparedStatement preparedStatement;

	
	
	public DB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. Driver Loaded...");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createConnection() {
		// TODO Auto-generated method stub
		try {
			String user="root";
			String password="Souvik99@";
			String database= "employee";
			String url="jdbc:mysql://localhost:3306/"+database;
			connection = DriverManager.getConnection(url,user,password);
			System.out.println("1. Connection created...");
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		try { if(connection !=null) {
			connection.close();
			System.out.println("3. Connection closed...");
		}else {
			System.out.println("4. Connection doesn't exists...");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}

	@Override
	public void createEmployee(Employee emp) {
		try {
			SimpleDateFormat pattern =  new SimpleDateFormat("YYYY-MM-DD");
			//String Date=pattern.format(new Date());
			//emp.setBirthdate(Date);
			//creating table
//			String sql = "CREATE TABLE EMPLOYEE "+"(eid INTEGER PRIMARY KEY AUTO_INCREMENT, "+"ename VARCHAR(255), "+"address VARCHAR(255), "+"phone VARCHAR(10), "+"email VARCHAR(255), "+"age INTEGER, "+"birthdate DATETIME, "+"salary INTEGER)";
//			stmt = connection.createStatement();
//			int result=stmt.executeUpdate(sql);
//			System.out.println("5. Created table in employee database");
			
			
			//inserting values inside employee table
			String sql = "insert into employee values(null, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, emp.getEName());
			preparedStatement.setString(2, emp.getAddress());
			preparedStatement.setString(3, emp.getPhone());
			preparedStatement.setString(4, emp.getEmail());
			preparedStatement.setInt(5, emp.getAge());
			preparedStatement.setString(6, emp.getBirthdate());
			preparedStatement.setInt(7, emp.getSalary());
			
			
			//String sql1 = "Insert into employee (eid , ename ,address ,phone ,email ,age ,birthdate ,salary)"+"VALUES (null, 'souvik sharma' ,'murshidabad','9987546321', 'svkshrm@gmail.com' , 24, '1999-06-20' , 20000)";
			//preparedStatement = connection.prepareStatement(sql1);
			
			int result = preparedStatement.executeUpdate();
			String message = result >0? "Employee "+emp.getEName()+" created successfully..": "Employee "+emp.getEName()+" Not Created..";
			System.out.println(message);
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> emp= new ArrayList<Employee>();
		try {
			String sql = "select * from employee";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet set = preparedStatement.executeQuery();
			while(set.next()) {
				Employee employee = new Employee();
				employee.setEid(set.getInt(1));
				employee.setEName(set.getString(2));
				employee.setAddress(set.getString(3));
				employee.setPhone(set.getString(4));
				employee.setEmail(set.getString(5));
				employee.setBirthdate(set.getString(7));
				employee.setAge(set.getInt(6));
				employee.setSalary(8);
				emp.add(employee);
			}
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
			
		return emp;
	}

	
}
