package com.simplilearn.JDBCDemos;

import java.sql.SQLException;
import java.util.List;

public class JDBCImplements {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		AppTest  appTest = new AppTest();
		appTest.createDB();
		appTest.DB();
		appTest.insertDB();
		appTest.updateDB();
		appTest.deleteTableInDB();
		appTest.printDB();
		appTest.deleteDB();

	}

}
