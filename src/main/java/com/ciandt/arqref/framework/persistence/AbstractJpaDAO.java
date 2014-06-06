/**
 * 
 */
package com.ciandt.arqref.framework.persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

/**
 * This abstract class aims to simplify the DAO layer with Spring and JPA.
 * All DAOs must extend this class.
 *
 * @param <T> the generic type
 */
public abstract class AbstractJpaDAO<T extends Serializable> implements AbstractDAO<T> {

	/** The clazz. */
	private Class<T> clazz;

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
	
	/**
	 * Instantiates a new abstract jpa dao.
	 */
	@SuppressWarnings("unchecked")
	public AbstractJpaDAO() {
		Type type = getClass().getGenericSuperclass();
		Type[] arguments = ((ParameterizedType) type).getActualTypeArguments();
		this.clazz = (Class<T>) arguments[0];
	}

	/**
	 * Gets the entity manager.
	 *
	 * @return the entity manager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Sets the entity manager.
	 *
	 * @param entityManager the new entity manager
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Sets the clazz.
	 *
	 * @param clazzToSet the new clazz
	 */
	public void setClazz(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	/**
	 * @see com.ciandt.arqref.framework.persistence.AbstractDAO#findById(java.lang.Long)
	 */
	public T findById(final Long id) {
		return entityManager.find(clazz, id);
	}

	/**
	 * @see com.ciandt.arqref.framework.persistence.AbstractDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}

	/**
	 * @see com.ciandt.arqref.framework.persistence.AbstractDAO#save(java.io.Serializable)
	 */
	@Transactional
	public void save(final T entity) {
		entityManager.persist(entity);
		entityManager.flush();
	}

	/**
	 * @see com.ciandt.arqref.framework.persistence.AbstractDAO#update(java.io.Serializable)
	 */
	@Transactional
	public T update(final T entity) {
		return entityManager.merge(entity);
	}

	/**
	 * @see com.ciandt.arqref.framework.persistence.AbstractDAO#deleteById(java.lang.Long)
	 */
	@Transactional
	public void deleteById(final Long entityId) {
		final T entity = findById(entityId);
		delete(entity);
		entityManager.flush();
	}
	
	/**
	 * @see com.ciandt.arqref.framework.persistence.AbstractDAO#delete(java.io.Serializable)
	 */
	@Transactional
	public void delete(final T entity) {
		if (entity != null) {
			entityManager.remove(entity);
		}
	}
}
