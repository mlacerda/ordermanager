package com.ciandt.arqref.ordermanager.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ciandt.arqref.framework.web.MessageFactory;

/**
 * The Class LoginController.
 */
@ManagedBean
@RequestScoped
@Configurable
public class LoginController {
    /** The user name. */
    private String username = null;
     
    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** The password. */
    private String password = null;
 
    /** The authentication manager. */
    @Autowired(required=true)
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager = null;
    /**
     * Login.
     * 
     * @return the string
     */
    public String login() {
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(this.getUsername(), this.getPassword());
            Authentication result = authenticationManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
        } catch (AuthenticationException e) {
            FacesMessage facesMessage = MessageFactory.getMessage("message_invalid_username_or_password", FacesMessage.SEVERITY_ERROR);
	        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	        return null;
        }
        return "/pages/main?faces-redirect=true";
    }
 }