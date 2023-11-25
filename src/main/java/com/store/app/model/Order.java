package com.store.app.model;

public class Order extends Product {
	private int id;
	private String user_id;
	private int quantity;
	private String date;
	public Order() {
		super();
	}
	public Order(int id, String user_id, int quantity, String date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.quantity = quantity;
		this.date = date;
	}
	public Order(String user_id, int quantity, String date) {
		super();
		this.user_id = user_id;
		this.quantity = quantity;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
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
		return "Order [id=" + id + ", user_id=" + user_id + ", quantity=" + quantity + ", date=" + date + "]";
	}
	
	

}
