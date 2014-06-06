package com.ciandt.arqref.ordermanager.service;

import java.util.List;

import com.ciandt.arqref.ordermanager.model.entity.CustomerOrder;

/**
 * The Interface for services related to CustomerOrder.
 */
public interface CustomerOrderService {

	/**
	 * Delete customer order.
	 *
	 * @param customerOrder the customer order
	 */
	void deleteCustomerOrder(CustomerOrder customerOrder);


	/**
	 * Find customer order.
	 *
	 * @param id the id
	 * @return the customer order
	 */
	CustomerOrder findCustomerOrder(Long id);


	/**
	 * Find all customer orders.
	 *
	 * @return the list
	 */
	List<CustomerOrder> findAllCustomerOrders();


	/**
	 * Save customer order.
	 *
	 * @param customerOrder the customer order
	 */
	void saveCustomerOrder(CustomerOrder customerOrder);


	/**
	 * Update customer order.
	 *
	 * @param customerOrder the customer order
	 * @return the customer order
	 */
	CustomerOrder updateCustomerOrder(CustomerOrder customerOrder);

}
