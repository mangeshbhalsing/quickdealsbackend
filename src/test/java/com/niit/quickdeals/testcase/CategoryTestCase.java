package com.niit.quickdeals.testcase;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
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
	@Test
	public void createCategoryTestCase() {
	
		category.setId("afd");
		category.setName(" Men wears ");
		category.setDescription("this is men category");

		boolean flag = categoryDAO.save(category);

		assertEquals("createCategoryTestCase", true, flag);
		// compare what you are expecting Vs what we are getting from save
		// method
	}
	
	//@Test
	public void updateCategoryTestCase() {
		

		category.setId("afassd");
		category.setName("Kid wears");
		category.setDescription("THis is Kid category");

		boolean flag = categoryDAO.update(category);
		assertEquals("updateCategoryTestCase", true, flag);
	}

	/*// Update the Table
	

	@Test
	public void deleteTestCase() {

		boolean flag = categoryDAO.delete("02");
		assertEquals("deleteTestCase", true, flag);
	}

	@Test
	public void deleteByCategoryTestCase() {

		category.setId("01");

		boolean flag = categoryDAO.delete(category);

		assertEquals("deleteByCategoryTestCase", true, flag);

	}

	@Test
	public void getCategoryByIDTestCase() {

		category = categoryDAO.getCategoryByID("Kid");
		assertEquals("getCategoryByIDTestCase", null, category);
	}
	@Test
	public void getCategoryByNameTestCase() {

		category = categoryDAO.getCategoryByName("111");
		assertEquals("getCategoryByNameTestCase", null, category);
	}

	@Test // It tell the Junit to run this
	public void getallCategoryTestCase() {

		int size = categoryDAO.list().size();// It check the value of category
												// how many inserted and give
												// the value is stored in size.

		assertEquals("getallCategoryValuesTestCase", 3, size);
	}*/

}