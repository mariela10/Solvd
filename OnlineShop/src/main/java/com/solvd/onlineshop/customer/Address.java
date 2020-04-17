package com.solvd.onlineshop.customer;

public class Address {
	private String city;
	private String state;
	private int zipCode;

	public Address(String city, String state, int zipCode) {
		
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;

	}

	@Override
	public String toString() {
		return this.city + " " + this.state + " ," + this.zipCode ;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

}
