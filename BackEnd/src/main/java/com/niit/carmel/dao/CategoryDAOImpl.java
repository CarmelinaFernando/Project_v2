package com.niit.carmel.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.carmel.model.Category;

@Repository

public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean insert(Category ob) {
		try{
		Session session = sessionFactory.openSession();
		session.save(ob);
		session.flush();
		session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
		
	//	System.out.println("Category Inserted");

	}

	public List<Category> getAllCategories() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Category");
		List<Category> categories = query.list();
		return categories;
	}

	public void delete(int catid) {

		Session session = sessionFactory.openSession();
		Category category = (Category) session.get(Category.class, catid);
		session.delete(category);
		session.flush();
		session.close();
		System.out.println("Category Deleted");
	}

}
