package com.niit.carmel.dao;

import java.util.List;

import com.niit.carmel.model.Product;

public interface ProductDAO {

	public boolean insert(Product ob);

	public void delete(int prodid);

	public List<Product> retrieve();

	public Product getProductData(int prodid);

	public void updateProduct(int id);

}
