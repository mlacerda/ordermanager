package com.ciandt.arqref.ordermanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciandt.arqref.ordermanager.dao.CustomerDAO;
import com.ciandt.arqref.ordermanager.dao.CustomerOrderDAO;
import com.ciandt.arqref.ordermanager.exception.CustomerWithOrdersException;
import com.ciandt.arqref.ordermanager.model.entity.Customer;
import com.ciandt.arqref.ordermanager.service.CustomerService;

/**
 * The Class CustomerServiceImpl.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	/** The customer dao. */
	@Autowired
	private CustomerDAO customerDAO;

	/** The customer order dao. */
	@Autowired
	private CustomerOrderDAO customerOrderDAO;

	/**
	 * Find customer by id.
	 *
	 * @param id the id
	 * @return the customer
	 * @see com.ciandt.arqref.ordermanager.service.CustomerService#findCustomerById(java.lang.Long)
	 */
	public Customer findCustomerById(Long id) {
		return customerDAO.findById(id);
	}

	/**
	 * Find all customers.
	 *
	 * @return the list
	 * @see com.ciandt.arqref.ordermanager.service.CustomerService#findAllCustomers()
	 */
	public List<Customer> findAllCustomers() {
		return customerDAO.findAll();
	}

	/**
	 * Save customer.
	 *
	 * @param customer the customer
	 * @see com.ciandt.arqref.ordermanager.service.CustomerService#saveCustomer(com.ciandt.arqref.ordermanager.model.entity.Customer)
	 */
	public void saveCustomer(Customer customer) {
		customerDAO.save(customer);
	}

	/**
	 * Update customer.
	 *
	 * @param customer the customer
	 * @return the customer
	 * @see com.ciandt.arqref.ordermanager.service.CustomerService#updateCustomer(com.ciandt.arqref.ordermanager.model.entity.Customer)
	 */
	public Customer updateCustomer(Customer customer) {
		return customerDAO.update(customer);
	}

	/**
	 * Find customers by name and email.
	 *
	 * @param name the name
	 * @param email the email
	 * @return the list
	 * @see com.ciandt.arqref.ordermanager.service.CustomerService#findCustomersByNameAndEmail(java.lang.String, java.lang.String)
	 */
	public List<Customer> findCustomersByNameAndEmail(String name, String email) {
		return customerDAO.findByByNameAndEmail(name, email);
	}

	/**
	 * Delete customer by id.
	 *
	 * @param id the id
	 * @throws CustomerWithOrdersException the customer with orders exception
	 * @see com.ciandt.arqref.ordermanager.service.CustomerService#deleteCustomerById(java.lang.Long)
	 */
	@Override
	public void deleteCustomerById(Long id) throws CustomerWithOrdersException {
		if (customerOrderDAO.existsCustomerOrderByCustomerId(id)) {
			throw new CustomerWithOrdersException();
		}
		customerDAO.deleteById(id);

	}
}
