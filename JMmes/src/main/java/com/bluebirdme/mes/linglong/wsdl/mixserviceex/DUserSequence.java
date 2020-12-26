package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DUserSequence complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DUserSequence">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="incrementValue" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="initialValue" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sequenceNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DUserSequence", propOrder = { "description", "incrementValue",
		"initialValue", "maxValue", "sequenceNumber", "tag" })
public class DUserSequence extends DKeyed {

	protected String description;
	protected long incrementValue;
	protected long initialValue;
	protected long maxValue;
	protected long sequenceNumber;
	protected String tag;

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the incrementValue property.
	 * 
	 */
	public long getIncrementValue() {
		return incrementValue;
	}

	/**
	 * Sets the value of the incrementValue property.
	 * 
	 */
	public void setIncrementValue(long value) {
		this.incrementValue = value;
	}

	/**
	 * Gets the value of the initialValue property.
	 * 
	 */
	public long getInitialValue() {
		return initialValue;
	}

	/**
	 * Sets the value of the initialValue property.
	 * 
	 */
	public void setInitialValue(long value) {
		this.initialValue = value;
	}

	/**
	 * Gets the value of the maxValue property.
	 * 
	 */
	public long getMaxValue() {
		return maxValue;
	}

	/**
	 * Sets the value of the maxValue property.
	 * 
	 */
	public void setMaxValue(long value) {
		this.maxValue = value;
	}

	/**
	 * Gets the value of the sequenceNumber property.
	 * 
	 */
	public long getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * Sets the value of the sequenceNumber property.
	 * 
	 */
	public void setSequenceNumber(long value) {
		this.sequenceNumber = value;
	}

	/**
	 * Gets the value of the tag property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Sets the value of the tag property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTag(String value) {
		this.tag = value;
	}

}
