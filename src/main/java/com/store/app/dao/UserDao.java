package com.store.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.store.app.model.User;



public class UserDao {
	private Connection con;
	private String query;
	private PreparedStatement smt;
	private ResultSet rs;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}

	public User userLogin(String email, String password) {
		User user = null;
		try {
			query = "select * from users where email=? and password=?";
			smt = this.con.prepareStatement(query);
			smt.setString(1, email);
			smt.setString(2, password);
			rs = smt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
