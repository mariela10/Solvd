package com.solvd.onlineshop.payment;

import com.solvd.onlineshop.IPay;
import com.solvd.onlineshop.exceptions.InvalidCardException;
import com.solvd.onlineshop.exceptions.InvalidPasswordException;
import com.solvd.onlineshop.exceptions.InvalidUsernameException;

import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.*;

public class PayPal implements IPay {

	private String userName;
	private String password;

	private static final Logger LOGGER = LogManager.getLogger(PayPal.class);

	public PayPal(String userName, String password) {
		this.userName = userName;
		this.password = password;

	}
	
	public void pay(double amount) {

		LOGGER.info("Paypal payment complete");
		
	}

	public String getUserName() {
		return userName;
	}

	public String userName(String userName) {
		return this.userName;

	}

	public boolean isValid(String email) {
		String regex = "^[\\w_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);

	}

	public void setUserName(String userName) throws InvalidUsernameException {
		if (!isValid(userName))
			throw new InvalidUsernameException("username is not valid. Username must be in form of an email");
		else
			this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws InvalidPasswordException {
		if (password.chars().count() < 7)
			throw new InvalidPasswordException("Password must be greater than seven characters");
		else
			this.password = password;
	}
	@Override
	public String validateCard(String ccNumber, Date expDate, int cvcCode, Enum<CardType> card)
			throws InvalidCardException {
		// TODO Auto-generated method stub
		return null;
	}

}
