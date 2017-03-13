package com.niit.quickdeals.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.dao.CategoryDAO;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOimpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// CategoryDAOImpl c = new CategoryDAOImpl

	/*
	 * @Autowired public CategoryDAOimpl(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 */

	public List<Category> list() {
		// select * from category -SQL Query - mention the table name
		// from Category -> HQL -mention Domain class name not table name

		// convert the hibernate query into db specific language
		return sessionFactory.getCurrentSession().createQuery("from Category").list();

	}

	public boolean save(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace(); // it will print the error in the console -
									// similar to SOP
			// package, class, method line number from which place you are
			// calling
			return false;
		}

	}

	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getCategoryByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public Category getCategoryByID(String id) {
		// select * from Category where id ='mobile'
		// return (Category)
		// sessionFactory.getCurrentSession().get(Category.class, id);

		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where id = '" + id + "'")
				.uniqueResult();

	}

	public Category getCategoryByName(String name) {

		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where name = '" + name + "'")
				.list().get(0);

	}

}
