package com.niit.quickdeals.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.quickdeals.categorymodel.Product;
import com.niit.quickdeals.dao.ProductDAO;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	public SessionFactory sessionFactory;

	public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("from product").list();
	}

	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			// TODO Auto-generated method stub
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean udpate(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			// TODO Auto-generated method stub
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Product getProductByName(String name) {
		return (Product) sessionFactory.getCurrentSession().createQuery("from Category where name = '" + name + "'")
				.list().get(0);
	}

	public Product getProductById(String id) {
		return (Product) sessionFactory.getCurrentSession().createQuery("from product where id = '" + id + "'")
				.uniqueResult();
	}

	public boolean delete(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			// TODO Auto-generated method stub
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
