package com.niit.quickdeals.dao;

import java.util.List;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.categorymodel.User;

public interface UserDAO{
	
public 	List <User> list();

public boolean save(User user);

// update category

public boolean update(User user);

// delete category by id

public boolean delete(String id);

// delete category by category

public boolean delete(User user);

// get category by id

public Category getUserByID(String id);

// get category by name
public Category getUserByName(String name);




	
	
	

}
