package com.solvd.onlineshop.payment;

public enum CardType {
	
	
	VISA(16,3,4),MASTERCARD(16,3,5),DISCOVERY(16,3,6),AMERICAN_EXPRESS(16,4,3);
	
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCvcDigits() {
		return cvcDigits;
	}
	public void setCvcDigits(int cvcDigits) {
		this.cvcDigits = cvcDigits;
	}
	public int getFirstNumber() {
		return firstNumber;
	}
	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}
	private int cardNumber;
	private int cvcDigits;
	private int firstNumber;
   
	
	
	
	CardType(int cardNumber,int cvcDigits,int firstNumber) {
		this.cardNumber=cardNumber;
		this.cvcDigits=cvcDigits;
		this.firstNumber=firstNumber;
	}
		
}


