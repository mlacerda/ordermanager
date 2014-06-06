package com.ciandt.arqref.framework.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * Interface of the common abstract methods.
 * 
 * @param <T>
 */
public interface AbstractDAO<T extends Serializable> {

	/**
	 * Retrieve all entities by id. 
	 * 
	 * @param id
	 * @return
	 */
	T findById(final Long id);
	
	/**
	 * Retrieve all entities.
	 * 
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * Save entity.
	 * 
	 * @param entity
	 */
	void save(final T entity);
	
	/**
	 * Update entity.
	 * 
	 * @param entity
	 */
	T update(final T entity);
	
	/**
	 * Delete by entity by id.  
	 * 
	 * @param entityId
	 */
	void deleteById(final Long entityId);
	
	/**
	 * Delete entity.
	 * 
	 * @param entity
	 */
	void delete(final T entity);
	
}
