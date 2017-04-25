package com.niit.carmel.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.carmel.model.Cart;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public Cart getCart(int cartId) {
		Session session=sessionFactory.openSession();
		Cart cart=(Cart)session.get(Cart.class, cartId);
		session.close();
		return cart;
	}

}
