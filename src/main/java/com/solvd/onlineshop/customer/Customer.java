package com.solvd.onlineshop.customer;

import java.util.List;
import java.util.stream.Stream;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import com.solvd.onlineshop.exceptions.InvalidAddressException;
import com.solvd.onlineshop.payment.CreditCard;

public class Customer {
	private String fname;
	private String lname;
	private Address billingAddress;
	private String emailAddress;
	private String phoneNumber;
	private CreditCard creditCard;

	private static final Logger LOGGER = LogManager.getLogger(Customer.class);

	public Customer() {
	}

	public Customer(String Fname, String Lname, Address billingAddress, String emailAddress, String phoneNumber,
			CreditCard creditCard) {
		this.fname = Fname;
		this.lname = Lname;
		this.billingAddress = billingAddress;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.creditCard = creditCard;

		Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.ALL);

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

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Customer createCustomer(String Fname, String lname, Address billingAddress, String emailAddress,
			String phoneNumber) throws InvalidAddressException {
		if (!(billingAddress.getZipCode() > 0))
			throw new InvalidAddressException("address is not valid");

		else
			return this;
	}

	public Object getCustomer(String Fname, String lname, Address billingAddress, String emailAddress,
			String phoneNumber) {

		return null;
	}

	public void printCustomer() {
		List<String> ls = null;
		ls.add(this.fname);
		ls.add(this.lname);
		ls.add(this.emailAddress);
		ls.add(phoneNumber);

		Stream<String> stream = ls.stream();

		stream.forEach(p -> LOGGER.info(p));
		;

	}

}
