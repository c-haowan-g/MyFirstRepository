package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DConnectable complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DConnectable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="area" type="{dataobjects.common.plantops.datasweep.com}DArea" minOccurs="0"/>
 *         &lt;element name="carrier" type="{dataobjects.common.plantops.datasweep.com}DCarrier" minOccurs="0"/>
 *         &lt;element name="equipment" type="{dataobjects.common.plantops.datasweep.com}DEquipment" minOccurs="0"/>
 *         &lt;element name="productionLine" type="{dataobjects.common.plantops.datasweep.com}DProductionLine" minOccurs="0"/>
 *         &lt;element name="site" type="{dataobjects.common.plantops.datasweep.com}DSite" minOccurs="0"/>
 *         &lt;element name="storageUnit" type="{dataobjects.common.plantops.datasweep.com}DStorageUnit" minOccurs="0"/>
 *         &lt;element name="storageZone" type="{dataobjects.common.plantops.datasweep.com}DStorageZone" minOccurs="0"/>
 *         &lt;element name="workCenter" type="{dataobjects.common.plantops.datasweep.com}DWorkCenter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DConnectable", propOrder = { "area", "carrier", "equipment",
		"productionLine", "site", "storageUnit", "storageZone", "workCenter" })
public class DConnectable {

	protected DArea area;
	protected DCarrier carrier;
	protected DEquipment equipment;
	protected DProductionLine productionLine;
	protected DSite site;
	protected DStorageUnit storageUnit;
	protected DStorageZone storageZone;
	protected DWorkCenter workCenter;

	/**
	 * Gets the value of the area property.
	 * 
	 * @return possible object is {@link DArea }
	 * 
	 */
	public DArea getArea() {
		return area;
	}

	/**
	 * Sets the value of the area property.
	 * 
	 * @param value
	 *            allowed object is {@link DArea }
	 * 
	 */
	public void setArea(DArea value) {
		this.area = value;
	}

	/**
	 * Gets the value of the carrier property.
	 * 
	 * @return possible object is {@link DCarrier }
	 * 
	 */
	public DCarrier getCarrier() {
		return carrier;
	}

	/**
	 * Sets the value of the carrier property.
	 * 
	 * @param value
	 *            allowed object is {@link DCarrier }
	 * 
	 */
	public void setCarrier(DCarrier value) {
		this.carrier = value;
	}

	/**
	 * Gets the value of the equipment property.
	 * 
	 * @return possible object is {@link DEquipment }
	 * 
	 */
	public DEquipment getEquipment() {
		return equipment;
	}

	/**
	 * Sets the value of the equipment property.
	 * 
	 * @param value
	 *            allowed object is {@link DEquipment }
	 * 
	 */
	public void setEquipment(DEquipment value) {
		this.equipment = value;
	}

	/**
	 * Gets the value of the productionLine property.
	 * 
	 * @return possible object is {@link DProductionLine }
	 * 
	 */
	public DProductionLine getProductionLine() {
		return productionLine;
	}

	/**
	 * Sets the value of the productionLine property.
	 * 
	 * @param value
	 *            allowed object is {@link DProductionLine }
	 * 
	 */
	public void setProductionLine(DProductionLine value) {
		this.productionLine = value;
	}

	/**
	 * Gets the value of the site property.
	 * 
	 * @return possible object is {@link DSite }
	 * 
	 */
	public DSite getSite() {
		return site;
	}

	/**
	 * Sets the value of the site property.
	 * 
	 * @param value
	 *            allowed object is {@link DSite }
	 * 
	 */
	public void setSite(DSite value) {
		this.site = value;
	}

	/**
	 * Gets the value of the storageUnit property.
	 * 
	 * @return possible object is {@link DStorageUnit }
	 * 
	 */
	public DStorageUnit getStorageUnit() {
		return storageUnit;
	}

	/**
	 * Sets the value of the storageUnit property.
	 * 
	 * @param value
	 *            allowed object is {@link DStorageUnit }
	 * 
	 */
	public void setStorageUnit(DStorageUnit value) {
		this.storageUnit = value;
	}

	/**
	 * Gets the value of the storageZone property.
	 * 
	 * @return possible object is {@link DStorageZone }
	 * 
	 */
	public DStorageZone getStorageZone() {
		return storageZone;
	}

	/**
	 * Sets the value of the storageZone property.
	 * 
	 * @param value
	 *            allowed object is {@link DStorageZone }
	 * 
	 */
	public void setStorageZone(DStorageZone value) {
		this.storageZone = value;
	}

	/**
	 * Gets the value of the workCenter property.
	 * 
	 * @return possible object is {@link DWorkCenter }
	 * 
	 */
	public DWorkCenter getWorkCenter() {
		return workCenter;
	}

	/**
	 * Sets the value of the workCenter property.
	 * 
	 * @param value
	 *            allowed object is {@link DWorkCenter }
	 * 
	 */
	public void setWorkCenter(DWorkCenter value) {
		this.workCenter = value;
	}

}
