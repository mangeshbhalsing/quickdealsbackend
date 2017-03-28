package com.niit.quickdeals.testcase;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.dao.CategoryDAO;



public class CategoryTestCase {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	//CategoryDAOImpl c = new CategoryDAOImpl
	
	
	

	@Autowired
	private static Category category;

	@Autowired
	private static CategoryDAO categoryDAO;

	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		category = (Category) context.getBean("category");

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}
	// TEST Cases to notify it we give @test annotation that test case are here

	// To Create the Table
	//@Test
	public void createCategoryTestCase() {
	
		category.setId("11dssds");
		category.setName(" Bat  th mobidsfasdleCategory");
		category.setDescription("This is Mobilsafase category");

		boolean flag = categoryDAO.save(category);

		assertEquals("createCategoryTestCase", true, flag);
		// compare what you are expecting Vs what we are getting from save
		// method
	}

	// Update the Table
	//@Test
	public void updateCategoryTestCase() {
		

		category.setId("13s");
		category.setName("new MObile Category");
		category.setDescription("THis is mobile category");

		boolean flag = categoryDAO.update(category);
		assertEquals("updateCategoryTestCase", true, flag);
	}

	//@Test
	public void deleteTestCase() {

		boolean flag = categoryDAO.delete("101s");
		assertEquals("deleteTestCase", true, flag);
	}

	//@Test
	public void deleteByCategoryTestCase() {

		category.setId("11s");

		boolean flag = categoryDAO.delete(category);

		assertEquals("deleteByCategoryTestCase", true, flag);

	}

	@Test
	public void getCategoryByIDTestCase() {

		category = categoryDAO.getCategoryByID("8s");
		assertEquals("getCategoryByIDTestCase", null, category);
	}

	//@Test
	public void getCategoryByNameTestCase() {

		category = categoryDAO.getCategoryByName(" Bat  th mobidsfasdleCategory");
		assertEquals("getCategoryByNameTestCase", null, category);
	}

	@Test // It tell the Junit to run this
	public void getallCategoryTestCase() {

		int size = categoryDAO.list().size();// It check the value of category
												// how many inserted and give
												// the value is stored in size.

		assertEquals("getallCategoryValuesTestCase", 5, size);
	}

}