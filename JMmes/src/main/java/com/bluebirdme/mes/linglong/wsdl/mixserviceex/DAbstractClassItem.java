package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAbstractClassItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAbstractClassItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectSource" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="parentKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="siteNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DAbstractClassItem", propOrder = { "key", "objectKey",
		"objectSource", "parentKey", "siteNumber" })
public class DAbstractClassItem extends DDataObject {

	protected long key;
	protected long objectKey;
	protected short objectSource;
	protected long parentKey;
	protected int siteNumber;

	/**
	 * Gets the value of the key property.
	 * 
	 */
	public long getKey() {
		return key;
	}

	/**
	 * Sets the value of the key property.
	 * 
	 */
	public void setKey(long value) {
		this.key = value;
	}

	/**
	 * Gets the value of the objectKey property.
	 * 
	 */
	public long getObjectKey() {
		return objectKey;
	}

	/**
	 * Sets the value of the objectKey property.
	 * 
	 */
	public void setObjectKey(long value) {
		this.objectKey = value;
	}

	/**
	 * Gets the value of the objectSource property.
	 * 
	 */
	public short getObjectSource() {
		return objectSource;
	}

	/**
	 * Sets the value of the objectSource property.
	 * 
	 */
	public void setObjectSource(short value) {
		this.objectSource = value;
	}

	/**
	 * Gets the value of the parentKey property.
	 * 
	 */
	public long getParentKey() {
		return parentKey;
	}

	/**
	 * Sets the value of the parentKey property.
	 * 
	 */
	public void setParentKey(long value) {
		this.parentKey = value;
	}

	/**
	 * Gets the value of the siteNumber property.
	 * 
	 */
	public int getSiteNumber() {
		return siteNumber;
	}

	/**
	 * Sets the value of the siteNumber property.
	 * 
	 */
	public void setSiteNumber(int value) {
		this.siteNumber = value;
	}

}
