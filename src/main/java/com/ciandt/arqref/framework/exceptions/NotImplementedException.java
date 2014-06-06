package com.ciandt.arqref.framework.exceptions;

/**
 * Exception throwed when the operation is not implemented yet.
 */
public class NotImplementedException extends TechnicalException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
    /**
     * Instantiates a new not implemented exception.
     *
     * @see java.lang.RuntimeException#RuntimeException()
     */
    public NotImplementedException() {
        super("Method not implemented.");
    }

    /**
     * Instantiates a new not implemented exception.
     *
     * @param message the message
     * @see java.lang.RuntimeException#RuntimeException(String)
     */
    public NotImplementedException(String message) {
        super(message);
    }

    /**
     * Instantiates a new not implemented exception.
     *
     * @param message the message
     * @param cause the cause
     * @see java.lang.RuntimeException#RuntimeException(String, Throwable)
     */
    public NotImplementedException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new not implemented exception.
     *
     * @param cause the cause
     * @see java.lang.RuntimeException#RuntimeException(Throwable)
     */
    public NotImplementedException(Throwable cause) {
        super(cause);
    }
}