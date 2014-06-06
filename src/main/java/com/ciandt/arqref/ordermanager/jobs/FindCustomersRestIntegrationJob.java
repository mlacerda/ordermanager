package com.ciandt.arqref.ordermanager.jobs;

import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciandt.arqref.framework.jobs.Job;
import com.ciandt.arqref.framework.logging.Log;
import com.ciandt.arqref.ordermanager.integration.ws.impl.CustomerRestIntegrationObject;

/**
 * Job used to test the integration using Rest services.
 */
@Component
public class FindCustomersRestIntegrationJob implements Job{
	
	/** The logger. */
	@Log
	private Logger logger;

	/** The sender. */
	@Autowired
	private CustomerRestIntegrationObject customerRestIntegrationObject;
	
	/**
	 * @see com.ciandt.arqref.framework.jobs.Job#run()
	 */
	@Override
	public void run() {
		logger.info("Finding a customer wirt REST");
		JSONObject c = customerRestIntegrationObject.findCustomer("customer3@gmail.com");
		logger.info("Rest client: {}", c.toString());
	}
}
