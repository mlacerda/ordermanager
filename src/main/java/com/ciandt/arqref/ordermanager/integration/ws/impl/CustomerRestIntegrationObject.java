package com.ciandt.arqref.ordermanager.integration.ws.impl;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ciandt.arqref.framework.exceptions.TechnicalException;
import com.ciandt.arqref.framework.logging.Log;
import com.ciandt.arqref.framework.properties.PropertyManager;
import com.ciandt.arqref.framework.security.ClientSecurityUtils;


/**
 * The Class CustomerRestIntegrationObject.
 */
@Component
public class CustomerRestIntegrationObject {
	
	/** The logger. */
	@Log
	private Logger logger;

	/** The customer rest web client. */
	@Autowired
	@Qualifier("customerRestWebClient")
	private WebClient customerRestWebClient;

	/** The property manager. */
	@Autowired
	private PropertyManager propertyManager;

	/**
	 * Find a Customer from Customer WebService.
	 * 
	 * @param email
	 *            The Email
	 * @return Customer Bean
	 */
	public JSONObject findCustomer(String email) {
		WebClient webClient = getWebClient();

		String response = webClient.accept(MediaType.APPLICATION_JSON)
				.path("get-by-filter").query("email", email).get(String.class);
		try {
			JSONObject jsonObject = new JSONObject(response);
			jsonObject.getJSONObject("FindCustomerResponse").getJSONObject(
					"customerList");
			return jsonObject;
		} catch (JSONException e) {
			logger.error("Error parsing JSONObject: " + e.getMessage(), e);
			throw new TechnicalException(e);
		}
	}

	/**
	 * Gets the web client.
	 *
	 * @return the web client
	 */
	private WebClient getWebClient() {
		return ClientSecurityUtils.applySecurityToRest(
				WebClient.fromClient(customerRestWebClient, true),
				propertyManager.getRemoteUsername(),
				propertyManager.getRemotePassword());
	}
}
