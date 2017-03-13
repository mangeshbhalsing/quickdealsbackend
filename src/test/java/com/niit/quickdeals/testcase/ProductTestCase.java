package com.niit.quickdeals.testcase;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.internal.SessionFactoryBuilderImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.quickdeals.categorymodel.Product;

import com.niit.quickdeals.dao.ProductDAO;

public class ProductTestCase {

	@Autowired
	private static Product product;
	@Autowired
	private static ProductDAO productDAO;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		product = (Product) context.getBean("product");
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	@Test
	public void createProductTestCase() {

		product.setId("01");
		product.setCategory_id("02");
		product.setDescription("iphone 7s");
		product.setName("iphone");
		product.setPrice("60000");
		product.setSupplier_id("01");

		boolean flag = productDAO.save(product);
		Assert.assertEquals("createCategoryTestCase", true, flag);

	}

	@Test
	public void updateCategoryTestCase() {

		product.setId("02");
		product.setName("iphone");
		product.setDescription("iphone 7s");
		product.setName("iphone");
		product.setPrice("60000");
		product.setSupplier_id("01");

		boolean flag = productDAO.udpate(product);

		Assert.assertEquals("updateCategoryTestCase", true, flag);
	}

	@Test
	public void deleteProductTestCase() {
		product.setId("02");
		boolean flag = productDAO.delete(product);
		Assert.assertEquals("deleteProductByIDTestCase", true, flag);

	}
	
	
	@Test
	public void getCategoryByIDTestCase() {

		product = productDAO.getProductById("02");

		// Assert.assertNotNull("getCategoryByIDTestCase", category);

		assertEquals("getCategoryByIDTestCase", null, product);

	}

	@Test
	public void getCategoryByNameTestCase() {

		product = productDAO.getProductByName("This is  laptop Category");

		// Assert.assertNotNull("getCategoryByIDTestCase", category);

		assertEquals("getpProductByNameTestCase", null, product);

	}

	@Test
	public void getAllProductTestCase()

	{

		int recordsFromDAO = productDAO.list().size();

		assertEquals("getAllCategoriesTestCase", 7, recordsFromDAO);

	}

	
}
