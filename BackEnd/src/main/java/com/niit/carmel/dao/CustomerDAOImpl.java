package com.niit.carmel.dao;

import javax.management.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.carmel.model.Authorities;
import com.niit.carmel.model.Cart;
import com.niit.carmel.model.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	

	Logger logger = Logger.getLogger(CustomerDAOImpl.class);


	public boolean saveCustomer(Customer customer) {
		try{
		Session session= sessionFactory.openSession();
		logger.debug("============================================");
		customer.getUsers().setEnabled(true);
		
		// Assignment
				String username = customer.getUsers().getUsername();
				String role = "ROLE_USER";

				Authorities authorities = new Authorities();
				// set the values
				authorities.setUsername(username);
				authorities.setRole(role);

				session.save(authorities); // insert into authorites values
											// (?,?,'Role_USER');

				Cart cart = new Cart();
				customer.setCart(cart);

				cart.setCustomer(customer);// update cart set customer_id=? ,
											// grandtotal=? where cart_id=?

				session.save(customer);

				logger.debug("==========================================================================");
				session.flush();
				session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;	
		}
		return true;
		
	}

	public Customer getCustomerByUsername(String username) {
		Session session = sessionFactory.openSession();
		Query query = (Query) session.createQuery("from Users where username=?");
		//query.setString(0, username);
		//Users users = (Users) query.uniqueResult();
		// com.niit.model.Users
		//Customer customer = users.getCustomer();
		session.close();
		return null;

	
	}

}
