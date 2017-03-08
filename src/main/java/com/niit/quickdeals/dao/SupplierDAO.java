package com.niit.quickdeals.dao;



import java.util.List;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.categorymodel.Supplier;


public interface SupplierDAO {
	
	
	public List<Supplier> list();
	
	public boolean saveSupplier(Supplier supplier);
	
	public boolean updateSupplier(Supplier supplier);

	public boolean deleteSupplier(Supplier supplier);
	
	public boolean delete(String ID);
	
	public Category getCategoryByID(String id);
	
	public Category getCategoryByName(String name);
	

}
