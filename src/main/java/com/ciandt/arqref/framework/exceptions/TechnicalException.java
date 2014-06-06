package com.ciandt.arqref.framework.exceptions;

/**
 * Default exception for techincal issues.
 */
public class TechnicalException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
    /**
     * Instantiates a new technical exception.
     *
     * @param message the message
     * @see java.lang.RuntimeException#RuntimeException(String)
     */
    public TechnicalException(String message) {
        super(message);
    }

    /**
     * Instantiates a new technical exception.
     *
     * @param message the message
     * @param cause the cause
     * @see java.lang.RuntimeException#RuntimeException(String, Throwable)
     */
    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new technical exception.
     *
     * @param cause the cause
     * @see java.lang.RuntimeException#RuntimeException(Throwable)
     */
    public TechnicalException(Throwable cause) {
        super(cause);
    }
}