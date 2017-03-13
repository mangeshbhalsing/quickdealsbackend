package com.niit.quickdeals.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.quickdeals.categorymodel.User;

import com.niit.quickdeals.dao.UserDAO;

public class UserTestCase {

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

	/*@Test
	public void createCategoryTestCase() {

		user.setId("akash");
		user.setName("akash");
		user.setPassword("akash");
		user.setRole("user");
		user.setContact("222222222");

		boolean flag = userDAO.save(user);

		// Assert.assertEquals("createCategoryTestCase",true,flag);
	}
*/
	@Test
	public void validateCredentialsTestCase() {

		boolean flag = userDAO.validation("mb", "mb");

		assertEquals("validateCredentialsTestCase", true, flag);

	}

}
