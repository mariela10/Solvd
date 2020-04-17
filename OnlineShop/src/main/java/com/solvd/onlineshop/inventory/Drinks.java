package com.solvd.onlineshop.inventory;

import com.solvd.onlineshop.Product;

public class Drinks extends Product {
	private String name;
	private String description;
	private int size;

	public Drinks(String name, String description, int size) {

		super(name, description, size);

	}

	public String getName() {
		return name;
	}

	public void setName(String 	name) {
		this.name = name;
	}

	public String description() {
		return description;
	}

	public int size() {
		return size;
	}

	public void setsize(int size) {
		this.size = size;
	}

}
