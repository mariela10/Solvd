package com.solvd.onlineshop.inventory;

import com.solvd.onlineshop.Product;

public class Food extends Product {
	private String productName;
	private String productDescription;
	private int productSize;

	public Food(String productName, String productDescription, int productPrice) {
		super(productName, productDescription, productPrice);
	}
}
