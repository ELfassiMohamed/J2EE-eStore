package com.store.app.model;

public class Order extends Product {
	private int order_id;
	private int user_id;
	private int quantity;
	private String date;
	public Order() {
		super();
	}
	public Order(int order_id, int user_id, int quantity, String date) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.quantity = quantity;
		this.date = date;
	}
	public Order(int user_id, int quantity, String date) {
		super();
		this.user_id = user_id;
		this.quantity = quantity;
		this.date = date;
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", quantity=" + quantity + ", date=" + date + "]";
	}
	
	

}
