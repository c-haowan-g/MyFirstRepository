package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DConsumptionSetReturnData complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DConsumptionSetReturnData">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="bomItems" type="{dataobjects.common.plantops.datasweep.com}DRuntimeBomItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DFlowLot" type="{dataobjects.common.plantops.datasweep.com}DFlowLot" minOccurs="0"/>
 *         &lt;element name="DLot" type="{dataobjects.common.plantops.datasweep.com}DLot" minOccurs="0"/>
 *         &lt;element name="DUnit" type="{dataobjects.common.plantops.datasweep.com}DUnit" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DConsumptionSetReturnData", propOrder = { "bomItems",
		"dFlowLot", "dLot", "dUnit" })
public class DConsumptionSetReturnData extends DDataObject {

	@XmlElement(nillable = true)
	protected List<DRuntimeBomItem> bomItems;
	@XmlElement(name = "DFlowLot")
	protected DFlowLot dFlowLot;
	@XmlElement(name = "DLot")
	protected DLot dLot;
	@XmlElement(name = "DUnit")
	protected DUnit dUnit;

	/**
	 * Gets the value of the bomItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the bomItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getBomItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DRuntimeBomItem }
	 * 
	 * 
	 */
	public List<DRuntimeBomItem> getBomItems() {
		if (bomItems == null) {
			bomItems = new ArrayList<DRuntimeBomItem>();
		}
		return this.bomItems;
	}

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

	/**
	 * Gets the value of the dUnit property.
	 * 
	 * @return possible object is {@link DUnit }
	 * 
	 */
	public DUnit getDUnit() {
		return dUnit;
	}

	/**
	 * Sets the value of the dUnit property.
	 * 
	 * @param value
	 *            allowed object is {@link DUnit }
	 * 
	 */
	public void setDUnit(DUnit value) {
		this.dUnit = value;
	}

}
