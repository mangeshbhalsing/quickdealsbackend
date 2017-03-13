package com.niit.quickdeals.testcase;



import static org.junit.Assert.assertEquals;

import org.junit.Assert;
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
    public static void init()
    {
    	AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
    	context.scan("com.niit");
    	context.refresh();
    	
    	supplier = (Supplier) context.getBean("supplier");
    	supplierDAO = (SupplierDAO) context.getBean("supplierDAO");	
    	
    }
    
    @Test
    public void createCategoryTestCase()
    {
  
    
    	supplier.setId("05");
    	supplier.setName("mobile category");
    	supplier.setAddress("beack queen");;
    
    
    boolean flag= supplierDAO.save(supplier);
    
    }
    
    @Test
    public void updateCategoryTestCase()
    {
 	   
    	supplier.setId("04");
    	supplier.setName("kid Category");
    	supplier.setAddress("This is kid category");
 	   
 	   boolean flag = supplierDAO.update(supplier);
 	   
 	   Assert.assertEquals( "updateCategoryTestCase" ,true, flag);
 	   
 	   
    }
    
    @Test
    public void deleteSupplierByIDTestCase()
    {
 	   
 	   boolean flag = supplierDAO.delete("03");
 	   
 	   Assert.assertEquals( "deleteSupplierByIDTestCase" ,true, flag);
 	   
 	   
 	   
    }
    
   // @Test
    public void deleteSupplierTestCase()
    {
    	supplier.setId("01");
 	   
 	   boolean flag = supplierDAO.delete(supplier);
 	   
 	   Assert.assertEquals( "deleteSupplierTestCase" ,true, flag);
 	   
 	   
 	   
    }
    
    @Test
    public void getCategoryByIDTestCase()
    {
 	   
    	supplier = supplierDAO.getSupplierByID("001");
 	  
 	  
 	 // Assert.assertNotNull("getCategoryByIDTestCase", category);
 	  
 	  
 	  assertEquals("getCategoryByIDTestCase", null, supplier);
 	   
    }
    
    
    @Test
    public void getCategoryByNameTestCase()
    {
 	   
    	supplier = supplierDAO.getSupplierByName("This is  laptop Category");
 	  
 	  
 	 // Assert.assertNotNull("getCategoryByIDTestCase", category);
 	  
 	  
 	  assertEquals("getCategoryByNameTestCase", null, supplier);
 	   
    }
    
    
    @Test
    public void getAllCategoriesTestCase()
    
    {
 	   
 	  int recordsFromDAO =  supplierDAO.list().size();
 	  
 	  assertEquals("getAllCategoriesTestCase" ,7 , recordsFromDAO);
 	   
    }
    
    
    
    
	
	}


