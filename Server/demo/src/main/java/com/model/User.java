package com.model;

//This is the model class, here is built a simple User who will get your static variables, generic Constructor
// and getters/setters. 

public class User {
	
	private String firstName;
	private String lastName;
	private Integer age;
	private String country; 
	
	//Generic Constructor 
	public User() {
		super();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age=age;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country=country;
	}
}
