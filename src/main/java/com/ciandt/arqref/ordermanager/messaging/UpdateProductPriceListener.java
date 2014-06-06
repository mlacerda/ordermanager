package com.ciandt.arqref.ordermanager.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciandt.arqref.framework.logging.Log;
import com.ciandt.arqref.ordermanager.model.entity.Product;
import com.ciandt.arqref.ordermanager.service.ProductService;

/**
 * The listener interface for receiving updateProductPrice events.
 * The class that is interested in processing a updateProductPrice
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addUpdateProductPriceListener<code> method. When
 * the updateProductPrice event occurs, that object's appropriate
 * method is invoked.
 *
 * @see UpdateProductPriceEvent
 */
@Component
public class UpdateProductPriceListener implements MessageListener {
	
	/** The logger. */
	@Log
	private Logger logger;

	/** The service. */
	@Autowired
	private ProductService service;

	/**
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	@Override
	public void onMessage(Message message) {
		try {
			Product productUpdate = (Product) ((ObjectMessage)message).getObject();
			Product product = service.findProductById(productUpdate.getId());
			product.setPrice(productUpdate.getPrice());
			service.updateProduct(product);
			logger.info("New price for product {}: {}", productUpdate.getId(), productUpdate.getPrice());
		} catch (JMSException e) {
			logger.error("Error updating product: " + e.getMessage(), e);
		}

	}

}
