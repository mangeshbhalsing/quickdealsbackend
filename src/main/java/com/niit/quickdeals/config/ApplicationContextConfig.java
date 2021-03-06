package com.niit.quickdeals.config;


import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.categorymodel.MyCart;
import com.niit.quickdeals.categorymodel.Product;
import com.niit.quickdeals.categorymodel.Supplier;
import com.niit.quickdeals.categorymodel.User;




@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		
		sessionBuilder.addProperties(getHibernateProperties());
		
		sessionBuilder.addAnnotatedClasses(Category.class);
		
		sessionBuilder.addAnnotatedClass(Supplier.class);
		
		sessionBuilder.addAnnotatedClass(Product.class);
		
		sessionBuilder.addAnnotatedClass(User.class);
		
		sessionBuilder.addAnnotatedClass(MyCart.class);
		
		return sessionBuilder.buildSessionFactory();
	}
	

	
	
	

	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/NIITDB");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("mangesh");
		dataSource.setPassword("mangesh");
		
		
		
		return dataSource;
	}

	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		
		
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		
		return properties;
	}

		
	

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
		
	}

	

}
