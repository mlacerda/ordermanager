package com.ciandt.arqref.ordermanager.web;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.ciandt.arqref.framework.exceptions.BusinessException;
import com.ciandt.arqref.ordermanager.model.entity.Customer;
import com.ciandt.arqref.ordermanager.service.CustomerService;

@Configurable
@ManagedBean(name = "reportsController")
@RequestScoped
public class ReportsController implements Serializable{
	
	/**
	 * default serial id
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String CONTENT_DISPOSITION = "Content-disposition";
	
	/** The name. */
	private String name = "Reports";
	
	@Autowired
	private CustomerService customerService;

	public String generateCustomerListPdf()
			throws JRException, IOException, BusinessException {
		JasperPrint jasperPrint = initCustomerListReport();
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		httpServletResponse.addHeader(CONTENT_DISPOSITION, "attachment; filename=customerslist.pdf");
		ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
		FacesContext.getCurrentInstance().responseComplete();
		return null;
	} 
	
	public void generateCustomerListXls()
			throws JRException, IOException, BusinessException {
		JasperPrint jasperPrint = initCustomerListReport();
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		httpServletResponse.addHeader(CONTENT_DISPOSITION,
				"attachment; filename=customerslist.xlsx");
		ServletOutputStream servletOutputStream = httpServletResponse
				.getOutputStream();
		JRXlsxExporter docxExporter = new JRXlsxExporter();
		docxExporter
				.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
				servletOutputStream);
		docxExporter.exportReport();
		FacesContext.getCurrentInstance().responseComplete();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JasperPrint initCustomerListReport() throws JRException,
			BusinessException {
		String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/customersList.jasper");

		List<Customer> reportData = customerService.findAllCustomers();

		JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath,
									new HashMap(), new JRBeanCollectionDataSource(reportData));

		return jasperPrint;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
