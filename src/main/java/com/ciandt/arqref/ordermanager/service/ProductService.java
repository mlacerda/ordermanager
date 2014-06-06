package com.ciandt.arqref.ordermanager.service;

import java.util.List;

import com.ciandt.arqref.ordermanager.model.entity.Product;

/**
 * The Interface for services related to Product.
 */
public interface ProductService {


	/**
	 * Delete product.
	 *
	 * @param id the product
	 */
	void deleteProductById(Long id);


	/**
	 * Find product.
	 *
	 * @param id the id
	 * @return the product
	 */
	Product findProductById(Long id);


	/**
	 * Find all products.
	 *
	 * @return the list
	 */
	List<Product> findAllProducts();


	/**
	 * Save product.
	 *
	 * @param product the product
	 */
	void saveProduct(Product product);


	/**
	 * Update product.
	 *
	 * @param product the product
	 * @return the product
	 */
	Product updateProduct(Product product);

}
