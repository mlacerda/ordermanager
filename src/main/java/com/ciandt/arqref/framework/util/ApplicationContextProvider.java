package com.ciandt.arqref.framework.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Utility class that reference the Spring application context.
 * 
 */
public class ApplicationContextProvider implements ApplicationContextAware {
	private static ApplicationContext ctx = null;

	/**
	 * Get the current application context.
	 * 
	 * @return Application Context.
	 */
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}

	public void setApplicationContext(ApplicationContext appCtx) {
		ctx = appCtx;
	}
}
