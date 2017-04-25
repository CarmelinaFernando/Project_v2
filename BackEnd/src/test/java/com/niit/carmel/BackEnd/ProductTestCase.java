package com.niit.carmel.BackEnd;

import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.carmel.dao.ProductDAO;
import com.niit.carmel.dao.ProductDAOImpl;
import com.niit.carmel.model.Product;

public class ProductTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	
	static Product product;
	
	@Autowired
	static ProductDAO productDAO; 
	
	@BeforeClass
	public static void initailize()
	{
		product=new Product();
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.carmel");
		context.refresh();
		
		productDAO=context.getBean(ProductDAOImpl.class);
		
		product=context.getBean(Product.class);
		
	}
	
	@Test
	public void insertTestCase()
	{
		product.setId(1);
		product.setName("Labrador");
		product.setDescription("belongs to dog");
		product.setPrice(5000);
		product.setQuantity(1);
		
		boolean flag=productDAO.insert(product);
		assertEquals("",true,flag);
	}
	
	
}
