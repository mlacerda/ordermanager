package com.ciandt.arqref.framework.security.ws;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciandt.arqref.framework.properties.PropertyManager;

/**
 * Callback used to retrieve password used to WS-Security.
 */
@Component
public class CustomPasswordCallback implements CallbackHandler {
	
	/** The property manager. */
	@Autowired
	private PropertyManager propertyManager;

	/**
	 * @see javax.security.auth.callback.CallbackHandler#handle(javax.security.auth.callback.Callback[])
	 */
	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		if (pc.getIdentifier()!= null && pc.getIdentifier().equals(propertyManager.getWsClientUsername())) {
			pc.setPassword(propertyManager.getWsClientPassword());
		}
	}

}
