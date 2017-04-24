package com.niit.quickdeals.dao;

import java.util.List;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.categorymodel.MyCart;



public interface CartDAO {
	
	
	
	public List<MyCart> list(String userID);
	
	public boolean save(MyCart myCart);
	
	public Long getTotalAmount(String userID);
	
	public Long getMaxId();
	
	public boolean saveorUpdate(MyCart myCart);
	
	public boolean delete(String id);
	
	public MyCart getCartByID(String id);
	
	
	

}
