package com.niit.quickdeals.testcase;

import static org.junit.Assert.assertEquals;

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

	//@Test
	 public void createProductTestcase() {
	
	 product.setId("1f1");
	 product.setName("mobiles02");
	 product.setPrice(25000);
	 product.setDescription("THIS IS THE MOBILE2 CALLED IPHONE");
	// product.setCategory_id("19");
	// product.setSupplier_id("SP02032017");
	
	 boolean flag = productDAO.save(product);
	
	 assertEquals("createProductTestcase()", true, flag);
	
	 }

	 @Test
	 public void updateProductTestCase() {
	
	 product.setId("11");
	 product.setName("mobiles_karboonK9");
	 product.setPrice(2000);
	 product.setDescription("THIS IS THE MOBILE CALLED Karboon");
	// product.setCategory_id("CG05032017");
	// product.setSupplier_id("SP01032017");
	
	 boolean flag = productDAO.update(product);
	
	 assertEquals("updateProductTestcase()", true, flag);
	
	 }

	// @Test
	 public void deleteTestCase(){
	
	 boolean flag = productDAO.delete("12");
	
	 assertEquals("deleteTestCase", true ,flag);
	 }

 // @Test
	public void deleteByProductTestCase() {

		product.setId("11");

		boolean flag = productDAO.delete(product);
		assertEquals("deleteByProductTestCase", true, flag);

	}

	//@Test // This is passing for bothERROR plzs correct
	public void getProductByNameTestCase() {

		product = productDAO.getProductByName("mobiles02");

		assertEquals("getProductByNameTestCase", product, product);

	}

	//@Test
	public void getProductByIdTestcase() {

		product = productDAO.getProductByID("1211");

		assertEquals("getProductByIdTestcase", null, product);

	}

	//@Test
	public void getallProductTestCase() {

		int size = productDAO.list().size();// It check the value of category
											// how many inserted and give the
											// value is stored in size.

		assertEquals("getallProductTestcase", 4, size);

	}

}
