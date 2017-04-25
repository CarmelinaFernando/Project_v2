package com.niit.carmel.BackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.carmel.dao.CategoryDAO;
import com.niit.carmel.dao.CategoryDAOImpl;
import com.niit.carmel.model.Category;

public class CategoryTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	
	static Category category;
	
	@Autowired
	static CategoryDAO categoryDAO; 
	
	@BeforeClass
	public static void initailize()
	{
		category=new Category();
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.carmel");
		context.refresh();
		
		categoryDAO=context.getBean(CategoryDAOImpl.class);
		
		category=context.getBean(Category.class);
		
	}
	
	@Test
	public void insertTestCase()
	{
		category.setId(1);
		category.setCategoryName("dogs");
		category.setCategoryDetails("mammal");
		
		boolean flag=categoryDAO.insert(category);
		assertEquals("",true,flag);
	}

}
