package com.ciandt.arqref.framework.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 * Bean responsible for manage the Locale of web application.
 */
@ManagedBean
@SessionScoped
public class LocaleBean {
    
    /** The locale. */
    private Locale locale;

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
    }

    /**
     * Gets the locale.
     *
     * @return the locale
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Sets the locale.
     *
     * @param locale the new locale
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * Gets the locales.
     *
     * @return the locales
     */
    public SelectItem[] getLocales() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        Iterator<Locale> supportedLocales = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
        while (supportedLocales.hasNext()) {
            Locale supportedLocale = supportedLocales.next();
            items.add(new SelectItem(supportedLocale.toString(), supportedLocale.getDisplayName()));
        }
        return items.toArray(new SelectItem[] {});
    }

    /**
     * Gets the selected locale.
     *
     * @return the selected locale
     */
    public String getSelectedLocale() {
        return getLocale().toString();
    }

    /**
     * Sets the selected locale.
     */
    public void setSelectedLocale() {
        setSelectedLocale(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("locale"));
    }
    
   /**
    * Sets the selected locale.
    *
    * @param localeString the new selected locale
    */
   public void setSelectedLocale(String localeString) {
        Iterator<Locale> supportedLocales = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
        while (supportedLocales.hasNext()) {
            Locale supportedLocale = supportedLocales.next();
            if (supportedLocale.toString().equals(localeString)) {
                this.locale = supportedLocale;
                break;
            }
        }
    }
}