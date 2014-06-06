package com.ciandt.arqref.ordermanager.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CloseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.ciandt.arqref.framework.web.MessageFactory;
import com.ciandt.arqref.ordermanager.exception.CustomerWithOrdersException;
import com.ciandt.arqref.ordermanager.model.entity.Customer;
import com.ciandt.arqref.ordermanager.service.CustomerService;

/**
 * The Class CustomerController.
 */
@Configurable
@ManagedBean(name = "customerController")
@SessionScoped
public class CustomerController implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The customer service. */
	@Autowired
    private transient CustomerService customerService;

	/** The name. */
	private String name = "Customers";

	/** The customer. */
	private Customer customer;

	/** The customers list. */
	private List<Customer> customersList;
	
	/** The filter name. */
	private String filterName = "";
	
	/** The filter email. */
	private String filterEmail = "";
	
	/** The create dialog visible. */
	private boolean createDialogVisible = false;

	/** The searched. */
	private boolean searched = false;

	/**
	 * Display create dialog.
	 *
	 * @return the string
	 */
	public String displayCreateDialog() {
        customer = new Customer();
        createDialogVisible = true;
        return "customer";
    }
	
	/**
	 * Display list.
	 *
	 * @return the string
	 */
	public String displayList() {
        createDialogVisible = false;
        return "customer";
    }

	/**
	 * Display Reports.
	 *
	 * @return the string
	 */
	public String displayReports() {
        createDialogVisible = false;
        return "reports";
    }
	
	/**
	 * Find customers.
	 *
	 * @return the string
	 */
	public String findCustomers() {
		createDialogVisible = false;
        customersList = customerService.findCustomersByNameAndEmail(filterName, filterEmail);
        searched = true;
        return null;
    }

	/**
	 * Clear search.
	 *
	 * @return the string
	 */
	public String clearSearch() {
		createDialogVisible = false;
        customersList = null;
    	filterName = "";
    	filterEmail = "";
    	searched = false;
    	return null;
    }
	
	
	/**
	 * On edit.
	 *
	 * @return the string
	 */
	public String onEdit() {
        return null;
    }

	/**
	 * Persist.
	 *
	 * @return the string
	 */
	public String persist() {
        String message = "";
        if (customer.getId() != null) {
            customerService.updateCustomer(customer);
            message = "message_successfully_updated";
        } else {
            customerService.saveCustomer(customer);
            message = "message_successfully_created";
        }
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("createDialogWidget.hide()");
        context.execute("editDialogWidget.hide()");
        
        FacesMessage facesMessage = MessageFactory.getMessage(message, "Customer");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        reset();
        if (searched) {
        	return findCustomers();
        } else {
        	return null;
        }
    }

	/**
	 * Delete.
	 *
	 * @return the string
	 */
	public String delete() {
        try {
			customerService.deleteCustomerById(customer.getId());
	        FacesMessage facesMessage = MessageFactory.getMessage("message_successfully_deleted", "Customer");
	        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	        reset();
	        if (searched) {
	        	return findCustomers();
	        } else {
	        	return null;
	        }
	    } catch (CustomerWithOrdersException e) {
	        FacesMessage facesMessage = MessageFactory.getMessage("message_error_customer_with_orders", FacesMessage.SEVERITY_ERROR, "Customer");
	        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	        return null;
		}
    }

	/**
	 * Reset.
	 */
	public void reset() {
		customer = null;
        createDialogVisible = false;
    }

	/**
	 * Handle dialog close.
	 *
	 * @param event the event
	 */
	public void handleDialogClose(CloseEvent event) {
        reset();
    }
	
	
	/**
	 * Checks if is searched.
	 *
	 * @return true, if is searched
	 */
	public boolean isSearched() {
		return searched;
	}

	/**
	 * Sets the searched.
	 *
	 * @param searched the new searched
	 */
	public void setSearched(boolean searched) {
		this.searched = searched;
	}

	/**
	 * Gets the customers list.
	 *
	 * @return the customers list
	 */
	public List<Customer> getCustomersList() {
		return customersList;
	}

	/**
	 * Sets the customers list.
	 *
	 * @param customersList the new customers list
	 */
	public void setCustomersList(List<Customer> customersList) {
		this.customersList = customersList;
	}

	/**
	 * Gets the filter name.
	 *
	 * @return the filter name
	 */
	public String getFilterName() {
		return filterName;
	}

	/**
	 * Sets the filter name.
	 *
	 * @param filterName the new filter name
	 */
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	/**
	 * Gets the filter email.
	 *
	 * @return the filter email
	 */
	public String getFilterEmail() {
		return filterEmail;
	}

	/**
	 * Sets the filter email.
	 *
	 * @param filterEmail the new filter email
	 */
	public void setFilterEmail(String filterEmail) {
		this.filterEmail = filterEmail;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
        return name;
    }

	
	
	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
        if (customer == null) {
            customer = new Customer();
        }
        return customer;
    }

	/**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
	public void setCustomer(Customer customer) {
        this.customer = customer;
    }
	
	
	/**
	 * Checks if is creates the dialog visible.
	 *
	 * @return true, if is creates the dialog visible
	 */
	public boolean isCreateDialogVisible() {
        return createDialogVisible;
    }

	/**
	 * Sets the creates the dialog visible.
	 *
	 * @param createDialogVisible the new creates the dialog visible
	 */
	public void setCreateDialogVisible(boolean createDialogVisible) {
        this.createDialogVisible = createDialogVisible;
    }
}
