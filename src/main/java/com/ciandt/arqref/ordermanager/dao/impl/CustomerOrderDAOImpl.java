package com.ciandt.arqref.ordermanager.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ciandt.arqref.framework.persistence.AbstractJpaDAO;
import com.ciandt.arqref.ordermanager.dao.CustomerOrderDAO;
import com.ciandt.arqref.ordermanager.model.entity.CustomerOrder;

/**
 * Data access object for the Customer Order entity.
 */
@Component
@Qualifier("jpa")
public class CustomerOrderDAOImpl extends AbstractJpaDAO<CustomerOrder>
		implements CustomerOrderDAO {


	/**
	 * Find customer order entries.
	 *
	 * @param firstResult the first result
	 * @param maxResults the max results
	 * @return the list
	 * @see com.ciandt.arqref.ordermanager.dao.CustomerOrderDAO#findCustomerOrderEntries(int,
	 * int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerOrder> findCustomerOrderEntries(int firstResult,
			int maxResults) {
		return getEntityManager().createQuery("SELECT o FROM CustomerOrder o")
				.setFirstResult(firstResult).setMaxResults(maxResults)
				.getResultList();
	}

	/**
	 * Exists customer order by customer id.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @see com.ciandt.arqref.ordermanager.dao.CustomerOrderDAO#existsCustomerOrderByCustomerId(java.lang.Long)
	 */
	@Override
	public boolean existsCustomerOrderByCustomerId(Long id) {
		Query query = getEntityManager()
				.createQuery(
						"SELECT co FROM CustomerOrder co WHERE co.customer.id = :customer_id",
						CustomerOrder.class);
		query.setParameter("customer_id", id);
		query.setMaxResults(1);
		long count = query.getResultList().size();
		return (count > 0);
	}
}
