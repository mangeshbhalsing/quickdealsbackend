package com.niit.quickdeals.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.quickdeals.categorymodel.Product;
import com.niit.quickdeals.dao.ProductDAO;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {

		return (Session) sessionFactory.getCurrentSession();

	}


	public List<Product> list() {

		return	sessionFactory.getCurrentSession().createQuery("from Product").list();

	}

	public boolean save(Product product) {
		try {
			getSession().save(product);
			//sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getProductByID(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Product product) {
		try {
			getSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Product getProductByID(String id) {
		//select * from Product where id ='cg031292'
		return (Product) getSession().createQuery(" from Product where id='"+id+"'").uniqueResult();
		
	}

	public Product getProductByName(String name) {
		return (Product) getSession().createQuery(" from Product where id='"+name+"'").uniqueResult();
	}

	@Override
	public boolean saveOrUpdate(Product product) {
		try {
			getSession().saveOrUpdate(product);
			//sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	
}
