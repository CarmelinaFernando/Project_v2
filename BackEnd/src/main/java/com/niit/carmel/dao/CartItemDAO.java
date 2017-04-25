package com.niit.carmel.dao;

import com.niit.carmel.model.Cart;
import com.niit.carmel.model.CartItems;

public interface CartItemDAO 
{
	void addCartItem(CartItems cartItem);
	CartItems getCartItem(int cartItemId);
	void removeCartItem(CartItems cartItem);
	void removeAllCartItem(Cart cart);
}