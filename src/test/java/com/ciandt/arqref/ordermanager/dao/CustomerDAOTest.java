package com.ciandt.arqref.ordermanager.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.ciandt.arqref.ordermanager.test.OrderManagementAbstractTest;

public class CustomerDAOTest extends OrderManagementAbstractTest {
	@Autowired
	private CustomerDAO customerDAO;

	@Test
	public void findByEmail() {
		customerDAO.findByEmail("customer1@gmail.com");
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void cannotFindByEmail() {
		customerDAO.findByEmail("usernotfound@gmail.com");
	}

	@Test
	public void findAllByName() {
		assertTrue("At least one customer must be found.", customerDAO
				.findAllByName("Customer 1").size() > 0);
	}

	@Test
	public void findAllByBirthday() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd hh:mm:ss");
		Date date = sdf.parse("1980-01-01 00:00:00");
		assertTrue("At least one customer must be found.", customerDAO
				.findAllByBirthday(date).size() > 0);
	}

	@Test
	public void findByNameAndEmail() {
		assertTrue("At least one customer must be found.", customerDAO
				.findByByNameAndEmail("Customer 1", "customer1@gmail.com")
				.size() > 0);
	}

	@Test
	public void findByEmptyNameAndEmail() {
		assertTrue("At least one customer must be found.", customerDAO
				.findByByNameAndEmail(null, "customer1@gmail.com").size() > 0);
		
		assertTrue("At least one customer must be found.", customerDAO
				.findByByNameAndEmail("", "customer1@gmail.com").size() > 0);

		assertTrue("At least one customer must be found.", customerDAO
				.findByByNameAndEmail("Customer 1", null).size() > 0);
		
		assertTrue("At least one customer must be found.", customerDAO
				.findByByNameAndEmail("Customer 1", "").size() > 0);
	}
}
