package com.ciandt.arqref.framework.exceptions;

/**
 * Default exception for business checks.
 */
public class BusinessException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
    /**
     * Instantiates a new business exception.
     *
     * @param message the message
     * @see java.lang.Exception#Exception(String)
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     * Instantiates a new business exception.
     *
     * @param message the message
     * @param cause the cause
     * @see java.lang.Exception#Exception(String, Throwable)
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new business exception.
     *
     * @param cause the cause
     * @see java.lang.Exception#Exception(Throwable)
     */
    public BusinessException(Throwable cause) {
        super(cause);
    }
}
