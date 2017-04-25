package com.niit.carmel.dao;

import java.util.List;

import com.niit.carmel.model.Category;

public interface CategoryDAO {
	
	public boolean insert(Category ob);
	public List<Category> getAllCategories();
	public void delete(int catid);
	
	/*

	public Category getCategoryData(int catid);

	public void updateCategory(int id);
*/

}
