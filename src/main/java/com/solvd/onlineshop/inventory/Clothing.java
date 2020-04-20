package com.solvd.onlineshop.inventory;

import com.solvd.onlineshop.Product;

public class Clothing extends Product {
	private String name;
	private String description;
	private int size;
	private Category category;

	public Clothing(String name, String description, int size ,Category category) {

		super(name, description, size);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String description() {
		return description;
	}

	public int size() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}


}
