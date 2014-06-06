package com.ciandt.arqref.ordermanager.dao;

import java.util.List;

import com.ciandt.arqref.framework.persistence.AbstractDAO;
import com.ciandt.arqref.ordermanager.model.entity.CustomerOrder;

/**
 * Data access object for the CustomerOrder entity.
 * 
 */
public interface CustomerOrderDAO extends AbstractDAO<CustomerOrder>{
    
    /**
     * Find all orders with pagination strategy.
     *
     * @param firstResult the first result
     * @param maxResults the max results
     * @return the list
     */
    List<CustomerOrder> findCustomerOrderEntries(int firstResult, int maxResults);

	/**
	 * Check if exists customer order with an specific customer id.
	 *
	 * @param id the id
	 * @return true, if exists
	 */
	boolean existsCustomerOrderByCustomerId(Long id);

}
