package com.solvd.onlineshop;

public abstract class Product {
	private String item;
	private int price;
	private String productDescription;

	public Product(String item, String productDescription, int price) {
		this.item = item;
		this.productDescription = productDescription;
		this.price = price;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return productDescription;
	}

	public void setSetDescription(String des) {
		this.productDescription = des;
	}
	public String toString() {
		return this.getItem();
	}

}
