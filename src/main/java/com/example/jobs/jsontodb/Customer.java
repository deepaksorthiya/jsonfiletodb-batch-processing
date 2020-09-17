package com.example.jobs.jsontodb;

public class Customer {

	private String lastName;
	private String firstName;
	private String city;
	private String country;

	public Customer() {
	}

	public Customer(String lastName, String firstName, String city, String country) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.city = city;
		this.country = country;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [lastName=" + lastName + ", firstName=" + firstName + ", city=" + city + ", country=" + country
				+ "]";
	}

}
