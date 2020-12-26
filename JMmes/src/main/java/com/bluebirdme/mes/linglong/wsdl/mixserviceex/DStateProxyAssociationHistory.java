package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DStateProxyAssociationHistory complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DStateProxyAssociationHistory">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="endTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="startTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="stateProxyKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="supportStateProxyKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DStateProxyAssociationHistory", propOrder = { "endTime",
		"startTime", "stateProxyKey", "supportStateProxyKey" })
public class DStateProxyAssociationHistory extends DKeyed {

	protected DTimestamp endTime;
	protected DTimestamp startTime;
	protected long stateProxyKey;
	protected long supportStateProxyKey;

	/**
	 * Gets the value of the endTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEndTime() {
		return endTime;
	}

	/**
	 * Sets the value of the endTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEndTime(DTimestamp value) {
		this.endTime = value;
	}

	/**
	 * Gets the value of the startTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getStartTime() {
		return startTime;
	}

	/**
	 * Sets the value of the startTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setStartTime(DTimestamp value) {
		this.startTime = value;
	}

	/**
	 * Gets the value of the stateProxyKey property.
	 * 
	 */
	public long getStateProxyKey() {
		return stateProxyKey;
	}

	/**
	 * Sets the value of the stateProxyKey property.
	 * 
	 */
	public void setStateProxyKey(long value) {
		this.stateProxyKey = value;
	}

	/**
	 * Gets the value of the supportStateProxyKey property.
	 * 
	 */
	public long getSupportStateProxyKey() {
		return supportStateProxyKey;
	}

	/**
	 * Sets the value of the supportStateProxyKey property.
	 * 
	 */
	public void setSupportStateProxyKey(long value) {
		this.supportStateProxyKey = value;
	}

}
