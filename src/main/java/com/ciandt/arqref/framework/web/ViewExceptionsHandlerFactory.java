package com.ciandt.arqref.framework.web;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * This is a factory for the ExceptionHandlerWrapper. It is included on the
 * faces-config.xml to be created by Spring.
 * 
 */
public class ViewExceptionsHandlerFactory extends ExceptionHandlerFactory {

	/** The exception handler factory. */
	private ExceptionHandlerFactory exceptionHandlerFactory;

	/**
	 * Class constructor.
	 *
	 * @param exceptionHandlerFactory Factory object.
	 */
	public ViewExceptionsHandlerFactory(
			ExceptionHandlerFactory exceptionHandlerFactory) {
		this.exceptionHandlerFactory = exceptionHandlerFactory;
	}

	/**
	 * Get the ExceptionHandler object from the ExceptionHandlerWrapper.
	 *
	 * @return the exception handler
	 */
	@Override
	public ExceptionHandler getExceptionHandler() {
		return new ViewExceptionsHandlerWrapper(
				exceptionHandlerFactory.getExceptionHandler());

	}
}
