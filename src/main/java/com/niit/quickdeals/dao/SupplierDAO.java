package com.niit.quickdeals.dao;

import java.util.List;

import com.niit.quickdeals.categorymodel.Supplier;

public interface SupplierDAO {

	public List<Supplier> list();

	public boolean save(Supplier supplier);

	public boolean update(Supplier supplier);

	public boolean delete(Supplier supplier);

	public boolean delete(String ID);

	public Supplier getSupplierByID(String id);

	public Supplier getSupplierByName(String name);

}
