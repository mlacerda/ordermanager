package com.ciandt.arqref.ordermanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciandt.arqref.ordermanager.dao.ProductDAO;
import com.ciandt.arqref.ordermanager.model.entity.Product;
import com.ciandt.arqref.ordermanager.service.ProductService;

/**
 * The Class ProductServiceImpl.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	private static final String PRODUCT_CACHE = "ProductCache";
	
	
	/** The product jpa dao. */
	@Autowired
	@Qualifier("jpa")
	private ProductDAO productJpaDAO;

	/**
	 * @see com.ciandt.arqref.ordermanager.service.ProductService#deleteProductById(com.ciandt.arqref.ordermanager.model.entity.Product)
	 */
	@Override
	@CacheEvict(value = PRODUCT_CACHE)
	public void deleteProductById(Long id) {
		productJpaDAO.deleteById(id);
	}

	/**
	 * @see com.ciandt.arqref.ordermanager.service.ProductService#findProductById(java.lang.Long)
	 */
	@Cacheable(PRODUCT_CACHE)
	public Product findProductById(Long id) {
		return productJpaDAO.findById(id);
	}

	/**
	 * @see com.ciandt.arqref.ordermanager.service.ProductService#findAllProducts()
	 */
	public List<Product> findAllProducts() {
		return productJpaDAO.findAll();
	}

	/**
	 * @see com.ciandt.arqref.ordermanager.service.ProductService#saveProduct(com.ciandt.arqref.ordermanager.model.entity.Product)
	 */
	@CacheEvict(value = PRODUCT_CACHE, key = "#product.id")
	public void saveProduct(Product product) {
		productJpaDAO.save(product);
	}

	/**
	 * @see com.ciandt.arqref.ordermanager.service.ProductService#updateProduct(com.ciandt.arqref.ordermanager.model.entity.Product)
	 */
	@CacheEvict(value = PRODUCT_CACHE, key = "#product.id")
	public Product updateProduct(Product product) {
		return productJpaDAO.update(product);
	}
}
