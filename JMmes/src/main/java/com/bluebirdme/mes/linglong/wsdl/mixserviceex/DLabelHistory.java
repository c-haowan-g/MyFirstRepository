package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DLabelHistory complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DLabelHistory">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="action" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="actionTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="creationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="guid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="labelData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="labelHistoryKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="labelKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="printer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="result" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workstation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DLabelHistory", propOrder = { "action", "actionTime",
		"creationTime", "guid", "labelData", "labelHistoryKey", "labelKey",
		"lastModifiedTime", "printer", "result", "userName", "workstation" })
public class DLabelHistory extends DKeyed {

	protected String action;
	protected DTimestamp actionTime;
	protected DTimestamp creationTime;
	protected String guid;
	protected byte[] labelData;
	protected long labelHistoryKey;
	protected long labelKey;
	protected DTimestamp lastModifiedTime;
	protected String printer;
	protected String result;
	protected String userName;
	protected String workstation;

	/**
	 * Gets the value of the action property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAction() {
		return action;
	}

	/**
	 * Sets the value of the action property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAction(String value) {
		this.action = value;
	}

	/**
	 * Gets the value of the actionTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getActionTime() {
		return actionTime;
	}

	/**
	 * Sets the value of the actionTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setActionTime(DTimestamp value) {
		this.actionTime = value;
	}

	/**
	 * Gets the value of the creationTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getCreationTime() {
		return creationTime;
	}

	/**
	 * Sets the value of the creationTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setCreationTime(DTimestamp value) {
		this.creationTime = value;
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
	 * Gets the value of the labelData property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getLabelData() {
		return labelData;
	}

	/**
	 * Sets the value of the labelData property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setLabelData(byte[] value) {
		this.labelData = ((byte[]) value);
	}

	/**
	 * Gets the value of the labelHistoryKey property.
	 * 
	 */
	public long getLabelHistoryKey() {
		return labelHistoryKey;
	}

	/**
	 * Sets the value of the labelHistoryKey property.
	 * 
	 */
	public void setLabelHistoryKey(long value) {
		this.labelHistoryKey = value;
	}

	/**
	 * Gets the value of the labelKey property.
	 * 
	 */
	public long getLabelKey() {
		return labelKey;
	}

	/**
	 * Sets the value of the labelKey property.
	 * 
	 */
	public void setLabelKey(long value) {
		this.labelKey = value;
	}

	/**
	 * Gets the value of the lastModifiedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getLastModifiedTime() {
		return lastModifiedTime;
	}

	/**
	 * Sets the value of the lastModifiedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setLastModifiedTime(DTimestamp value) {
		this.lastModifiedTime = value;
	}

	/**
	 * Gets the value of the printer property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPrinter() {
		return printer;
	}

	/**
	 * Sets the value of the printer property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPrinter(String value) {
		this.printer = value;
	}

	/**
	 * Gets the value of the result property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Sets the value of the result property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setResult(String value) {
		this.result = value;
	}

	/**
	 * Gets the value of the userName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the value of the userName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUserName(String value) {
		this.userName = value;
	}

	/**
	 * Gets the value of the workstation property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWorkstation() {
		return workstation;
	}

	/**
	 * Sets the value of the workstation property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWorkstation(String value) {
		this.workstation = value;
	}

}
