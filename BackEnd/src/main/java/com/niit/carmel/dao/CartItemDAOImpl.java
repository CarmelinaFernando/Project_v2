package com.niit.carmel.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.carmel.model.Cart;
import com.niit.carmel.model.CartItems;

@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCartItem(CartItems cartItem) {
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(cartItem);
		session.flush();
		session.close();
		
	}

	public CartItems getCartItem(int cartItemId) {
		Session session=sessionFactory.openSession();
		CartItems cartItem=(CartItems)session.get(CartItems.class,cartItemId);
		session.flush();
		session.close();
		return cartItem;
	}

	public void removeCartItem(CartItems cartItem) {
		Session session=sessionFactory.openSession();
		session.delete(cartItem);
		session.flush();
		session.close();
	}

	public void removeAllCartItem(Cart cart) {
	
		List<CartItems> cartItems=cart.getCartItems();
		for(CartItems cartItem:cartItems){
			removeCartItem(cartItem);
		}
		}
		
	}
