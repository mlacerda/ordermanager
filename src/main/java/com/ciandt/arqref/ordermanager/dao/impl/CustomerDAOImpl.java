/**
 * 
 */
package com.ciandt.arqref.ordermanager.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ciandt.arqref.framework.persistence.AbstractJpaDAO;
import com.ciandt.arqref.ordermanager.dao.CustomerDAO;
import com.ciandt.arqref.ordermanager.model.entity.Customer;

/**
 * Data access object for the Customer entity.
 */
@Component
@Qualifier("jpa")
public class CustomerDAOImpl extends AbstractJpaDAO<Customer> implements CustomerDAO {
	/**
	 * Finds a Customer by email.
	 *
	 * @param email the email
	 * @return A Customer
	 */
	@Override
	public Customer findByEmail(String email) {
		Query query = getEntityManager().createQuery("from Customer c where c.email = ?");
		query.setParameter(1, email);
		
		return (Customer) query.getSingleResult();
	}

	/**
	 * Finds customers by name.
	 *
	 * @param name the name
	 * @return List of customers
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAllByName(String name) {
		Query query = getEntityManager().createNamedQuery(Customer.FIND_ALL_BY_NAME);
		query.setParameter("name", name);
		
		return query.getResultList();
	}

	/**
	 * Finds customers by birthday.
	 *
	 * @param birthday the birthday
	 * @return List of customers
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAllByBirthday(Date birthday) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM customer WHERE birthday = ?", Customer.class);
		query.setParameter(1, birthday);
		
		return query.getResultList();
	}

	/**
	 * @see com.ciandt.arqref.ordermanager.dao.CustomerDAO#findByByNameAndEmail(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findByByNameAndEmail(String name, String email) {
		final int trimSize = 5;
		
		StringBuffer buff = new StringBuffer();
		buff.append("from Customer c where");
		
		if (name!=null && name.trim().length()>0) {
			buff.append(" c.name like :name  and");
		}
			
		if (email!=null && email.trim().length()>0) {
			buff.append(" c.email like :email  and");
		}
		buff.setLength(buff.length()-trimSize);
		
		Query query = getEntityManager().createQuery(buff.toString());

		if (name!=null && name.trim().length()>0) {
			query.setParameter("name", "%" + name + "%");
		}
			
		if (email!=null && email.trim().length()>0) {
			query.setParameter("email", "%" + email +"%");
		}

		return query.getResultList();
	}
}
