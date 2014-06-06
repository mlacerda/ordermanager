/**
 * 
 */
package com.ciandt.arqref.framework.jobs;

/**
 * This interface should be implemented by all jobs in order to maintain consistency.
 */
public interface Job {
	
	/**
	 * Method that should be annotated to be executed.
	 */
	void run();

}
