package com.niit.carmel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ShippingAddress 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@NotEmpty(message = "please enter the apartmentnumber")
	String apartmentNumber;
	
	@NotEmpty(message = "please enter the streetname")
	String streetName;
	
	@NotEmpty(message = "please enter the city")
	String city;
	
	@NotEmpty(message = "please enter the state")
	String state;
	
	@NotEmpty(message = "please enter the country")
	String country;
	
	@NotEmpty(message = "please enter the zipcode")
	String zipcode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	@Override
	public String toString()
	{
		return "ShippingAddress [id= " + id +", apartmentNumber= " + apartmentNumber +",streetName= " + streetName +",city= " + city +",state= " + state +",country= " + country +",zipcode= " + zipcode +"]";
	}

}
