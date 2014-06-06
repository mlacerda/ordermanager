package com.ciandt.arqref.ordermanager.service;

import java.util.List;

import com.ciandt.arqref.ordermanager.exception.CustomerWithOrdersException;
import com.ciandt.arqref.ordermanager.model.entity.Customer;

/**
 * The Interface for services related to Customer.
 */
public interface CustomerService {

	/**
	 * Delete customer by id.
	 *
	 * @param id the id
	 * @throws CustomerWithOrdersException the customer with orders exception
	 */
	void deleteCustomerById(Long id) throws CustomerWithOrdersException;
	
	/**
	 * Find customer by id.
	 *
	 * @param id the id
	 * @return the customer
	 */
	Customer findCustomerById(Long id);


	/**
	 * Find all customers.
	 *
	 * @return the list
	 */
	List<Customer> findAllCustomers();


	/**
	 * Save customer.
	 *
	 * @param customer the customer
	 */
	void saveCustomer(Customer customer);


	/**
	 * Update customer.
	 *
	 * @param customer the customer
	 * @return the customer
	 */
	Customer updateCustomer(Customer customer);

	
	/**
	 * Find customers by name and email.
	 *
	 * @param name the name
	 * @param email the email
	 * @return the list
	 */
	List<Customer> findCustomersByNameAndEmail(String name, String email);

}
