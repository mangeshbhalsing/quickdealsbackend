package com.niit.quickdeals.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.dao.CategoryDAO;

@Transactional
@Repository("CategoryDAO")
public class CategoryDAOimpl implements CategoryDAO {

	private static Logger log = LoggerFactory.getLogger(CategoryDAOimpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public CategoryDAOimpl(SessionFactory sessionFactory) {
		log.debug("Session Factory is Obtained");
		this.sessionFactory = sessionFactory;
		log.debug("Session Factory is Obtained");
	}

	public List<Category> list() {

		log.debug("running cat list");
		return sessionFactory.getCurrentSession().createQuery("from Category").list();

	}

	public boolean save(Category category) {
		log.debug("Save Method Started");
		try {
			sessionFactory.getCurrentSession().save(category);
			log.debug("starting save method DAOimpl");
			return true;
		} catch (Exception e) {
			e.printStackTrace(); // it will print the error in the console -
									// similar to SOP
			// package, class, method line number from which place you are
			// calling
			log.debug("saving method exception  DAOimpl");
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
