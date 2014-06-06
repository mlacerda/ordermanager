package com.ciandt.arqref.ordermanager.web.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.ciandt.arqref.framework.web.MessageFactory;
import com.ciandt.arqref.ordermanager.model.entity.Customer;
import com.ciandt.arqref.ordermanager.service.CustomerService;

/**
 * The Class CustomerConverter.
 */
@Configurable
@FacesConverter("com.ciandt.arqref.ordermanager.web.converter.CustomerConverter")
public class CustomerConverter implements Converter {

	/** The customer service. */
	@Autowired
    private CustomerService customerService;

	/**
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        Long id;
		try {
			id = Long.parseLong(value);
		} catch (java.lang.NumberFormatException ex) {
			throw new ConverterException(
					MessageFactory.getMessage("message_error_invalid_value", FacesMessage.SEVERITY_ERROR, org.primefaces.util.MessageFactory.getLabel(context, component)), ex);
		}
		return customerService.findCustomerById(id);
    }

	/**
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value instanceof Customer ? ((Customer) value).getId().toString() : "";
    }
}
