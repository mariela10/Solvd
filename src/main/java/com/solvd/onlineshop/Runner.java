package com.solvd.onlineshop;

import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import com.solvd.onlineshop.customer.Customer;
import com.solvd.onlineshop.inventory.Category;
import com.solvd.onlineshop.inventory.Clothing;

import com.solvd.onlineshop.payment.CardType;
import com.solvd.onlineshop.payment.CreditCard;
import com.solvd.onlineshop.exceptions.InvalidCardException;

public class Runner {

	public Runner() {

	}

	private static final Logger LOGGER = LogManager.getLogger(Runner.class);

	public static void main(String[] args) {

		Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.ALL);

		Product item1 = new Clothing("Dress", "Red" , 4, Category.WOMEN);

		Calendar calendar = Calendar.getInstance();
		calendar.set(2021, 12, 10);
		ShoppingCart sc1 = new ShoppingCart(item1, 3);
		Customer cust1 = new Customer();

		// add payment method and process
		CreditCard pm = new CreditCard();
		LOGGER.info("trying to validate card");

		try {

			pm.validateCard("4343235432343212", calendar.getTime(), 202, CardType.VISA);
		} catch (InvalidCardException e) {
			LOGGER.error(e);
		}
		pm.pay(sc1.getCartTotal(item1, 2));

	}

}
