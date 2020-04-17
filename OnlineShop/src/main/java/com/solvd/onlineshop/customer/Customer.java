package com.solvd.onlineshop.customer;

import com.solvd.onlineshop.exceptions.InvalidAddressException;
import com.solvd.onlineshop.payment.CreditCard;

public class Customer {
	private String fname;
	private String lname;
	private Address billingAddress;
	private String emailAddress;
	private String phoneNumber;
	private CreditCard creditCard;
	
	
	public Customer () {}
	

	public Customer(String Fname, String Lname, Address billingAddress, String emailAddress,
			String phoneNumber, CreditCard creditCard ) {
		this.fname = Fname;
		this.lname = Lname;
		this.billingAddress = billingAddress;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.creditCard = creditCard;
		

	}

	public String fname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getlname() {
		return lname;
	}

	public void Lname(String Lname) {
		this.lname = lname;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber( String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Customer createCustomer(String Fname, String lname, Address billingAddress,
			String emailAddress, String phoneNumber) throws InvalidAddressException {
		if( !(billingAddress.getZipCode() >0) )
		 throw new InvalidAddressException("address is not valid");
		
		else return this;
	}

	public Object getCustomer(String Fname, String lname, Address billingAddress, String emailAddress,
			String phoneNumber) {

	

		return null;
	}

}
