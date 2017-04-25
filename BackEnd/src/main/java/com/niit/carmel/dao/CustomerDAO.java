package com.niit.carmel.dao;

import com.niit.carmel.model.Customer;

public interface CustomerDAO 
{
	boolean saveCustomer(Customer customer);
	Customer getCustomerByUsername(String username);

}
