package com.ciandt.arqref.ordermanager.jobs;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciandt.arqref.framework.jobs.Job;
import com.ciandt.arqref.framework.logging.Log;
import com.ciandt.arqref.ordermanager.messaging.UpdateProductPriceSender;
import com.ciandt.arqref.ordermanager.model.entity.Product;

/**
 * Job used to test the integration using JMS.
 */
@Component
public class UpdateProductPriceJMSJob implements Job{
	
	private static final long PRODUCT_CODE = 1001L;

	private static final int NR_100 = 100;

	/** The logger. */
	@Log
	private Logger logger;

	/** The sender. */
	@Autowired
	private UpdateProductPriceSender sender;
	
	/**
	 * Run the job.
	 * Update the product price based on current hour and minute.
	 * @see com.ciandt.arqref.framework.jobs.Job#run()
	 */
	@Override
	public void run() {
		logger.info("Sending product price update");
		Calendar c = GregorianCalendar.getInstance();
		Double newPrice =  ((double)c.get(Calendar.HOUR_OF_DAY) + ((double)c.get(Calendar.MINUTE)/NR_100));

		Product p = new Product();
		p.setId(PRODUCT_CODE);
		p.setPrice(newPrice);
		sender.sendProduct(p);
	}

}
