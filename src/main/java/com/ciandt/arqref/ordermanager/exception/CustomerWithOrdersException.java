package com.ciandt.arqref.ordermanager.exception;

import com.ciandt.arqref.framework.exceptions.BusinessException;

/**
 * Violation thrown when a customer is removed with Orders relateds. 
 */
public class CustomerWithOrdersException extends BusinessException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new customer with orders exception.
	 */
	public CustomerWithOrdersException() {
		super("Customer with orders.");
	}
}
