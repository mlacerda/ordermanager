package com.ciandt.arqref.ordermanager.facade.rs.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciandt.arqref.ordermanager.model.entity.Product;
import com.ciandt.arqref.ordermanager.service.ProductService;

/**
 * This class represents a Rest Service for Product Domain or Entity.
 */
@Component
@Path(value = "/product")
public class ProductRestFacade {

	/** The service. */
	@Autowired
	private ProductService service;
	
	/**
	 * Find all products.
	 *
	 * @return the products to
	 */
	@GET
	@Path(value = "/get-all")
	@Produces({ MediaType.APPLICATION_JSON+";charset=UTF-8" })
	public ProductsTO findAllProducts() {
		return new ProductsTO(service.findAllProducts());
	}	
	

	/**
	 * Gets the product by id.
	 *
	 * @param id the id
	 * @return the product by id
	 */
	@GET
	@Path(value = "/get/{id}")
	@Produces({ MediaType.APPLICATION_JSON+";charset=UTF-8"})
	public Product getProductById(@PathParam("id") Long id) {
		return service.findProductById(id);
	}	
}
