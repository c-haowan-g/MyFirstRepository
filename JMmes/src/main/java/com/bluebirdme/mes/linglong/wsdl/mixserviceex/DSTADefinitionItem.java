package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSTADefinitionItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSTADefinitionItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="listSupport" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="objectDefinitionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="STADefinitionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="textLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSTADefinitionItem", propOrder = { "auditInfo", "dataType",
		"listSupport", "objectDefinitionKey", "objectType", "staDefinitionKey",
		"textLength" })
public class DSTADefinitionItem extends DKeyed {

	protected DAuditInfo auditInfo;
	protected short dataType;
	protected boolean listSupport;
	protected long objectDefinitionKey;
	protected short objectType;
	@XmlElement(name = "STADefinitionKey")
	protected long staDefinitionKey;
	protected int textLength;

	/**
	 * Gets the value of the auditInfo property.
	 * 
	 * @return possible object is {@link DAuditInfo }
	 * 
	 */
	public DAuditInfo getAuditInfo() {
		return auditInfo;
	}

	/**
	 * Sets the value of the auditInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DAuditInfo }
	 * 
	 */
	public void setAuditInfo(DAuditInfo value) {
		this.auditInfo = value;
	}

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
	 * Gets the value of the listSupport property.
	 * 
	 */
	public boolean isListSupport() {
		return listSupport;
	}

	/**
	 * Sets the value of the listSupport property.
	 * 
	 */
	public void setListSupport(boolean value) {
		this.listSupport = value;
	}

	/**
	 * Gets the value of the objectDefinitionKey property.
	 * 
	 */
	public long getObjectDefinitionKey() {
		return objectDefinitionKey;
	}

	/**
	 * Sets the value of the objectDefinitionKey property.
	 * 
	 */
	public void setObjectDefinitionKey(long value) {
		this.objectDefinitionKey = value;
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
	 * Gets the value of the staDefinitionKey property.
	 * 
	 */
	public long getSTADefinitionKey() {
		return staDefinitionKey;
	}

	/**
	 * Sets the value of the staDefinitionKey property.
	 * 
	 */
	public void setSTADefinitionKey(long value) {
		this.staDefinitionKey = value;
	}

	/**
	 * Gets the value of the textLength property.
	 * 
	 */
	public int getTextLength() {
		return textLength;
	}

	/**
	 * Sets the value of the textLength property.
	 * 
	 */
	public void setTextLength(int value) {
		this.textLength = value;
	}

}
