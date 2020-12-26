package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DLoggingProperties complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DLoggingProperties">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="advantageHome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logFileCount" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="logFileSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="logLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logSubDir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="osName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DLoggingProperties", propOrder = { "advantageHome",
		"logFileCount", "logFileSize", "logLevel", "logSubDir", "osName" })
public class DLoggingProperties extends DDataObject {

	protected String advantageHome;
	protected short logFileCount;
	protected int logFileSize;
	protected String logLevel;
	protected String logSubDir;
	protected String osName;

	/**
	 * Gets the value of the advantageHome property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAdvantageHome() {
		return advantageHome;
	}

	/**
	 * Sets the value of the advantageHome property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAdvantageHome(String value) {
		this.advantageHome = value;
	}

	/**
	 * Gets the value of the logFileCount property.
	 * 
	 */
	public short getLogFileCount() {
		return logFileCount;
	}

	/**
	 * Sets the value of the logFileCount property.
	 * 
	 */
	public void setLogFileCount(short value) {
		this.logFileCount = value;
	}

	/**
	 * Gets the value of the logFileSize property.
	 * 
	 */
	public int getLogFileSize() {
		return logFileSize;
	}

	/**
	 * Sets the value of the logFileSize property.
	 * 
	 */
	public void setLogFileSize(int value) {
		this.logFileSize = value;
	}

	/**
	 * Gets the value of the logLevel property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLogLevel() {
		return logLevel;
	}

	/**
	 * Sets the value of the logLevel property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLogLevel(String value) {
		this.logLevel = value;
	}

	/**
	 * Gets the value of the logSubDir property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLogSubDir() {
		return logSubDir;
	}

	/**
	 * Sets the value of the logSubDir property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLogSubDir(String value) {
		this.logSubDir = value;
	}

	/**
	 * Gets the value of the osName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOsName() {
		return osName;
	}

	/**
	 * Sets the value of the osName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOsName(String value) {
		this.osName = value;
	}

}
