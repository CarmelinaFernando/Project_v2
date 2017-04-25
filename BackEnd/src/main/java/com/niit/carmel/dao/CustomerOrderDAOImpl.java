package com.niit.carmel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.carmel.model.Cart;
import com.niit.carmel.model.CartItems;
import com.niit.carmel.model.CustomerOrder;
@Repository
public class CustomerOrderDAOImpl implements CustomerOrderDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public void addCustomerOrder(Cart cart) {
		CustomerOrder customerOrder=new CustomerOrder();
		customerOrder.setCart(cart);
		customerOrder.setCustomer(cart.getCustomer());
		customerOrder.setBillingAddress(cart.getCustomer().getBillingAddress());
		customerOrder.setShippingAddress(cart.getCustomer().getShippingAddress());
		//Insert the data in CustomerOrder table
		Session session=sessionFactory.openSession();
		session.save(customerOrder);
		
		//To update grandtotal in Cart table
		
		List<CartItems> cartItems=cart.getCartItems();
		double grandTotal=0.0;
		for(CartItems cartItem:cartItems){
			grandTotal=grandTotal + cartItem.getTotalPrice();
		}
		cart.setGrandTotal(grandTotal);
		//update cart set grandtotal=? where cartid=?
		session.update(cart);
		session.flush();
		session.close();
		}
		
	}

