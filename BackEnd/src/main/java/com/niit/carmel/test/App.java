package com.niit.carmel.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.carmel.dao.CartDAO;
import com.niit.carmel.dao.CartItemDAO;
import com.niit.carmel.model.Cart;
import com.niit.carmel.model.CartItems;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.carmel");
		context.refresh();
		
		// For Category
		/*Category category=new Category();
		
		category.setId(2);
		category.setCategoryName("Cat");
		category.setCategoryDetails("They can give birth to babies");
		
		CategoryDAO categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		categoryDAO.insert(category);
		
		List<Category> categories= categoryDAO.getAllCategories();
		System.out.println(categories);
		
		categoryDAO.delete(3);
		
		// For Supplier
		Supplier supplier=new Supplier();
		
		supplier.setId(4);
		supplier.setSupplierName("Arun");
		supplier.setSupplierAddress("34, 12th cross, Austin Town, bangalore-40 ");
		
		SupplierDAO supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		supplierDAO.insert(supplier);
		
		List<Supplier> suppliers=supplierDAO.getAllSuppliers();
		System.out.println(suppliers);
		
		supplierDAO.delete(3);
		
		 // For Cart
		   
		Cart cart=new Cart();
		
		cart.setId(1);
		cart.setGrandTotal(3000);
		CartDAO cartDAO=(CartDAO)context.getBean("cartDAO");
		cartDAO.getCart(1);
	
		//For CartItem
		
		CartItems cartItem=new CartItems();
		
		cartItem.setId(1);
		cartItem.setQuantity(3);
		cartItem.setTotalPrice(3000);
		
		CartItemDAO cartItemDAO=(CartItemDAO)context.getBean("carItemDAO");
		cartItemDAO.addCartItem(cartItem);*/
		
	}

}
