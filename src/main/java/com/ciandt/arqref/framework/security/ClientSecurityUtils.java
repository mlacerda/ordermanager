package com.ciandt.arqref.framework.security;

import org.apache.cxf.jaxrs.client.WebClient;

/**
 * This class contains helper methods relate to service client security.
 * 
 */
public final class ClientSecurityUtils {

	/**
	 * Instantiates a new client security utils.
	 */
	private ClientSecurityUtils() {
	}


	/**
	 * 
	 * Apply the security policy to rest WebClient.
	 *
	 * @param client the WebClient
	 * @param username the username
	 * @param password the password
	 * @return the WebClient
	 */
	public static WebClient applySecurityToRest(WebClient client,
			String username, String password) {
		// Replace 'user' and 'password' by the actual values
		String authorizationHeader = "Basic "
				+ org.apache.cxf.common.util.Base64Utility.encode((username
						+ ":" + password).getBytes());

		return client.header("Authorization", authorizationHeader);
	}
}
