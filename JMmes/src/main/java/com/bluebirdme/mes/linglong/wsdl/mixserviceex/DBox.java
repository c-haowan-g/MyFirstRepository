package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DBox complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DBox">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DTrackable">
 *       &lt;sequence>
 *         &lt;element name="boxCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="containerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="containerType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="extendedAttributes" type="{dataobjects.common.plantops.datasweep.com}DBoxExtended" minOccurs="0"/>
 *         &lt;element name="lotCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="partialLotCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="unitCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DBox", propOrder = { "boxCount", "capacity", "containerName",
		"containerType", "extendedAttributes", "lotCount", "partialLotCount",
		"quantity", "type", "unitCount" })
public class DBox extends DTrackable {

	protected int boxCount;
	protected int capacity;
	protected String containerName;
	protected short containerType;
	protected DBoxExtended extendedAttributes;
	protected int lotCount;
	protected int partialLotCount;
	protected int quantity;
	protected short type;
	protected int unitCount;

	/**
	 * Gets the value of the boxCount property.
	 * 
	 */
	public int getBoxCount() {
		return boxCount;
	}

	/**
	 * Sets the value of the boxCount property.
	 * 
	 */
	public void setBoxCount(int value) {
		this.boxCount = value;
	}

	/**
	 * Gets the value of the capacity property.
	 * 
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Sets the value of the capacity property.
	 * 
	 */
	public void setCapacity(int value) {
		this.capacity = value;
	}

	/**
	 * Gets the value of the containerName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getContainerName() {
		return containerName;
	}

	/**
	 * Sets the value of the containerName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setContainerName(String value) {
		this.containerName = value;
	}

	/**
	 * Gets the value of the containerType property.
	 * 
	 */
	public short getContainerType() {
		return containerType;
	}

	/**
	 * Sets the value of the containerType property.
	 * 
	 */
	public void setContainerType(short value) {
		this.containerType = value;
	}

	/**
	 * Gets the value of the extendedAttributes property.
	 * 
	 * @return possible object is {@link DBoxExtended }
	 * 
	 */
	public DBoxExtended getExtendedAttributes() {
		return extendedAttributes;
	}

	/**
	 * Sets the value of the extendedAttributes property.
	 * 
	 * @param value
	 *            allowed object is {@link DBoxExtended }
	 * 
	 */
	public void setExtendedAttributes(DBoxExtended value) {
		this.extendedAttributes = value;
	}

	/**
	 * Gets the value of the lotCount property.
	 * 
	 */
	public int getLotCount() {
		return lotCount;
	}

	/**
	 * Sets the value of the lotCount property.
	 * 
	 */
	public void setLotCount(int value) {
		this.lotCount = value;
	}

	/**
	 * Gets the value of the partialLotCount property.
	 * 
	 */
	public int getPartialLotCount() {
		return partialLotCount;
	}

	/**
	 * Sets the value of the partialLotCount property.
	 * 
	 */
	public void setPartialLotCount(int value) {
		this.partialLotCount = value;
	}

	/**
	 * Gets the value of the quantity property.
	 * 
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the value of the quantity property.
	 * 
	 */
	public void setQuantity(int value) {
		this.quantity = value;
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

	/**
	 * Gets the value of the unitCount property.
	 * 
	 */
	public int getUnitCount() {
		return unitCount;
	}

	/**
	 * Sets the value of the unitCount property.
	 * 
	 */
	public void setUnitCount(int value) {
		this.unitCount = value;
	}

}
