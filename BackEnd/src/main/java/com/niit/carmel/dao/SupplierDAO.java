package com.niit.carmel.dao;

import java.util.List;

import com.niit.carmel.model.Supplier;

public interface SupplierDAO 
{
	public boolean insert(Supplier ob);
	public List<Supplier> getAllSuppliers();
	public boolean delete(int supid);
	
}
