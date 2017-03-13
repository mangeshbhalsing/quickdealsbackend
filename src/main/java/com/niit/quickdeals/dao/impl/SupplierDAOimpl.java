package com.niit.quickdeals.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.quickdeals.categorymodel.Supplier;
import com.niit.quickdeals.dao.SupplierDAO;

@Transactional
@Repository("supplierDAO")
public class SupplierDAOimpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Supplier> list() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			// TODO Auto-generated method stub
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			// TODO Auto-generated method stub
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		try {
			 sessionFactory.getCurrentSession().delete(getSupplierByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Supplier getSupplierByID(String id) {
		return (Supplier) sessionFactory.getCurrentSession().createQuery("from Category where id = '" + id + "'")
				.uniqueResult();
	}

	public Supplier getSupplierByName(String name) {
		return (Supplier) sessionFactory.getCurrentSession().createQuery("from Category where name = '" + name + "'")
				.list().get(0);
	}

}
