package com.ciandt.arqref.ordermanager.service;

import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.ciandt.arqref.ordermanager.dao.CustomerDAO;
import com.ciandt.arqref.ordermanager.model.entity.Customer;
import com.ciandt.arqref.ordermanager.test.OrderManagementAbstractTest;

public class CustomerServiceTest extends OrderManagementAbstractTest {
	@Autowired
	@InjectMocks
	private CustomerService customerService;

	@Mock
	private CustomerDAO customerDAO;

	@Test
	public void findCustomerById() {
		Mockito.when(customerDAO.findById(Mockito.anyLong())).thenReturn(
				Mockito.mock(Customer.class));

		assertNotNull(customerService.findCustomerById(Long.valueOf(10)));
	}

	@Test @SuppressWarnings("unchecked")
	public void findAllCustomers() {
		List<Customer> customers = Mockito.mock(List.class);
		customers = Mockito.when(customers.size()).thenReturn(50).getMock();
		Mockito.when(customerDAO.findAll()).thenReturn(customers);

		assertEquals(50, customerService.findAllCustomers().size());
	}
}
