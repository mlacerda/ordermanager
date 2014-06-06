package com.ciandt.arqref.ordermanager.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * The Class ApplicationController.
 */
@ManagedBean
@RequestScoped
@Configurable
public class ApplicationController {
	/** The menu model. */
	private MenuModel menuModel;
	
	/**
	 * Gets the menu model.
	 *
	 * @return the menu model
	 */
	public MenuModel getMenuModel() {
        return menuModel;
    }
	
	/**
	 * Inits the Menu Model.
	 */
	@PostConstruct
    public void init() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application application = facesContext.getApplication();
        ExpressionFactory expressionFactory = application.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        
        menuModel = new DefaultMenuModel();
        Submenu submenu;
        MenuItem item;
        
        submenu = new Submenu();
        submenu.setId("customerSubmenu");
        submenu.setLabel("Customer");
        
        //Check security
        if (facesContext.getExternalContext().isUserInRole("ROLE_APPUSERS_RW")) {
	        item = new MenuItem();
	        item.setId("createCustomerMenuItem");
	        item.setValueExpression("value", expressionFactory.createValueExpression(elContext, "#{messages.label_create}", String.class));
	        item.setActionExpression(expressionFactory.createMethodExpression(elContext, "#{customerController.displayCreateDialog}", String.class, new Class[0]));
	        item.setIcon("ui-icon ui-icon-document");
	        item.setAjax(false);
	        item.setAsync(false);
	        item.setUpdate(":dataForm:data");
	        submenu.getChildren().add(item);
        }
        
        item = new MenuItem();
        item.setId("listCustomerMenuItem");
        item.setValueExpression("value", expressionFactory.createValueExpression(elContext, "#{messages.label_list}", String.class));
        item.setActionExpression(expressionFactory.createMethodExpression(elContext, "#{customerController.displayList}", String.class, new Class[0]));
        item.setIcon("ui-icon ui-icon-folder-open");
        item.setAjax(false);
        item.setAsync(false);
        item.setUpdate(":dataForm:data");
        submenu.getChildren().add(item);
        
        item = new MenuItem();
        item.setId("listCustomerReportMenuItem");
        item.setValueExpression("value", expressionFactory.createValueExpression(elContext, "#{messages.label_reports}", String.class));
        item.setActionExpression(expressionFactory.createMethodExpression(elContext, "#{customerController.displayReports}", String.class, new Class[0]));
        item.setIcon("ui-icon ui-icon-folder-open");
        item.setAjax(false);
        item.setAsync(false);
        item.setUpdate(":dataForm:data");
        submenu.getChildren().add(item);
        
        menuModel.addSubmenu(submenu);
     }	
	
    /**
     * Gets the column name.
     *
     * @param column the column
     * @return the column name
     */
    public String getColumnName(String column) {
        if (column == null || column.length() == 0) {
            return column;
        }
        final Pattern p = Pattern.compile("[A-Z][^A-Z]*");
        final Matcher m = p.matcher(Character.toUpperCase(column.charAt(0)) + column.substring(1));
        final StringBuilder builder = new StringBuilder();
        while (m.find()) {
            builder.append(m.group()).append(" ");
        }
        return builder.toString().trim();
    }
}