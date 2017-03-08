package com.niit.quickdeals.testcase;

import static org.junit.Assert.*;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.dao.CategoryDAO;


public class CategoryTestCase {
	
	@Autowired
	private static Category category;

	@Autowired
	private static CategoryDAO categoryDAO;
	
    
    @BeforeClass
    public static void init()
    {
    	AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
    	context.scan("com.niit");
    	context.refresh();
    	
    	category = (Category) context.getBean("category");
    	categoryDAO = (CategoryDAO) context.getBean("categoryDAO");	
    	
    }
    @Test
    public void createCategoryTestCase()
    {
    
    category.setId("006");
    category.setName("laptop category");
    category.setDescription("this is laptop category");
    
    
    boolean flag= categoryDAO.save(category);
    
   // Assert.assertEquals("createCategoryTestCase",true,flag);	
    }
 
    
    @Test
    public void updateCategoryTestCase()
    {
 	   
 	   category.setId("003");
 	   category.setName("kid Category");
 	   category.setDescription("This is kid category");
 	   
 	   boolean flag = categoryDAO.update(category);
 	   
 	   Assert.assertEquals( "updateCategoryTestCase" ,true, flag);
 	   
 	   
    }
    
    
  @Test
    public void deleteCategoryByIDTestCase()
    {
 	   
 	   boolean flag = categoryDAO.delete("CG02032017");
 	   
 	   Assert.assertEquals( "deleteCategoryByIDTestCase" ,true, flag);
 	   
 	   
 	   
    }
    
    @Test
    public void deleteCategory()
    {
 	   category.setId("CG02032017");
 	   
 	   boolean flag = categoryDAO.delete(category);
 	   
 	   Assert.assertEquals( "deleteCategoryTestCase" ,true, flag);
 	   
 	   
 	   
    }
    
    
    @Test
    public void getCategoryByIDTestCase()
    {
 	   
 	  category = categoryDAO.getCategoryByID("CG01032017ABCD");
 	  
 	  
 	 // Assert.assertNotNull("getCategoryByIDTestCase", category);
 	  
 	  
 	  assertEquals("getCategoryByIDTestCase", null, category);
 	   
    }
    
    
    @Test
    public void getCategoryByNameTestCase()
    {
 	   
 	  category = categoryDAO.getCategoryByName("Mobile Category");
 	  
 	  
 	 // Assert.assertNotNull("getCategoryByIDTestCase", category);
 	  
 	  
 	  assertEquals("getCategoryByNameTestCase", null, category);
 	   
    }
    
    
    @Test
    public void getAllCategoriesTestCase()
    
    {
 	   
 	  int recordsFromDAO =  categoryDAO.list().size();
 	  
 	  assertEquals("getAllCategoriesTestCase" ,7 , recordsFromDAO);
 	   
    }
    
    

}
