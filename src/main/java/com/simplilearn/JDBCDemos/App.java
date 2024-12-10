package com.simplilearn.JDBCDemos;

import java.util.List;

/* eid       | int          | NO   | PRI | NULL    | auto_increment |
| ename     | varchar(255) | YES  |     | NULL    |                |
| address   | varchar(255) | YES  |     | NULL    |                |
| phone     | varchar(10)  | YES  |     | NULL    |                |
| email     | varchar(255) | YES  |     | NULL    |                |
| age       | int          | YES  |     | NULL    |                |
| birthdate | datetime     | YES  |     | NULL    |                |
| salary
*/

public class App 
{
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
    	DB db = new DB();
    	db.createConnection();
    	Employee emp = new Employee();
    	emp.setEid(1188287); 
    	emp.setEName("Nakul Kukreja");
    	emp.setAddress("Delhi");
    	emp.setPhone("9957441230");
    	emp.setEmail("k.nakul@bakery.com");
    	emp.setAge(28);
    	emp.setBirthdate("1996-12-29");
    	emp.setSalary(20000);
    	System.out.println(emp);
    	db.createEmployee(emp);
    	db.updateEmployee(emp);
//    	db.closeConnection();
//    	
//    	
    	List <Employee> employees = db.getAllEmployee();
    	for (Employee emp1: employees) {
    		System.out.println(emp1);
    	}
    	db.closeConnection();
    }
}
