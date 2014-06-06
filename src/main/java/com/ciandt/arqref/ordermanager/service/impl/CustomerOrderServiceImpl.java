package com.ciandt.arqref.ordermanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciandt.arqref.ordermanager.dao.CustomerOrderDAO;
import com.ciandt.arqref.ordermanager.model.entity.CustomerOrder;
import com.ciandt.arqref.ordermanager.service.CustomerOrderService;


/**
 * The Class CustomerOrderServiceImpl.
 */
@Service
@Transactional
public class CustomerOrderServiceImpl implements CustomerOrderService {

	/** The customer order dao. */
	@Autowired
    private CustomerOrderDAO customerOrderDAO;


	/**
	 * @see com.ciandt.arqref.ordermanager.service.CustomerOrderService#deleteCustomerOrder(com.ciandt.arqref.ordermanager.model.entity.CustomerOrder)
	 */
	public void deleteCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDAO.delete(customerOrder);
    }

	/**
	 * @see com.ciandt.arqref.ordermanager.service.CustomerOrderService#findCustomerOrder(java.lang.Long)
	 */
	public CustomerOrder findCustomerOrder(Long id) {
        return customerOrderDAO.findById(id);
    }

	/**
	 * @see com.ciandt.arqref.ordermanager.service.CustomerOrderService#findAllCustomerOrders()
	 */
	public List<CustomerOrder> findAllCustomerOrders() {
        return customerOrderDAO.findAll();
    }


	/**
	 * @see com.ciandt.arqref.ordermanager.service.CustomerOrderService#saveCustomerOrder(com.ciandt.arqref.ordermanager.model.entity.CustomerOrder)
	 */
	public void saveCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDAO.save(customerOrder);
    }

	/**
	 * @see com.ciandt.arqref.ordermanager.service.CustomerOrderService#updateCustomerOrder(com.ciandt.arqref.ordermanager.model.entity.CustomerOrder)
	 */
	public CustomerOrder updateCustomerOrder(CustomerOrder customerOrder) {
        return customerOrderDAO.update(customerOrder);
    }
}
