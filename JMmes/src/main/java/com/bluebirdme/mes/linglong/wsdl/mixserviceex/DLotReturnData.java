package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DLotReturnData complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DLotReturnData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DLot" type="{dataobjects.common.plantops.datasweep.com}DLot" minOccurs="0"/>
 *         &lt;element name="DOrderItem" type="{dataobjects.common.plantops.datasweep.com}DWorkOrderItem" minOccurs="0"/>
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
@XmlType(name = "DLotReturnData", propOrder = { "dLot", "dOrderItem", "dUnits" })
public class DLotReturnData {

	@XmlElement(name = "DLot")
	protected DLot dLot;
	@XmlElement(name = "DOrderItem")
	protected DWorkOrderItem dOrderItem;
	@XmlElement(name = "DUnits", nillable = true)
	protected List<DUnit> dUnits;

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

	/**
	 * Gets the value of the dOrderItem property.
	 * 
	 * @return possible object is {@link DWorkOrderItem }
	 * 
	 */
	public DWorkOrderItem getDOrderItem() {
		return dOrderItem;
	}

	/**
	 * Sets the value of the dOrderItem property.
	 * 
	 * @param value
	 *            allowed object is {@link DWorkOrderItem }
	 * 
	 */
	public void setDOrderItem(DWorkOrderItem value) {
		this.dOrderItem = value;
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
