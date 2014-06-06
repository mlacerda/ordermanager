package com.ciandt.arqref.ordermanager.facade.rs.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciandt.arqref.ordermanager.facade.ws.Customer;
import com.ciandt.arqref.ordermanager.facade.ws.FindCustomerResponse;
import com.ciandt.arqref.ordermanager.service.CustomerService;

/**
 * This class represents a Rest Service for Customer Domain or Entity.
 */
@Component
@Path(value = "/customer")
public class CustomerRestFacade {

	/** The service. */
	@Autowired
	private CustomerService service;

	/**
	 * Find customer by filter returning Json message.
	 *
	 * @param name the name
	 * @param email the email
	 * @return the find customer response
	 */
	@GET
	@Path("/get-by-filter")
	@Produces({ MediaType.APPLICATION_JSON})
	public FindCustomerResponse findCustomerByFilter(@QueryParam("name") String name, @QueryParam("email") String email) {
		FindCustomerResponse rp = new FindCustomerResponse();
		List<com.ciandt.arqref.ordermanager.model.entity.Customer> list = service
				.findCustomersByNameAndEmail(name, email);
		for (com.ciandt.arqref.ordermanager.model.entity.Customer custEntity : list) {
			Customer cm = new Customer();
			cm.setEmail(custEntity.getEmail());
			cm.setName(custEntity.getName());
			rp.getCustomerList().add(cm);
		}

		return rp;
	}	
	
	/**
	 * Find customer by filter returning XML.
	 *
	 * @param name the name
	 * @param email the email
	 * @return the find customer response
	 */
	@GET
	@Path("/get-by-filter-xml")
	@Produces({ MediaType.APPLICATION_XML})
	public FindCustomerResponse findCustomerByFilterXML(@QueryParam("name") String name, @QueryParam("email") String email) {
		FindCustomerResponse rp = new FindCustomerResponse();
		List<com.ciandt.arqref.ordermanager.model.entity.Customer> list = service
				.findCustomersByNameAndEmail(name, email);
		for (com.ciandt.arqref.ordermanager.model.entity.Customer custEntity : list) {
			Customer cm = new Customer();
			cm.setEmail(custEntity.getEmail());
			cm.setName(custEntity.getName());
			rp.getCustomerList().add(cm);
		}

		return rp;
	}	
}
