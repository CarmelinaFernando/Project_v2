package com.niit.carmel.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.carmel.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean insert(Product ob) {
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
		//System.out.println("Product Inserted");
	}

	public void delete(int prodid) {
		
		Session session = sessionFactory.openSession();
		Product ob = (Product) session.get(Product.class, prodid);
		session.delete(ob);
		session.flush();
		session.close();
		System.out.println("Product Deleted");
	}

	@SuppressWarnings("unchecked")
	public List<Product> retrieve() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Product");
		List<Product> ob = (List<Product>) q.list();
		return ob;
	}

	public Product getProductData(int prodid) {

		return (Product) sessionFactory.openSession().get(Product.class, prodid);

	}

	public void updateProduct(int id) {
		Session session = sessionFactory.openSession();
		Product prod = (Product) session.get(Product.class, id);
		session.update(prod);
		System.out.println("Product Updated");
	}

}
