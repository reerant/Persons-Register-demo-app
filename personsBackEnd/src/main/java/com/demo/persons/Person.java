package com.demo.persons;

public class Person {
	private long id;
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private String phoneNumber;
	private Address address;

	public Person(String firstName, String lastName, String socialSecurityNumber, String phoneNumber, Address address) {
		this.id = UniqueIDGenerator.generateUniqueID();
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.phoneNumber = phoneNumber;
		this.address = address;

	}

	// only getter, not able to change after creation
	public long getId() {
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
