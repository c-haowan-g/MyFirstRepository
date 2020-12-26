package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DVersionBackInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DVersionBackInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="newState" type="{dataobjects.common.plantops.datasweep.com}DState" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVersionBackInfo", propOrder = { "key", "newState", "type" })
public class DVersionBackInfo extends DDataObject {

	protected long key;
	protected DState newState;
	protected short type;

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
	 * Gets the value of the newState property.
	 * 
	 * @return possible object is {@link DState }
	 * 
	 */
	public DState getNewState() {
		return newState;
	}

	/**
	 * Sets the value of the newState property.
	 * 
	 * @param value
	 *            allowed object is {@link DState }
	 * 
	 */
	public void setNewState(DState value) {
		this.newState = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 */
	public short getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 */
	public void setType(short value) {
		this.type = value;
	}

}
