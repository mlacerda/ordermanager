package com.ciandt.arqref.ordermanager.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ciandt.arqref.ordermanager.test.OrderManagementAbstractTest;

public class CustomerOrderDAOTest extends OrderManagementAbstractTest {
	@Autowired
	private CustomerOrderDAO customerOrderDAO;

	@Test
	public void findAllCustomerOrders() {
		assertTrue("At least one customer order must be found.",
				customerOrderDAO.findAll().size() > 0);
	}

	@Test
	public void findCustomerOrder() {
		assertNotNull(customerOrderDAO.findById(Long.valueOf(1001)));
	}

	@Test
	public void cannotFindCustomerOrder() {
		assertNull(customerOrderDAO.findById(Long.valueOf(0)));
	}

	@Test
	public void findCustomerOrderEntries() {
		assertEquals(2, customerOrderDAO.findCustomerOrderEntries(0, 10).size());
	}

	@Test
	public void existsCustomerOrderByCustomerId() {
		assertTrue(customerOrderDAO.existsCustomerOrderByCustomerId(Long
				.valueOf(1001)));
	}

	@Test
	public void notExistsCustomerOrderByCustomerId() {
		assertFalse(customerOrderDAO.existsCustomerOrderByCustomerId(Long
				.valueOf(0)));
	}

}
