package com.niit.quickdeals.categorymodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;



@Entity
@Table(name = "Category") // if the class name and table name is different
@Component // if want to create instance of Class Category - category
public class Category {

	// add simple properties - same as Category table
	// generate getter/setter methods

	@Id
	private String id;

	@Min(5)
	@Max(15)
	@Column(name="name")
	private String name;

	private String description;
	
/*	@OneToMany(mappedBy="category", fetch = FetchType.EAGER)
	private Set<Product> product;

	
	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
*/
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
