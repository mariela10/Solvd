package com.solvd.onlineshop.payment;


import java.util.Date;

import org.apache.logging.log4j.*;

import com.solvd.onlineshop.IPay;
import com.solvd.onlineshop.exceptions.InvalidCardException;

public class CreditCard implements IPay {
	private String ccNumber;;
	private Date expDate;
	private int cvcCode;

	private static final Logger LOGGER = LogManager.getLogger(CreditCard.class);

	public CreditCard(String ccNumber, Date expDate, int cvcCode) {
		super();
		this.ccNumber = ccNumber;
		this.expDate = expDate;
		this.cvcCode = cvcCode;
	}

	public CreditCard() {

	}

	@Override
	public String pay(double amount) {

		return "Payment Processed";

	}

	
	public String validateCard(String ccNumber, Date expDate, int cvcCode, Enum<CardType> card)
			throws InvalidCardException {
		LOGGER.info("validating new card info: " + ccNumber + " " + expDate + " " + cvcCode + " " + card);
		if (ccNumber.chars().count() != 16)
			throw new InvalidCardException("Card is invalid");

		else
			return "card is valid";

	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public int getCvcCode() {
		return cvcCode;
	}

	public void setCvcCode(int cvcCode) {
		this.cvcCode = cvcCode;
	}
}
