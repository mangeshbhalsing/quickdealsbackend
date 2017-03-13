package com.niit.quickdeals.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.categorymodel.User;
import com.niit.quickdeals.dao.UserDAO;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	public List<User> list() {
		
		 return	getSession().createQuery("from User").list();
		 
	}
	
	public boolean save(User user) {
		try {
			getSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}


	public boolean validation(String id, String password) {
		String hql="from User where id ='"+id+"'and password='"+password+"'";
		if(getSession().createQuery(hql).uniqueResult()==null){
		return false;
		
			
		}
		return true;
	}

	public User getuserByID(String id) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where id = '" + id + "'")
				.uniqueResult();
	}

/*	public User getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	

}
