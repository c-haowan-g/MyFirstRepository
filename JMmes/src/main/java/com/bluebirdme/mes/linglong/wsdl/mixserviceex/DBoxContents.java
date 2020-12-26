package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DBoxContents complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DBoxContents">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="boxes" type="{dataobjects.common.plantops.datasweep.com}DBox" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lots" type="{dataobjects.common.plantops.datasweep.com}DLot" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="units" type="{dataobjects.common.plantops.datasweep.com}DUnit" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DBoxContents", propOrder = { "boxes", "lots", "units" })
public class DBoxContents extends DDataObject {

	@XmlElement(nillable = true)
	protected List<DBox> boxes;
	@XmlElement(nillable = true)
	protected List<DLot> lots;
	@XmlElement(nillable = true)
	protected List<DUnit> units;

	/**
	 * Gets the value of the boxes property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the boxes property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getBoxes().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DBox }
	 * 
	 * 
	 */
	public List<DBox> getBoxes() {
		if (boxes == null) {
			boxes = new ArrayList<DBox>();
		}
		return this.boxes;
	}

	/**
	 * Gets the value of the lots property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the lots property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getLots().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DLot }
	 * 
	 * 
	 */
	public List<DLot> getLots() {
		if (lots == null) {
			lots = new ArrayList<DLot>();
		}
		return this.lots;
	}

	/**
	 * Gets the value of the units property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the units property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getUnits().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DUnit }
	 * 
	 * 
	 */
	public List<DUnit> getUnits() {
		if (units == null) {
			units = new ArrayList<DUnit>();
		}
		return this.units;
	}

}
