package com.ciandt.arqref.ordermanager.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import com.ciandt.arqref.ordermanager.model.entity.Product;
import com.ciandt.arqref.ordermanager.test.OrderManagementAbstractTest;

public class ProductServiceTest extends OrderManagementAbstractTest {
	@Autowired
	private ProductService productService;

	@Qualifier("cacheManager")
	@Autowired
	private CacheManager cacheManager;

	@Test
	public void testCache() {
		Long productId = 1001L;
		Cache productCache = cacheManager.getCache("ProductCache");
		assertNull("Initial cache not empty", productCache.get(productId));
		
		
		Product product = productService.findProductById(1001L);
		assertNotNull("Product not found", product);
		assertNotNull("Product not cached", productCache.get(productId));
		

		product = productService.updateProduct(product);
		assertNull("Product not removed from cache", productCache.get(productId));


		product = productService.findProductById(1001L);
		assertNotNull("Product not found", product);
		assertNotNull("Product not cached", productCache.get(productId));
	}
}
