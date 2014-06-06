package com.ciandt.arqref.ordermanager.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * The Customer Entity.
 */
@Entity
@NamedQuery(name = Customer.FIND_ALL_BY_NAME, query = "from Customer c where c.name = :name")
@XmlRootElement
public class Customer implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant NAME_MAX_SIZE. */
	public static final int NAME_MAX_SIZE = 40;
	
	/** The Constant EMAIL_REGEXP. */
	public static final String EMAIL_REGEXP = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";
	
	/** The Constant FIND_ALL_BY_NAME. */
	public static final String FIND_ALL_BY_NAME = "findAllCustomerByName";

	/** The name. */
	@NotNull
    @Size(max = NAME_MAX_SIZE)
    private String name;

    /** The email. */
    @Pattern(regexp = EMAIL_REGEXP)
    private String email;

    /** The birthday. */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthday;

	/**
	 * To string.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
        return this.name;
    }

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
        this.name = name;
    }

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
        return this.email;
    }

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
        this.email = email;
    }

	/**
	 * Gets the birthday.
	 *
	 * @return the birthday
	 */
	public Date getBirthday() {
        return this.birthday;
    }

	/**
	 * Sets the birthday.
	 *
	 * @param birthday the new birthday
	 */
	public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

	/** The id. */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	/** The version. */
	@Version
    @Column(name = "version")
    private Integer version;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
        return this.id;
    }

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
        this.id = id;
    }

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public Integer getVersion() {
        return this.version;
    }

	/**
	 * Sets the version.
	 *
	 * @param version the new version
	 */
	public void setVersion(Integer version) {
        this.version = version;
    }
}
