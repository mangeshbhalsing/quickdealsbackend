package com.niit.quickdeals.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.quickdeals.categorymodel.User;
import com.niit.quickdeals.dao.UserDAO;

public class UserTestCase {

	// @Autowired
	// private static AnnotationConfigApplicationContext context;

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

	
	  @Test public void UpdateUserTestCase()
	  {
		  user.setId("vt");
		  user.setName("asdsdf");
		  user.setPassword("ssdfaf");
		  user.setContact("567adsf0000");
	  
	  boolean flag = userDAO.update(user);
	  
	  assertEquals("UpdateUserTestCase", true, flag);
	  
	 }
	  
	  //@Test
	  public void validateCreationTestCase() {
	  
	  boolean flag = userDAO.validate("mb", "mb");
	  assertEquals("validateCreationTestCase", true, flag);
	  
	  }
	  
	  //@Test
	  public void getUserTestCase() {
	 
	  user = userDAO.getUser("heena");
	  assertEquals("getUserTestCase", null,
	  user);
	  
	  }
	  
	 //@Test
	 public void getallUserTestCase() {
	  
	  int size = userDAO.list().size();
	  
	  assertEquals("getallUserTestCase", 8, size); }
	
	//@Test
	public void createUserTestCase() {

		user = new User();// BECAUSE IT IS GIVING NULL POINTER EXCEPTION.

		user.setId("ma");
		user.setName("ma");
		user.setPassword("ma");
		// user.setMail("ma@gmail.com");
		user.setContact("23423333333");
		user.setRole("Admin");

		boolean flag = userDAO.save(user);

		assertEquals("createUserTestcase", true, flag);

	}

}
