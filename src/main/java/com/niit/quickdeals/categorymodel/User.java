package com.niit.quickdeals.categorymodel;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="User")  //if the class name and table name is different
@Component   
public class User {

	@Id
	private String id;
	
	@Column(name="name")
	@NotEmpty(message="User name should not be empty")
	private String name;
	

	@Min(5) 
	@Max(10)
	private String password;
	
	//@Column(unique=true ,nullable=false)
	//private String mail;
	 
	@NotEmpty(message="User contact should not be empty")
	private String contact;
	
	private String role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}*/

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
