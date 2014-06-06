package com.ciandt.arqref.ordermanager.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The Class Product.
 */
@Entity
@XmlRootElement
public class Product implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant NAME_MAX_SIZE. */
	public static final int NAME_MAX_SIZE = 40;
	
	/** The Constant DESCRIPTION_MAX_SIZE. */
	public static final int DESCRIPTION_MAX_SIZE = 200;

    /** The name. */
    @NotNull
    @Size(max = NAME_MAX_SIZE)
    private String name;

    /** The description. */
    @NotNull
    @Size(max = DESCRIPTION_MAX_SIZE)
    private String description;

    /** The price. */
    @NotNull
    private Double price;

    /** The in stock. */
    private Boolean inStock;

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
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
        return this.description;
    }

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
        this.description = description;
    }

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public Double getPrice() {
        return this.price;
    }

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(Double price) {
        this.price = price;
    }

	/**
	 * Gets the in stock.
	 *
	 * @return the in stock
	 */
	public Boolean getInStock() {
        return this.inStock;
    }

	/**
	 * Sets the in stock.
	 *
	 * @param inStock the new in stock
	 */
	public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

	/**
	 * To string.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
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
