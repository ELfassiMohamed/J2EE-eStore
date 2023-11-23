package com.store.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.store.app.model.Product;

public class ProductDao {
	private Connection con;
	private String query;
	private PreparedStatement smt;
	private ResultSet rs;
	
	public ProductDao(Connection con) {
		super();
		this.con = con;
	}
	
	public List<Product> showProducts(){
		List<Product> products = new ArrayList<Product>();
		try {
			query = "select * from products";
			smt = this.con.prepareStatement(query);
			rs = smt.executeQuery();
			while(rs.next()) {
				Product product_row = new Product();
				product_row.setId(rs.getInt("id"));
				product_row.setName(rs.getString("name"));
				product_row.setCategory(rs.getString("category"));
				product_row.setPrice(rs.getString("price"));
				product_row.setImage(rs.getString("image"));
				products.add(product_row);
			}
				
			}catch(Exception e) {
				e.printStackTrace();
		}
		return products;
	}

}
