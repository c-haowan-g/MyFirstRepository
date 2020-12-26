package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DFlowLotReturnData complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DFlowLotReturnData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DFlowLot" type="{dataobjects.common.plantops.datasweep.com}DFlowLot" minOccurs="0"/>
 *         &lt;element name="DUnits" type="{dataobjects.common.plantops.datasweep.com}DUnit" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DFlowLotReturnData", propOrder = { "dFlowLot", "dUnits" })
public class DFlowLotReturnData {

	@XmlElement(name = "DFlowLot")
	protected DFlowLot dFlowLot;
	@XmlElement(name = "DUnits", nillable = true)
	protected List<DUnit> dUnits;

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
	 * Gets the value of the dUnits property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dUnits property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDUnits().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DUnit }
	 * 
	 * 
	 */
	public List<DUnit> getDUnits() {
		if (dUnits == null) {
			dUnits = new ArrayList<DUnit>();
		}
		return this.dUnits;
	}

}
