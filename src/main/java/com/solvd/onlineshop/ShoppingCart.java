package com.solvd.onlineshop;

import org.apache.logging.log4j.*;

import com.solvd.onlineshop.customer.Customer;
import com.solvd.onlineshop.exceptions.EmptyCartException;
import com.solvd.onlineshop.Product;

public class ShoppingCart {
	private Product item;
	private Customer cust;
	private int qty;
	private static final Logger LOGGER = LogManager.getLogger(ShoppingCart.class);

	public ShoppingCart(Product item, int qty) {
		this.item = item;
		this.qty = qty;

	}

	public double getCartTotal(Product item, int qty) {
		double ret = item.getPrice() * qty;

		LOGGER.info(qty +" "+ item.getItem()+ " were added to cart at " + item.getPrice() + " dollars per item the total is: " + ret);
		return ret;

	}

	public ShoppingCart getCart(int qty) throws EmptyCartException {
		if (!(this.qty > 0))
			throw new EmptyCartException("cart is empty");

		else
			return this;
	}

	public String toString() {
		return this.item.getItem() + " were added to cart at " + item.getPrice() + "per item the total is: "
				+ this.item.getPrice();
	}

}
