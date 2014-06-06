package com.ciandt.arqref.ordermanager.integration.ws.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ciandt.arqref.ordermanager.facade.ws.Customer;
import com.ciandt.arqref.ordermanager.facade.ws.CustomerFacade;
import com.ciandt.arqref.ordermanager.facade.ws.FindCustomerRequest;
import com.ciandt.arqref.ordermanager.facade.ws.FindCustomerResponse;

/**
 * The Class CustomerWSIntegrationObject.
 */
@Component
public class CustomerWSIntegrationObject {

	/** The customer facade. */
	@Autowired 
	@Qualifier("customerFacadeClient")
	private CustomerFacade customerFacade;

	/**
	 * Find a Customer from Customer WebService.
	 * 
	 * @param email
	 *            The Email
	 * @return Customer Bean
	 */
	public Customer findCustomer(String email) {
		FindCustomerRequest request = new FindCustomerRequest();
		request.setEmail(email);
		FindCustomerResponse response = customerFacade.findCustomer(request);
		if (response.getCustomerList() !=null && response.getCustomerList().size()>0) {
			return response.getCustomerList().get(0);
		} else {
			return null;
		}		
	}
}
