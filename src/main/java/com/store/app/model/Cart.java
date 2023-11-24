package com.store.app.model;

public class Cart extends Product {
	private int quantity ;

	public Cart() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
