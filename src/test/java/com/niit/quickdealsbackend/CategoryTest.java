package com.niit.quickdealsbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.quickdeals.categorymodel.Category;

public class CategoryTest {
	
	public static  void main(String arg[]){
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		//context.getBean("Category");
		Category c= (Category) context.getBean("category");
		System.out.println("category instance created");
		
		
	}

}
