package com.ciandt.arqref.ordermanager.test;

import java.io.File;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ciandt.arqref.framework.xml.XmlManager;
import com.ciandt.arqref.ordermanager.model.entity.Customer;

public class XmlManagerTest extends OrderManagementAbstractTest{

	@Autowired
	private XmlManager xmlManager;

	/**
	 * Test the castObjectToXml method.
	 */
	@Test
	public void testObjectToXml() throws Exception {

		Customer customer = new Customer();
		customer.setEmail("customersilva@gmail.com");
		customer.setName("Customer Silva");
		customer.setBirthday(new Date());

		xmlManager.castObjectToXml(customer, "target/XmlManagerCustomer.xml");

		File file = new File("target/XmlManagerCustomer.xml");

		Assert.assertTrue(file.exists());

		file.delete();

	}

	/**
	 * Test the castXmlToObject method.
	 */
	@Test
	public void testXmlToObject() throws Exception {

		Customer customer = (Customer) xmlManager
				.castXmlToObject("/customer.xml");

		Assert.assertNotNull(customer);

	}

}
