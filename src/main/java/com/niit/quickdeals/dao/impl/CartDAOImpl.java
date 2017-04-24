package com.niit.quickdeals.dao.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.categorymodel.MyCart;
import com.niit.quickdeals.dao.CartDAO;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {
	private static Logger log = LoggerFactory.getLogger(CartDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl() {

	}

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<MyCart> list(String userID) {
		log.debug("Starting of the method list");
		String hql = "from MyCart where user_id=" + "'" + userID + "'  and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method list");
		return query.list();

	}

	@Transactional
	public boolean save(MyCart myCart) {
		try
		{
		/*Session session= 	sessionFactory.openSession();
		Transaction tx= session.getTransaction();
		tx.begin();
		session.*/
			//myCart.setId(getMaxId());
		myCart.setId(getMaxId());
		sessionFactory.getCurrentSession().save(myCart);
		
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
	}

	@Transactional
	public Long getTotalAmount(String userID) {
		log.debug("Starting of the method getTotalAmount");
		String hql = "select sum(price) from MyCart where user_id=" + "'" + userID + "' " + "  and status = " + "'N'";
		log.debug("hql" + hql);

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method getTotalAmount");
		return (Long) query.uniqueResult();

	}

	public Long getMaxId() {
		log.debug("->->Starting of the method getMaxId");

		Long maxID = 100L;
		try {
			String hql = "select max(id) from MyCart";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			maxID = (Long) query.uniqueResult();
		} catch (HibernateException e) {
			log.debug("It seems this is first record. setting initial id is 0 :");
			maxID = 100L;
			e.printStackTrace();
		}
		log.debug("Max id :" + maxID);
		return maxID + 1;

	}

	@Override
	public boolean saveorUpdate(MyCart myCart) {
		try
		{
		/*Session session= 	sessionFactory.openSession();
		Transaction tx= session.getTransaction();
		tx.begin();
		session.*/
			//myCart.setId(getMaxId());
		sessionFactory.getCurrentSession().saveOrUpdate(myCart);
		
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
	}

	@Override
	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getCartByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public MyCart getCartByID(String id) {
		//select * from Category where id ='mobile'
		//  return	(Category)  sessionFactory.getCurrentSession().get(Category.class, id);
		  
		  return  (MyCart) sessionFactory.getCurrentSession().createQuery("from MyCart where id = '"+id + "'").uniqueResult();
			
		}
	}



