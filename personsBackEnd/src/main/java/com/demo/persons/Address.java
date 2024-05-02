package com.demo.persons;

import jakarta.validation.constraints.NotBlank;

public class Address {
	private @NotBlank(message = "Street is required.") String street;
	private @NotBlank(message = "Postal Code is required.") String postalCode;
	private @NotBlank(message = "City is required.") String city;

	public Address(String street, String postalCode, String city) {
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;

	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String streetName) {
		this.street = streetName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
