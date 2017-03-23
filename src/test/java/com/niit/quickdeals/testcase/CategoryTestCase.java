package com.niit.quickdeals.testcase;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.dao.CategoryDAO;

public class CategoryTestCase {
	
	private static Logger log = LoggerFactory.getLogger(CategoryTestCase.class);


	@Autowired
	private static Category category;

	@Autowired
	private static CategoryDAO categoryDAO;

	@BeforeClass
	public static void init() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.quickdeals");
		
		context.refresh();

		category = (Category) context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("CategoryDAO");

	}

	@Test
	public void createCategoryTestCase() {
		
		
		
		category.setId("1S");
		
		category.setName("laptop category");
		category.setDescription("this is laptop category");
		
		log.debug("Calling save method of categoryDAO");
		
		boolean flag = categoryDAO.save(category);
		log.debug("Test Case Result is Retrived");

		Assert.assertEquals("createCategoryTestCase", true, flag);
		
	}

	//@Test
	public void updateCategoryTestCase() {

		category.setId("02");
		category.setName("kid Category");
		category.setDescription("this is kid category");

		boolean flag = categoryDAO.update(category);

		Assert.assertEquals("updateCategoryTestCase", true, flag);

	}

	//@Test
	public void deleteCategoryByIDTestCase() {

		boolean flag = categoryDAO.delete("01");

		Assert.assertEquals("deleteCategoryByIDTestCase", true, flag);

	}

	//@Test
	public void deleteCategoryTestCase() {
		category.setId("006");

		boolean flag = categoryDAO.delete(category);

		Assert.assertEquals("deleteCategoryTestCase", true, flag);

	}

	//@Test
	public void getCategoryByIDTestCase() {

		category = categoryDAO.getCategoryByID("007");

		// Assert.assertNotNull("getCategoryByIDTestCase", category);

		assertEquals("getCategoryByIDTestCase", null, category);

	}

	//@Test
	public void getCategoryByNameTestCase() {

		category = categoryDAO.getCategoryByName("This is  laptop Category");

		// Assert.assertNotNull("getCategoryByIDTestCase", category);

		assertEquals("getCategoryByNameTestCase", null, category);

	}

	//@Test
	public void getAllCategoriesTestCase()

	{

		int recordsFromDAO = categoryDAO.list().size();

		assertEquals("getAllCategoriesTestCase", 7, recordsFromDAO);

	}

}
