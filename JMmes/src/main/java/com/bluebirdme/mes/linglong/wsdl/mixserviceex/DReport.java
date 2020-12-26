package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DReport complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DReport">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="formatType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="guid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nrOfPrintouts" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="printedByUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="printedOnStation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="printedReport" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="reportDesignKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="reportKind" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reportSuperKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="reprintCounter" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DReport", propOrder = { "formatType", "guid", "nrOfPrintouts",
		"printedByUser", "printedOnStation", "printedReport",
		"reportDesignKey", "reportKind", "reportSuperKey", "reprintCounter",
		"userDefinedAttributes" })
public class DReport extends DCategorical {

	protected int formatType;
	protected String guid;
	protected int nrOfPrintouts;
	protected String printedByUser;
	protected String printedOnStation;
	protected byte[] printedReport;
	protected long reportDesignKey;
	protected int reportKind;
	protected long reportSuperKey;
	protected int reprintCounter;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the formatType property.
	 * 
	 */
	public int getFormatType() {
		return formatType;
	}

	/**
	 * Sets the value of the formatType property.
	 * 
	 */
	public void setFormatType(int value) {
		this.formatType = value;
	}

	/**
	 * Gets the value of the guid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGuid() {
		return guid;
	}

	/**
	 * Sets the value of the guid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGuid(String value) {
		this.guid = value;
	}

	/**
	 * Gets the value of the nrOfPrintouts property.
	 * 
	 */
	public int getNrOfPrintouts() {
		return nrOfPrintouts;
	}

	/**
	 * Sets the value of the nrOfPrintouts property.
	 * 
	 */
	public void setNrOfPrintouts(int value) {
		this.nrOfPrintouts = value;
	}

	/**
	 * Gets the value of the printedByUser property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPrintedByUser() {
		return printedByUser;
	}

	/**
	 * Sets the value of the printedByUser property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPrintedByUser(String value) {
		this.printedByUser = value;
	}

	/**
	 * Gets the value of the printedOnStation property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPrintedOnStation() {
		return printedOnStation;
	}

	/**
	 * Sets the value of the printedOnStation property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPrintedOnStation(String value) {
		this.printedOnStation = value;
	}

	/**
	 * Gets the value of the printedReport property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getPrintedReport() {
		return printedReport;
	}

	/**
	 * Sets the value of the printedReport property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setPrintedReport(byte[] value) {
		this.printedReport = ((byte[]) value);
	}

	/**
	 * Gets the value of the reportDesignKey property.
	 * 
	 */
	public long getReportDesignKey() {
		return reportDesignKey;
	}

	/**
	 * Sets the value of the reportDesignKey property.
	 * 
	 */
	public void setReportDesignKey(long value) {
		this.reportDesignKey = value;
	}

	/**
	 * Gets the value of the reportKind property.
	 * 
	 */
	public int getReportKind() {
		return reportKind;
	}

	/**
	 * Sets the value of the reportKind property.
	 * 
	 */
	public void setReportKind(int value) {
		this.reportKind = value;
	}

	/**
	 * Gets the value of the reportSuperKey property.
	 * 
	 */
	public long getReportSuperKey() {
		return reportSuperKey;
	}

	/**
	 * Sets the value of the reportSuperKey property.
	 * 
	 */
	public void setReportSuperKey(long value) {
		this.reportSuperKey = value;
	}

	/**
	 * Gets the value of the reprintCounter property.
	 * 
	 */
	public int getReprintCounter() {
		return reprintCounter;
	}

	/**
	 * Sets the value of the reprintCounter property.
	 * 
	 */
	public void setReprintCounter(int value) {
		this.reprintCounter = value;
	}

	/**
	 * Gets the value of the userDefinedAttributes property.
	 * 
	 * @return possible object is {@link DUDAInstance }
	 * 
	 */
	public DUDAInstance getUserDefinedAttributes() {
		return userDefinedAttributes;
	}

	/**
	 * Sets the value of the userDefinedAttributes property.
	 * 
	 * @param value
	 *            allowed object is {@link DUDAInstance }
	 * 
	 */
	public void setUserDefinedAttributes(DUDAInstance value) {
		this.userDefinedAttributes = value;
	}

}
