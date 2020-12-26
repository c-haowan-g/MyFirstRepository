package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DConfigurationProperty complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DConfigurationProperty">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="decimalScale" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="displayNameId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="helpId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messagePackKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="ownerKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ownerType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="stringLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DConfigurationProperty", propOrder = { "dataType",
		"decimalScale", "displayNameId", "helpId", "messagePackKey",
		"objectType", "ownerKey", "ownerType", "stringLength", "value" })
public class DConfigurationProperty extends DKeyed {

	protected short dataType;
	protected int decimalScale;
	protected String displayNameId;
	protected String helpId;
	protected long messagePackKey;
	protected short objectType;
	protected long ownerKey;
	protected short ownerType;
	protected int stringLength;
	protected String value;

	/**
	 * Gets the value of the dataType property.
	 * 
	 */
	public short getDataType() {
		return dataType;
	}

	/**
	 * Sets the value of the dataType property.
	 * 
	 */
	public void setDataType(short value) {
		this.dataType = value;
	}

	/**
	 * Gets the value of the decimalScale property.
	 * 
	 */
	public int getDecimalScale() {
		return decimalScale;
	}

	/**
	 * Sets the value of the decimalScale property.
	 * 
	 */
	public void setDecimalScale(int value) {
		this.decimalScale = value;
	}

	/**
	 * Gets the value of the displayNameId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDisplayNameId() {
		return displayNameId;
	}

	/**
	 * Sets the value of the displayNameId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDisplayNameId(String value) {
		this.displayNameId = value;
	}

	/**
	 * Gets the value of the helpId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHelpId() {
		return helpId;
	}

	/**
	 * Sets the value of the helpId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHelpId(String value) {
		this.helpId = value;
	}

	/**
	 * Gets the value of the messagePackKey property.
	 * 
	 */
	public long getMessagePackKey() {
		return messagePackKey;
	}

	/**
	 * Sets the value of the messagePackKey property.
	 * 
	 */
	public void setMessagePackKey(long value) {
		this.messagePackKey = value;
	}

	/**
	 * Gets the value of the objectType property.
	 * 
	 */
	public short getObjectType() {
		return objectType;
	}

	/**
	 * Sets the value of the objectType property.
	 * 
	 */
	public void setObjectType(short value) {
		this.objectType = value;
	}

	/**
	 * Gets the value of the ownerKey property.
	 * 
	 */
	public long getOwnerKey() {
		return ownerKey;
	}

	/**
	 * Sets the value of the ownerKey property.
	 * 
	 */
	public void setOwnerKey(long value) {
		this.ownerKey = value;
	}

	/**
	 * Gets the value of the ownerType property.
	 * 
	 */
	public short getOwnerType() {
		return ownerType;
	}

	/**
	 * Sets the value of the ownerType property.
	 * 
	 */
	public void setOwnerType(short value) {
		this.ownerType = value;
	}

	/**
	 * Gets the value of the stringLength property.
	 * 
	 */
	public int getStringLength() {
		return stringLength;
	}

	/**
	 * Sets the value of the stringLength property.
	 * 
	 */
	public void setStringLength(int value) {
		this.stringLength = value;
	}

	/**
	 * Gets the value of the value property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
