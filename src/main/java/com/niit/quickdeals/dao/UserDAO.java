package com.niit.quickdeals.dao;

import java.util.List;

import com.niit.quickdeals.categorymodel.User;



public interface UserDAO {


	public List<User> list();
	
	public User getUser(String id);
	
	public boolean save(User user);
	
	public boolean update(User user);
	
	public boolean validate(String id, String name);
	
	
	
}
