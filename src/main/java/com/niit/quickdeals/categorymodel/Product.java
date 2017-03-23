package com.niit.quickdeals.categorymodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Product")
@Component
public class Product {
	
	@Id
	private String id;
	
	@Min(5)
	@Max(10)
	private String name;
	
	private String description;
	
	private String category_id;
	
	private String supplier_id;
	
	
	private String price;
	
	@ManyToOne
	@JoinColumn(name="category_id",updatable=false,insertable=false,nullable=false)
	private  Category category;
	
	@ManyToOne
	@JoinColumn(name="supplier_id",updatable=false,insertable=false,nullable=false)
	private Supplier supplier;
	

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

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
