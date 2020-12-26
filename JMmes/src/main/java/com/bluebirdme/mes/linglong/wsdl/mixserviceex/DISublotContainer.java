package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DISublotContainer complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DISublotContainer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carrier" type="{dataobjects.common.plantops.datasweep.com}DCarrier" minOccurs="0"/>
 *         &lt;element name="connection" type="{dataobjects.common.plantops.datasweep.com}DConnection" minOccurs="0"/>
 *         &lt;element name="equipment" type="{dataobjects.common.plantops.datasweep.com}DEquipment" minOccurs="0"/>
 *         &lt;element name="productionLine" type="{dataobjects.common.plantops.datasweep.com}DProductionLine" minOccurs="0"/>
 *         &lt;element name="storageUnit" type="{dataobjects.common.plantops.datasweep.com}DStorageUnit" minOccurs="0"/>
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
@XmlType(name = "DISublotContainer", propOrder = { "carrier", "connection",
		"equipment", "productionLine", "storageUnit", "workCenter" })
public class DISublotContainer {

	protected DCarrier carrier;
	protected DConnection connection;
	protected DEquipment equipment;
	protected DProductionLine productionLine;
	protected DStorageUnit storageUnit;
	protected DWorkCenter workCenter;

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
	 * Gets the value of the connection property.
	 * 
	 * @return possible object is {@link DConnection }
	 * 
	 */
	public DConnection getConnection() {
		return connection;
	}

	/**
	 * Sets the value of the connection property.
	 * 
	 * @param value
	 *            allowed object is {@link DConnection }
	 * 
	 */
	public void setConnection(DConnection value) {
		this.connection = value;
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
