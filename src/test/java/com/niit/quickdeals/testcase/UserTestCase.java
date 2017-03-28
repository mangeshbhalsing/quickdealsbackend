package com.niit.quickdeals.testcase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.quickdeals.categorymodel.User;
import com.niit.quickdeals.dao.UserDAO;



public class UserTestCase {

	//@Autowired
	//private static AnnotationConfigApplicationContext context;

	@Autowired
	private static User user;

	@Autowired
	private static UserDAO userDAO;

	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		user = (User) context.getBean("user");

		userDAO = (UserDAO) context.getBean("userDAO");

	}

	

/*	@Test
	public void UpdateUserTestCase() {
		user.setId("UR12345");
		user.setName("asdf");
		user.setPassword("saf");
		user.setMail("asdf@gmail.com");
		user.setContact("5678700000");

		boolean flag = userDAO.update(user);

		assertEquals("UpdateUserTestCase", true, flag);

	}
	
	@Test
	public void validateCreationTestCase() {

		boolean flag = userDAO.validate("dsi", "sdf6");
		assertEquals("validateCreationTestCase", true, flag);

	}

	@Test
	public void getUserTestCase() 
	{

		user = userDAO.getUser("pr3d");
		assertEquals("getUserTestCase", null, user);

	}
	
	@Test
	public void getallUserTestCase() {

		int size = userDAO.list().size();

		assertEquals("getallUserTestCase", 3, size);
	}
	*/
	@Test
	public  void createUserTestCase(){
		
		user = new User();//BECAUSE IT IS GIVING NULL POINTER EXCEPTION.
		
		user.setId("mb");
		user.setName("mb");
		user.setPassword("mb");
		//user.setMail("mb@gmail.com");
		user.setContact("111111111");
		user.setRole("Admin");
		
		 boolean flag=userDAO.save(user);
		 
		 assertEquals ("createUserTestcase",true, flag);
		
		
	}

}
