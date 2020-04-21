package com.solvd.onlineshop;

import java.util.Date;

import com.solvd.onlineshop.payment.CardType;
import com.solvd.onlineshop.exceptions.InvalidCardException;
@FunctionalInterface
public interface IPay {
	
	public default void pay() {
		
		

	}

	String validateCard(String ccNumber, Date expDate, int cvcCode, Enum<CardType> card) throws InvalidCardException;

	
}
