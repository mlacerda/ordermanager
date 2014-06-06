package com.ciandt.arqref.ordermanager.facade.rs.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.ciandt.arqref.ordermanager.model.entity.Product;

/**
 * The Class ProductsTO. Used to hold a list of Products using JAXB. 
 */
@XmlRootElement(name="products")
public class ProductsTO {
	
    /** The product list. */
    private List<Product> productList;
    
	/**
	 * Instantiates a new products to.
	 */
	public ProductsTO() {
	}

	/**
	 * Instantiates a new products to.
	 *
	 * @param productList the product list
	 */
	public ProductsTO(List<Product> productList) {
		this.productList = productList;
	}

	/**
	 * Gets the product list.
	 *
	 * @return the product list
	 */
	public List<Product> getProductList() {
		return productList;
	}

	/**
	 * Sets the product list.
	 *
	 * @param productList the new product list
	 */
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}	
}
