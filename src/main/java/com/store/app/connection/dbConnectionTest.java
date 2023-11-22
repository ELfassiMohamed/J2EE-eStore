package com.store.app.connection;

import java.sql.SQLException;

public class dbConnectionTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		dbConnection dbCon = new dbConnection();
		System.out.println(dbCon.getConnection());
	}

}
