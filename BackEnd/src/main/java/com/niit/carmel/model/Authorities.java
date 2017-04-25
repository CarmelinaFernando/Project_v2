package com.niit.carmel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Authorities 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(unique = true)
	@NotEmpty(message = "enter the user name")
	String username;
	String role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString()
	{
		return "Authorities [id= "+ id +", username=" + username +", role= "+ role +"]";
	}

}
