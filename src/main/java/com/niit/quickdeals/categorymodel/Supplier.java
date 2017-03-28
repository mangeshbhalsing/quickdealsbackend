package com.niit.quickdeals.categorymodel;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Supplier")  //if the class name and table name is different
@Component   
public class Supplier {
		
	
	
	
	@Id
	private String id;
	
	@Column(name="name")
	@Min(5) //Min and maximum value
	@Max(15)
	private String name;
	
	
	private String address;
	
	@OneToMany(mappedBy="supplier" , fetch = FetchType.EAGER)
	private  Set<Product> products;
	
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}