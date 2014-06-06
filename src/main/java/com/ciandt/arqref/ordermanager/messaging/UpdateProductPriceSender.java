package com.ciandt.arqref.ordermanager.messaging;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ciandt.arqref.framework.messaging.MessageSender;
import com.ciandt.arqref.ordermanager.model.entity.Product;

/**
 * JMS Message sender used to send product update.
 */
@Component
public class UpdateProductPriceSender extends MessageSender{

	/**
	 * Set the specified queue for pricing.
	 *
	 * @param queue the new queue
	 */
	@Autowired
	@Qualifier("productPriceUpdateQueue")
	@Override
	public void setQueue(Queue queue) {
		super.setQueue(queue);
	}
	
	/**
	 * Send product.
	 *
	 * @param product the product
	 */
	public void sendProduct(Product product) {
		super.sendObjectMessage(product);
	}

}
