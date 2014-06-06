package com.ciandt.arqref.ordermanager.jobs;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciandt.arqref.framework.jobs.Job;
import com.ciandt.arqref.framework.logging.Log;
import com.ciandt.arqref.ordermanager.facade.ws.Customer;
import com.ciandt.arqref.ordermanager.integration.ws.impl.CustomerWSIntegrationObject;

/**
 * Job used to test the integration using WebService.
 */
@Component
public class FindCustomersWSIntegrationJob implements Job{
	
	/** The logger. */
	@Log
	private Logger logger;

	/** The sender. */
	@Autowired
	private CustomerWSIntegrationObject customerIntegrationObject;
	
	/**
	 * @see com.ciandt.arqref.framework.jobs.Job#run()
	 */
	@Override
	public void run() {
		logger.info("Finding a customer");
		Customer c = customerIntegrationObject.findCustomer("customer2@gmail.com");
		logger.info("WS client: {}", ToStringBuilder.reflectionToString(c, ToStringStyle.MULTI_LINE_STYLE));
	}
}
