package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DCompatibilityLot complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DCompatibilityLot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DFlowLot" type="{dataobjects.common.plantops.datasweep.com}DFlowLot" minOccurs="0"/>
 *         &lt;element name="DLot" type="{dataobjects.common.plantops.datasweep.com}DLot" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DCompatibilityLot", propOrder = { "dFlowLot", "dLot" })
public class DCompatibilityLot {

	@XmlElement(name = "DFlowLot")
	protected DFlowLot dFlowLot;
	@XmlElement(name = "DLot")
	protected DLot dLot;

	/**
	 * Gets the value of the dFlowLot property.
	 * 
	 * @return possible object is {@link DFlowLot }
	 * 
	 */
	public DFlowLot getDFlowLot() {
		return dFlowLot;
	}

	/**
	 * Sets the value of the dFlowLot property.
	 * 
	 * @param value
	 *            allowed object is {@link DFlowLot }
	 * 
	 */
	public void setDFlowLot(DFlowLot value) {
		this.dFlowLot = value;
	}

	/**
	 * Gets the value of the dLot property.
	 * 
	 * @return possible object is {@link DLot }
	 * 
	 */
	public DLot getDLot() {
		return dLot;
	}

	/**
	 * Sets the value of the dLot property.
	 * 
	 * @param value
	 *            allowed object is {@link DLot }
	 * 
	 */
	public void setDLot(DLot value) {
		this.dLot = value;
	}

}
