package com.solvd.onlineshop;

import java.util.Calendar;
import java.util.Date;

import com.solvd.onlineshop.payment.CardType;
import com.solvd.onlineshop.exceptions.InvalidCardException;

public interface IPay {

	public default String pay(double amount) {
		String s = "Payment has been processed";
		return s;

	}

	String validateCard(String ccNumber, Date expDate, int cvcCode, Enum<CardType> card) throws InvalidCardException;

	
}
