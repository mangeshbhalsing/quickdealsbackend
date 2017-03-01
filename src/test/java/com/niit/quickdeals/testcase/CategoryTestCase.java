package com.niit.quickdeals.testcase;

import static org.junit.Assert.*;

import java.util.Locale.Category;
import com.niit.quickdeals.dao.CategoryDAO;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {
	@Autowired
	private static Category category;
    @Autowired
	private static CategoryDAO categoryDAO;
    
    public static  void init()
    {
    	AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
    	context.scan("com.niit");
    	context.refresh();
    	
    	category =(Category) context.getBean("category");
    	categoryDAO =(CategoryDAO) context.getBean("categoryDAO");
    	
    	
    	
    }
    
    

}
