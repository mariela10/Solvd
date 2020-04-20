package com.solvd.onlineshop.inventory;

import com.solvd.onlineshop.Product;

public class Toys extends Product {
	private String productName;
	private String productDescription;
	private int productPrice; 

	public Toys(String productName, String productDescription, int productPrice) {
		super(productName, productDescription, productPrice);
	}

}
