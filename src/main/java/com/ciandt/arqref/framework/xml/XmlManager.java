package com.ciandt.arqref.framework.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import com.ciandt.arqref.framework.exceptions.TechnicalException;


/**
 * This class is responsible to perform operations related to XML handling.
 * 
 */
@Component
public class XmlManager {
	

	@Autowired
	private Jaxb2Marshaller jaxbMarshaller;

	private TransformerFactory factory = TransformerFactory.newInstance();

	/**
	 * Parse a java object into xml file.
	 * 
	 * @param object
	 *            the parseable java object
	 * @param filePath
	 *            the full path of generated xml file.
	 */
	public void castObjectToXml(Object object, String filePath) {
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(new File(filePath));
			StreamResult result = new StreamResult(outputStream);

			// marshal the object to xml
			jaxbMarshaller.marshal(object, result);

		} catch (FileNotFoundException e) {
			throw new TechnicalException( e);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					throw new TechnicalException( e);
				}
			}
		}

	}

	/**
	 * Transforms a xml file into another xml format using XSLT.
	 * 
	 * @param xslFilePath
	 *            transforms a xml file into another xml format using XSLT.
	 * @param xmlSourcePath
	 *            the full path of source xml file.
	 * @param xmlTargetPath
	 *            the full path of target xml file
	 */
	public void transformXML(String xslFilePath, String xmlSourcePath,
			String xmlTargetPath) {

		Transformer transformer = null;
		FileOutputStream outputStream = null;

		try {

			transformer = factory.newTransformer(new StreamSource(xslFilePath));

			outputStream = new FileOutputStream(new File(xmlTargetPath));

			StreamResult result = new StreamResult(outputStream);

			transformer.transform(new StreamSource(xmlSourcePath), result);
		} catch (TransformerException e) {
			throw new TechnicalException( e);
		} catch (FileNotFoundException e1) {
			throw new TechnicalException( e1);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					throw new TechnicalException( e);
				}
			}
		}

	}

	/**
	 * Parse a xml file into java object.
	 * 
	 * @param filePath
	 *            The full path of source xml file.
	 * @return Object – the parseable java object;
	 */
	public Object castXmlToObject(String filePath) {
		InputStream inputStream = null;
		try {
			inputStream = this.getClass().getResourceAsStream(filePath);
			StreamSource source = new StreamSource(inputStream);

			return jaxbMarshaller.unmarshal(source);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				throw new TechnicalException( e);
			}
		}
	}

	/**
	 * Parse a xml file into java object.
	 * 
	 * @param filePath
	 *            The full path of source xml file.
	 * @return Object – the parseable java object;
	 */
	public Object castXmlToObjectWithPath(String filePath) {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(filePath);
			StreamSource source = new StreamSource(inputStream);

			return jaxbMarshaller.unmarshal(source);
		} catch (FileNotFoundException e) {
			throw new TechnicalException(e);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				throw new TechnicalException(e);
			}
		}
	} 
}
