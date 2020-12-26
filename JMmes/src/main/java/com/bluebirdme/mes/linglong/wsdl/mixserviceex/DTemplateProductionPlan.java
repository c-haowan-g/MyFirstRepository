package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTemplateProductionPlan complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTemplateProductionPlan">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DAbstractProductionPlan">
 *       &lt;sequence>
 *         &lt;element name="handleKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="trackedObjectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTemplateProductionPlan", propOrder = { "handleKey",
		"trackedObjectType" })
public class DTemplateProductionPlan extends DAbstractProductionPlan {

	protected long handleKey;
	protected String trackedObjectType;

	/**
	 * Gets the value of the handleKey property.
	 * 
	 */
	public long getHandleKey() {
		return handleKey;
	}

	/**
	 * Sets the value of the handleKey property.
	 * 
	 */
	public void setHandleKey(long value) {
		this.handleKey = value;
	}

	/**
	 * Gets the value of the trackedObjectType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTrackedObjectType() {
		return trackedObjectType;
	}

	/**
	 * Sets the value of the trackedObjectType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTrackedObjectType(String value) {
		this.trackedObjectType = value;
	}

}
