package com.ciandt.arqref.ordermanager.dao;

import java.util.List;

import com.ciandt.arqref.framework.persistence.AbstractDAO;
import com.ciandt.arqref.ordermanager.model.entity.Product;

/**
 * Data access object for the Product entity.
 */
public interface ProductDAO extends AbstractDAO<Product> {

	/**
	 * Find all product by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	List<Product> findByName(String name);

	/**
	 * Find all products by description.
	 *
	 * @param name the name
	 * @return the list
	 */
	List<Product> findByDescription(String name);

}
