package com.ciandt.arqref.framework.properties;

import org.springframework.beans.factory.annotation.Value;

/**
 * This class wrapper the configuration properties existing in system
 * environment.
 */
public class PropertyManager {

	/**
	 * This attribute wraps the system name in the property file.
	 */
	@Value("${system.name}")
	private String systemName;

	/**
	 * This attribute wraps the system version in the property file.
	 */
	@Value("${system.version}")
	private String systemVersion;

	/**
	 * This attribute wraps the webservices client name in the property file.
	 */
	@Value("${ws.client.username}")
	private String wsClientUsername;

	/**
	 * This attribute wraps the webservices client name in the property file.
	 */
	@Value("${ws.client.password}")
	private String wsClientPassword;
	
	
	/**
	 * This attribute wraps the remote url in the property file.
	 */
	@Value("${remote.url}")
	private String remoteUrl;

	/**
	 * This attribute wraps the remote port in the property file.
	 */
	@Value("${remote.port}")
	private String remotePort;

	/**
	 * This attribute wraps the remote username in the property file.
	 */
	@Value("${remote.username}")
	private String remoteUsername;

	/**
	 * This attribute wraps the remote username in the property file.
	 */
	@Value("${remote.userpassword}")
	private String remotePassword;

	/**
	 * This attribute wraps the ldap url in the property file.
	 */
	@Value("${ldap.url}")
	private String ldapUrl;

	/**
	 * This attribute wraps the ldap username in the property file.
	 */
	@Value("${ldap.username}")
	private String ldapUserName;

	/**
	 * This attribute wraps the ldap password in the property file.
	 */
	@Value("${ldap.userpassword}")
	private String ldapUserPassword;

	/**
	 * This attribute wraps the ldap base in the property file.
	 */
	@Value("${ldap.base}")
	private String ldapBase;
	
	/**
	 * Get the value of system name property.
	 * 
	 * @return The String of System Name
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * Get the value of system version property.
	 * 
	 * @return The String of System Version.
	 */
	public String getSystemVersion() {
		return systemVersion;
	}

	/**
	 * Get the value of web service client username property.
	 * 
	 * @return The String of web service client username.
	 */
	public String getWsClientUsername() {
		return wsClientUsername;
	}

	/**
	 * Get the value of web service client password property.
	 * 
	 * @return The String of web service client password.
	 */
	public String getWsClientPassword() {
		return wsClientPassword;
	}	
	
	/**
	 * Get the value of remote url property.
	 * 
	 * @return The String of remote url.
	 */
	public String getRemoteUrl() {
		return remoteUrl;
	}

	/**
	 * Get the value of remote user name property.
	 * 
	 * @return The String of remote user name.
	 */
	public String getRemoteUsername() {
		return remoteUsername;
	}

	/**
	 * Get the value of remote user password property.
	 * 
	 * @return The String of remote user password.
	 */
	public String getRemotePassword() {
		return remotePassword;
	}

	/**
	 * Get the value of remote port property.
	 * 
	 * @return The String of remote port.
	 */
	public String getRemotePort() {
		return remotePort;
	}

	/**
	 * Get the value of ldap url property.
	 * 
	 * @return The String of ldap url.
	 */
	public String getLdapUrl() {
		return ldapUrl;
	}

	/**
	 * Get the value of ldap username property.
	 * 
	 * @return The String of ldap username.
	 */
	public String getLdapUserName() {
		return ldapUserName;
	}

	/**
	 * Get the value of ldap password property.
	 * 
	 * @return The String of ldap password.
	 */
	public String getLdapUserPassword() {
		return ldapUserPassword;
	}

	/**
	 * Get the value of ldap base property.
	 * 
	 * @return The String of ldap base.
	 */
	public String getLdapBase() {
		return ldapBase;
	}
}
