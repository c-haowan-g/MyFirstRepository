package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operateFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wo_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wo_Shift" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="equip_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="master_By" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="master_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="send_By" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="send_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "user", "password", "operateFlag", "woDate",
		"woShift", "equipCode", "masterBy", "masterName", "sendBy", "sendName" })
@XmlRootElement(name = "reciveMixerMasterByMES", namespace = "http://tempuri.org/")
public class ReciveMixerMasterByMES {

	@XmlElement(namespace = "http://tempuri.org/")
	protected String user;
	@XmlElement(namespace = "http://tempuri.org/")
	protected String password;
	@XmlElement(namespace = "http://tempuri.org/")
	protected String operateFlag;
	@XmlElement(name = "wo_Date", namespace = "http://tempuri.org/")
	protected String woDate;
	@XmlElement(name = "wo_Shift", namespace = "http://tempuri.org/")
	protected String woShift;
	@XmlElement(name = "equip_Code", namespace = "http://tempuri.org/")
	protected String equipCode;
	@XmlElement(name = "master_By", namespace = "http://tempuri.org/")
	protected String masterBy;
	@XmlElement(name = "master_Name", namespace = "http://tempuri.org/")
	protected String masterName;
	@XmlElement(name = "send_By", namespace = "http://tempuri.org/")
	protected String sendBy;
	@XmlElement(name = "send_Name", namespace = "http://tempuri.org/")
	protected String sendName;

	/**
	 * Gets the value of the user property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Sets the value of the user property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUser(String value) {
		this.user = value;
	}

	/**
	 * Gets the value of the password property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the value of the password property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * Gets the value of the operateFlag property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOperateFlag() {
		return operateFlag;
	}

	/**
	 * Sets the value of the operateFlag property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOperateFlag(String value) {
		this.operateFlag = value;
	}

	/**
	 * Gets the value of the woDate property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWoDate() {
		return woDate;
	}

	/**
	 * Sets the value of the woDate property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWoDate(String value) {
		this.woDate = value;
	}

	/**
	 * Gets the value of the woShift property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWoShift() {
		return woShift;
	}

	/**
	 * Sets the value of the woShift property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWoShift(String value) {
		this.woShift = value;
	}

	/**
	 * Gets the value of the equipCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEquipCode() {
		return equipCode;
	}

	/**
	 * Sets the value of the equipCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEquipCode(String value) {
		this.equipCode = value;
	}

	/**
	 * Gets the value of the masterBy property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMasterBy() {
		return masterBy;
	}

	/**
	 * Sets the value of the masterBy property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMasterBy(String value) {
		this.masterBy = value;
	}

	/**
	 * Gets the value of the masterName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMasterName() {
		return masterName;
	}

	/**
	 * Sets the value of the masterName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMasterName(String value) {
		this.masterName = value;
	}

	/**
	 * Gets the value of the sendBy property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSendBy() {
		return sendBy;
	}

	/**
	 * Sets the value of the sendBy property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSendBy(String value) {
		this.sendBy = value;
	}

	/**
	 * Gets the value of the sendName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSendName() {
		return sendName;
	}

	/**
	 * Sets the value of the sendName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSendName(String value) {
		this.sendName = value;
	}

}
