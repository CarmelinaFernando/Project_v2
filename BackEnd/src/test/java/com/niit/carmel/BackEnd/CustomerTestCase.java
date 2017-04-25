package com.niit.carmel.BackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.carmel.dao.CustomerDAO;
import com.niit.carmel.dao.CustomerDAOImpl;
import com.niit.carmel.model.Customer;

public class CustomerTestCase {
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	static Customer customer;
	
	@Autowired
	static CustomerDAO customerDAO;
	
	@BeforeClass 
	public static void initailize()
	{
		customer=new Customer();
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.carmel");
		context.refresh();
		
		customerDAO=context.getBean(CustomerDAOImpl.class);
		 customer=context.getBean(Customer.class);
				
	}
	
	@Test
	public static void insertTestCase()
	{
		customer.setId(1);
		customer.setFirstName("Carmelina");
		customer.setLastName("Fernando");
		customer.setEmail("fernando_carmelina@yahoo.in");
		customer.setPhoneNumber("9742147395");
		
		boolean flag=customerDAO.saveCustomer(customer);
		assertEquals("",true,flag);
	}
	
	

}
