package com.solvd.onlineshop.inventory;

import com.solvd.onlineshop.Product;

public class Electronics extends Product {
	private String productName;
	private String productDescription;
	private int productPrice;

	public Electronics(String productName, String productDescription, int productPrice) {
		super(productName, productDescription, productPrice);
	}

}
