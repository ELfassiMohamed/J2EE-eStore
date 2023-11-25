package com.store.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.store.app.model.Order;

public class OrderDao {
	private Connection con;
	private String query;
	private PreparedStatement smt;
	private ResultSet rs;
	
	public OrderDao(Connection con) {
		super();
		this.con = con;
	}
	
	public void submitOrder(Order order) {
		try {
			query = "insert into orders values " ;
			smt = this.con.prepareStatement(query);
			smt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
