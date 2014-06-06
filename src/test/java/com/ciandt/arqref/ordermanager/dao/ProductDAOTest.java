package com.ciandt.arqref.ordermanager.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ciandt.arqref.ordermanager.test.OrderManagementAbstractTest;

public class ProductDAOTest extends OrderManagementAbstractTest {
	@Autowired
	private ProductDAO productDAO;

	@Test
	public void findByName() {
		assertTrue(productDAO.findByName("Produto 1").size() > 0);
	}

	@Test
	public void cannotFindByName() {
		assertTrue(productDAO.findByName("Not a product").size() == 0);
	}

	@Test
	public void findByDescription() {
		assertTrue(productDAO.findByDescription("Descrição Produto 1").size() > 0);
	}

	@Test
	public void cannotFindByDescription() {
		assertTrue(productDAO.findByDescription("Not a description").size() == 0);
	}
}
