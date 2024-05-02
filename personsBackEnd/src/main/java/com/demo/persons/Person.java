package com.demo.persons;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class Person {
	private String id;
	private @NotBlank(message = "First name is required.") String firstName;
	private @NotBlank(message = "Last name is required.") String lastName;
	private @NotBlank(message = "Social security number is required.") String socialSecurityNumber;
	private @NotBlank(message = "Phone number is required.") String phoneNumber;
	private @Valid Address address;

	public Person(String firstName, String lastName, String socialSecurityNumber, String phoneNumber, Address address) {
		this.id = HelperClass.generateUniqueID();
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.phoneNumber = phoneNumber;
		this.address = address;

	}

	// only getter, not able to change after creation
	public String getId() {
		return id;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
