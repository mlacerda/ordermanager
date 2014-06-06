package com.ciandt.arqref.framework.messaging;

import java.io.Serializable;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * This is simple base JMS message sender.
 */
public abstract class MessageSender {

	/** The jms template. */
	private JmsTemplate jmsTemplate;
	
	/**
	 * Gets the jms template.
	 *
	 * @return the jms template
	 */
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	/**
	 * Gets the queue.
	 *
	 * @return the queue
	 */
	public Queue getQueue() {
		return queue;
	}

	/** The queue. */
	private Queue queue;

	/**
	 * Sent the object for specfied queue.
	 * 
	 * @param object
	 *            Serialized Object.
	 */
	protected void sendObjectMessage(final Serializable object) {
		this.jmsTemplate.send(this.queue, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(object);
			}
		});
	}

	/**
	 * Set the JMS Connection Factory.
	 *
	 * @param cf the new connection factory
	 */
	@Autowired
	@Qualifier("connectionFactory")
	public void setConnectionFactory(ConnectionFactory cf) {
		this.jmsTemplate = new JmsTemplate(cf);
	}

	/**
	 * Set the JMS Queue.
	 *
	 * @param queue the new queue
	 */
	public void setQueue(Queue queue) {
		this.queue = queue;
	}
}
