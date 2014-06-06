package com.ciandt.arqref.ordermanager.facade.ws.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciandt.arqref.ordermanager.facade.ws.Customer;
import com.ciandt.arqref.ordermanager.facade.ws.CustomerFacade;
import com.ciandt.arqref.ordermanager.facade.ws.FindCustomerRequest;
import com.ciandt.arqref.ordermanager.facade.ws.FindCustomerResponse;
import com.ciandt.arqref.ordermanager.service.CustomerService;

/**
 * This class represents the implementation of Customer Web Services. It
 * implements the webservices skeleton produced by Apache CXF WSDLtoJava tool.
 * 
 * It must delegate the business logic to business object.
 * 
 */
@Component
@WebService(endpointInterface = "com.ciandt.arqref.ordermanager.facade.ws.CustomerFacade")
public class CustomerFacadeImpl implements CustomerFacade {

	/** The customer service. */
	@Autowired
	private CustomerService customerService;

	/**
	 * Find the Customer. This receives the incoming message and reply the
	 * outcoming message.
	 *
	 * @param request the request
	 * @return the find customer response
	 */
	@Override
	public FindCustomerResponse findCustomer(FindCustomerRequest request) {
		FindCustomerResponse rp = new FindCustomerResponse();
		List<com.ciandt.arqref.ordermanager.model.entity.Customer> list = customerService
				.findCustomersByNameAndEmail(null, request.getEmail());
		for (com.ciandt.arqref.ordermanager.model.entity.Customer custEntity : list) {
			Customer cm = new Customer();
			cm.setEmail(custEntity.getEmail());
			cm.setName(custEntity.getName());
			rp.getCustomerList().add(cm);
		}

		return rp;
	}
}
