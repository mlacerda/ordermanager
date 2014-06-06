package com.ciandt.arqref.framework.web;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * A factory for creating ViewExpiredExceptionExceptionHandler objects.
 */
public class ViewExpiredExceptionExceptionHandlerFactory extends ExceptionHandlerFactory {
    
    /** The parent. */
    private ExceptionHandlerFactory parent;

    /**
     * Instantiates a new view expired exception exception handler factory.
     *
     * @param parent the parent
     */
    public ViewExpiredExceptionExceptionHandlerFactory(ExceptionHandlerFactory parent) {
        this.parent = parent;
    }

    /**
     * @see javax.faces.context.ExceptionHandlerFactory#getExceptionHandler()
     */
    @Override
    public ExceptionHandler getExceptionHandler() {
        return new ViewExpiredExceptionExceptionHandler(parent.getExceptionHandler());
    }
}