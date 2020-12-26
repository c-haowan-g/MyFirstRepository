package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DRuntimeActivitySet complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DRuntimeActivitySet">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DRuntimeActivitySetBase">
 *       &lt;sequence>
 *         &lt;element name="activitySetKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="blobDataContext" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="persistenceType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DRuntimeActivitySet", propOrder = { "activitySetKey",
		"blobDataContext", "persistenceType" })
public class DRuntimeActivitySet extends DRuntimeActivitySetBase {

	protected long activitySetKey;
	protected byte[] blobDataContext;
	protected int persistenceType;

	/**
	 * Gets the value of the activitySetKey property.
	 * 
	 */
	public long getActivitySetKey() {
		return activitySetKey;
	}

	/**
	 * Sets the value of the activitySetKey property.
	 * 
	 */
	public void setActivitySetKey(long value) {
		this.activitySetKey = value;
	}

	/**
	 * Gets the value of the blobDataContext property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getBlobDataContext() {
		return blobDataContext;
	}

	/**
	 * Sets the value of the blobDataContext property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setBlobDataContext(byte[] value) {
		this.blobDataContext = ((byte[]) value);
	}

	/**
	 * Gets the value of the persistenceType property.
	 * 
	 */
	public int getPersistenceType() {
		return persistenceType;
	}

	/**
	 * Sets the value of the persistenceType property.
	 * 
	 */
	public void setPersistenceType(int value) {
		this.persistenceType = value;
	}

}
