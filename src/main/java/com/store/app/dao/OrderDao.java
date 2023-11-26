package com.store.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.store.app.model.Order;
import com.store.app.model.Product;

public class OrderDao {
	
	private static final String INSERT_ORDER ="INSERT INTO orders"+"(user_id,product_id,quantity) VALUES"+"(?,?,?);";
	
	private Connection con;
	private String query;
	private PreparedStatement smt;
	
	
	public OrderDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean submitOrder(Order order) {
		boolean result = false;
		try {
			smt = this.con.prepareStatement(INSERT_ORDER);
			smt.setInt(1,order.getUser_id());
			smt.setInt(2, order.getId());
			smt.setInt(3, order.getQuantity());
			smt.executeUpdate();
			result = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
