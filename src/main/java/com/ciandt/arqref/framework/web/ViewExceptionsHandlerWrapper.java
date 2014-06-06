package com.ciandt.arqref.framework.web;

import java.util.Iterator;

import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class extends from ExceptionHandlerWrapper to customize the handler of
 * exceptions on view layer.
 * 
 */
public class ViewExceptionsHandlerWrapper extends ExceptionHandlerWrapper {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ViewExceptionsHandlerWrapper.class);

    /** The exception handler. */
    private ExceptionHandler exceptionHandler;

    /**
     * Class constructor.
     *
     * @param exceptionHandler ExceptionHandler object
     */
    public ViewExceptionsHandlerWrapper(ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    /**
     * Get the ExceptionHander object set on the class instantiation.
     *
     * @return the wrapped
     */
    @Override
    public ExceptionHandler getWrapped() {
        return this.exceptionHandler;
    }

    /**
     * This methods intercept runtime exceptions and redirect the user to a
     * error page with a message and error code.
     */
    @Override
    public void handle() {
        boolean expired = false;
        for (Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator(); i.hasNext();) {

            ExceptionQueuedEvent event = i.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
            Throwable t = context.getException();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();

            try {
                Throwable tx = t;

                while (tx != null) {
                    if (tx instanceof ViewExpiredException) {
                        expired = true;
                        break;
                    } else {
                        tx = tx.getCause();
                    }
                }
                
                if (expired) {
                    navigationHandler.handleNavigation(facesContext, null, "/public/viewExpired?faces-redirect=true");
                } else {
                	LOGGER.error(t.getMessage(), t);
                    navigationHandler.handleNavigation(facesContext, null, "/public/error?faces-redirect=true");
                }

                facesContext.renderResponse();
            } finally {
                i.remove();
            }
        }
        getWrapped().handle();
    }
}
