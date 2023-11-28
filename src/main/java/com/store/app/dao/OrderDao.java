package com.store.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.store.app.model.Order;
import com.store.app.model.Product;

public class OrderDao {
	
	private static final String INSERT_ORDER ="INSERT INTO orders"+"(user_id,product_id,quantity) VALUES"+"(?,?,?);";
	
	private Connection con;
	private String query;
	private PreparedStatement smt;
	private ResultSet rs;
	
	
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
	
	 public List<Order> userOrders(int id) {
	        List<Order> list = new ArrayList<>();
	        try {
	            query = "select * from orders where user_id=? ";
	            smt = this.con.prepareStatement(query);
	            smt.setInt(1, id);
	            rs = smt.executeQuery();
	            while (rs.next()) {
	                Order order = new Order();
	                ProductDao productDao = new ProductDao(this.con);
	                int pId = rs.getInt("product_id");
	                Product product = productDao.getSingleProduct(pId);
	                order.setOrder_id(rs.getInt("id"));
	                order.setId(pId);
	                order.setName(product.getName());
	                order.setCategory(product.getCategory());
	                order.setPrice(product.getPrice()*rs.getInt("quantity"));
	                order.setQuantity(rs.getInt("quantity"));
	                order.setDate(rs.getString("created_at"));
	                list.add(order);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return list;
	    }

	    public void cancelOrder(int id) {
	        //boolean result = false;
	        try {
	            query = "delete from orders where id=?";
	            smt = this.con.prepareStatement(query);
	            smt.setInt(1, id);
	            smt.execute();
	            //result = true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.print(e.getMessage());
	        }
	        //return result;
	    }
}
