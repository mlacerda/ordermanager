package com.ciandt.arqref.ordermanager.dao;

import java.util.Date;
import java.util.List;

import com.ciandt.arqref.framework.persistence.AbstractDAO;
import com.ciandt.arqref.ordermanager.model.entity.Customer;

/**
 * Data access object for the Customer entity.
 *
 */
public interface CustomerDAO extends AbstractDAO<Customer> {

	/**
	 * Find a Customer by their unic email.
	 *
	 * @param email the email
	 * @return the customer
	 */
	Customer findByEmail(String email);

	/**
	 * Find all Customers by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	List<Customer> findAllByName(String name);

	/**
	 * Find all Customers by birthday.
	 *
	 * @param birthDate the birth date
	 * @return the list
	 */
	List<Customer> findAllByBirthday(Date birthDate);
	

	/**
	 * Find by by name and email.
	 *
	 * @param name the name
	 * @param email the email
	 * @return the list
	 */
	List<Customer> findByByNameAndEmail(String name, String email);

}
