package com.ciandt.arqref.ordermanager.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ciandt.arqref.framework.persistence.AbstractJpaDAO;
import com.ciandt.arqref.ordermanager.dao.ProductDAO;
import com.ciandt.arqref.ordermanager.model.entity.Product;

/**
 * Data access object for the Product entity.
 * 
 * @author Sandro Ribeiro
 */
@Component
@Qualifier("jpa")
public class ProductDAOImpl extends AbstractJpaDAO<Product> implements
		ProductDAO {
	/**
	 * Finds products by name.
	 *
	 * @param name the name
	 * @return List of products
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByName(String name) {
		Query query = getEntityManager().createQuery(
				"from Product p where p.name = ?");
		query.setParameter(1, name);

		return query.getResultList();
	}

	/**
	 * Finds products by description.
	 *
	 * @param description the description
	 * @return List of products
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByDescription(String description) {
		Query query = getEntityManager().createQuery(
				"from Product p where p.description = ?");
		query.setParameter(1, description);

		return query.getResultList();
	}
}
