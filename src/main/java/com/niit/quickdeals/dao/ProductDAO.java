package com.niit.quickdeals.dao;

import java.util.List;

import com.niit.quickdeals.categorymodel.Product;

public interface ProductDAO {

	public List<Product> list();

	public boolean save(Product product);

	public boolean udpate(Product product);

	public boolean delete(Product product);

	public Product getProductByName(String name);

	public Product getProductById(String id);

}
