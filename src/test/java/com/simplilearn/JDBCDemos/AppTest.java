package com.simplilearn.JDBCDemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	
	static Connection conn;
	static Statement stmt;
	PreparedStatement preparedstatement;
	static final String database_url = "jdbc:mysql://localhost:3306/";
	static final String user="root";
	static final String password="Souvik99@";
	static final String database="sample";
	public AppTest() throws ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	
	public static void createDB() throws SQLException {
		conn = DriverManager.getConnection(database_url,user,password);
		stmt = conn.createStatement();
		String sql = "Create Database sample";
		stmt.executeUpdate(sql);
		
	}
	public static void DB() throws SQLException {
		String database="sample";
		//create table
		try {
			conn = DriverManager.getConnection(database_url+database,user,password);
			stmt =  conn.createStatement();
			String sql = "Create table sampleData (id INT PRIMARY KEY, name varchar(255), address varchar(255), phoneNo varchar(10), email_id varchar(255))";
			stmt.executeUpdate(sql);
		}catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			e.getCause();
			e.getLocalizedMessage();
		}
		//update and Insert data
		
	}
	public static void insertDB() {
		
		try {
			conn = DriverManager.getConnection(database_url+database,user,password);
			stmt =  conn.createStatement();
			String sqlInsert= "Insert into sampleData(id, name, address, phoneNo, email_id)"+"values(101,'souvik sharma','kolkata','995587663','abc@example.com'),(102,'john smith','Mumbai','4456112378','john@smith.com')";
			stmt.executeUpdate(sqlInsert);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			e.getCause();
			e.getLocalizedMessage();
		}
	}
	public static void updateDB() {
		try {
			conn = DriverManager.getConnection(database_url+database,user,password);
			stmt = conn.createStatement();
			String sqlUpdate = "UPDATE sampleData SET phoneNo='9920364588'" +"WHERE id = 101";
			stmt.executeUpdate(sqlUpdate);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			e.getCause();
			e.getLocalizedMessage();
		}
		
	}
	public static void deleteTableInDB() {
		try {
			conn = DriverManager.getConnection(database_url+database, user, password);
			stmt = conn.createStatement();
			String sqlDetele = "Delete from sampleData WHERE address = 'Mumbai'";
			stmt.executeUpdate(sqlDetele);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			e.getCause();
			e.getLocalizedMessage();
		}
	}
	public static void printDB() {
		try {
			conn = DriverManager.getConnection(database_url+database, user, password);
			stmt = conn.createStatement();
			String sql = "Select * from sampleData";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs);
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			e.getCause();
			e.getLocalizedMessage();
		}
	}
	
	public static void deleteDB() {
		try {
			conn = DriverManager.getConnection(database_url+database, user, password);
			stmt = conn.createStatement();
			String sqlDropTable = "Drop Table sampleData";
			String sqlDropDb = "Drop database sample";
			stmt.executeUpdate(sqlDropDb);
			stmt.executeUpdate(sqlDropTable);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			e.getCause();
			e.getLocalizedMessage();
		}
	}
	
}
   