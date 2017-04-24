package com.niit.quickdeals.testcase;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.categorymodel.MyCart;
import com.niit.quickdeals.dao.CartDAO;
import com.niit.quickdeals.dao.CategoryDAO;



public class CartTestCase {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	//CategoryDAOImpl c = new CategoryDAOImpl
	
	
	

	@Autowired
	private static MyCart myCart;
	

	@Autowired
	private static CartDAO cartDAO;

	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		myCart = (MyCart) context.getBean(MyCart.class);
		
		cartDAO = (CartDAO) context.getBean("cartDAO");

	}
	// TEST Cases to notify it we give @test annotation that test case are here

	// To Create the Table
	//@Test
	public void createCartTestCase() {
	
		
	//myCart.setId(101l);
		myCart.setPrice(200);
		myCart.setProduct_id("04");
		myCart.setProduct_name("Casual-Shirt");
		myCart.setUser_id("user");
		myCart.setQuantity("11");
		
	
		
	boolean flag =	cartDAO.save(myCart);

		

	assertEquals("createCartTestCase", true, flag);
		// compare what you are expecting Vs what we are getting from save
		// method
	}
	//@Test
	public void deleteTestCase() {

		boolean flag = cartDAO.delete("103");
		assertEquals("deleteTestCase", true, flag);
	}
	
}
