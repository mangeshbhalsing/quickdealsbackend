package com.niit.quickdeals.testcase;



import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.quickdeals.categorymodel.Supplier;
import com.niit.quickdeals.dao.SupplierDAO;


public class SupplierTestCase {

	@Autowired
	private static Supplier supplier;

	@Autowired
	private static SupplierDAO supplierDAO;

	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		supplier = (Supplier) context.getBean("supplier");

		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		
	}
	
	@Test
	public void createSupplierTestCase() {
		
		supplier.setId("2");
		supplier.setName("yash");
		supplier.setAddress("delhi");

		boolean flag = supplierDAO.save(supplier);

		assertEquals("createSupplierTestCase", true, flag);
		
	}
	
	@Test
		public void deleteByIdTestCase(){
			
			boolean flag = supplierDAO.delete("06");
			
			assertEquals("getProductByIdTestcase",true,flag);
			
			
		}
	
	
	@Test
	public void deleteBySupplierTestCase() {

		supplier.setId("07");

		boolean flag = supplierDAO.delete(supplier);

		assertEquals("deleteBySupplierTestCase", true, flag);

	}




	@Test
	public void updateSupplierTestCase() {
		
		supplier = new Supplier();
		supplier.setId("SP0");
		supplier.setName("fasd3333");
		supplier.setAddress("sfkjaslhdf");
		
		boolean flag = supplierDAO.update(supplier);
		
		assertEquals("updateSupplierTestCase",true, flag);
		
	}
	
	

	
	@Test
	public void getSupplierByIdTestcase() {

		supplier = supplierDAO.getSupplierByID("0121212");
		
		assertEquals("getSupplierByIdTestcase", null, supplier);
		
		System.out.println(supplier);
		
	}
	
	
	@Test
	public void getSupplierByNameTestCase() {

		supplier = supplierDAO.getSupplierByName("dssdsd");
		
		assertEquals("getSupplierByNameTestCase", null, supplier);
		
		
		
	}
	@Test 
	public void getallSupplierTestCase() {

		int size = supplierDAO.list().size();
		
		assertEquals("getallSupplierTestCase", 8, size);
		
	}

}
