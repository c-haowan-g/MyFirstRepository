package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DStepCapacity complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DStepCapacity">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="capacity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="stepKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DStepCapacity", propOrder = { "capacity", "stepKey" })
public class DStepCapacity extends DKeyed {

	protected DMeasuredValue capacity;
	protected long stepKey;

	/**
	 * Gets the value of the capacity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getCapacity() {
		return capacity;
	}

	/**
	 * Sets the value of the capacity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setCapacity(DMeasuredValue value) {
		this.capacity = value;
	}

	/**
	 * Gets the value of the stepKey property.
	 * 
	 */
	public long getStepKey() {
		return stepKey;
	}

	/**
	 * Sets the value of the stepKey property.
	 * 
	 */
	public void setStepKey(long value) {
		this.stepKey = value;
	}

}
