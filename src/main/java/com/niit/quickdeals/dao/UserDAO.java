package com.niit.quickdeals.dao;

import java.util.List;

import com.niit.quickdeals.categorymodel.User;

public interface UserDAO {

	public List<User> list();

	// public User getUser (String id);

	public boolean save(User user);

	// update category

	public boolean update(User user);

	// delete category by id
	public User getuserByID(String id);

	public boolean validation(String id, String password);

}
