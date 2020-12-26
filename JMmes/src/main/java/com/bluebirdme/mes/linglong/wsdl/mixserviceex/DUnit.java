package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DUnit complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DUnit">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DTrackable">
 *       &lt;sequence>
 *         &lt;element name="containerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="containerType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="extendedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUnitExtended" minOccurs="0"/>
 *         &lt;element name="lotName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentLotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="parentSiteNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="parentUnitKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="partNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serialNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TBomKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DUnit", propOrder = { "containerName", "containerType",
		"extendedAttributes", "lotName", "orderNumber", "parentLotKey",
		"parentSiteNumber", "parentUnitKey", "partNumber", "partRevision",
		"serialNumber", "tBomKey" })
public class DUnit extends DTrackable {

	protected String containerName;
	protected short containerType;
	protected DUnitExtended extendedAttributes;
	protected String lotName;
	protected String orderNumber;
	protected long parentLotKey;
	protected int parentSiteNumber;
	protected long parentUnitKey;
	protected String partNumber;
	protected String partRevision;
	protected String serialNumber;
	@XmlElement(name = "TBomKey")
	protected long tBomKey;

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
	 * @return possible object is {@link DUnitExtended }
	 * 
	 */
	public DUnitExtended getExtendedAttributes() {
		return extendedAttributes;
	}

	/**
	 * Sets the value of the extendedAttributes property.
	 * 
	 * @param value
	 *            allowed object is {@link DUnitExtended }
	 * 
	 */
	public void setExtendedAttributes(DUnitExtended value) {
		this.extendedAttributes = value;
	}

	/**
	 * Gets the value of the lotName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLotName() {
		return lotName;
	}

	/**
	 * Sets the value of the lotName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLotName(String value) {
		this.lotName = value;
	}

	/**
	 * Gets the value of the orderNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * Sets the value of the orderNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderNumber(String value) {
		this.orderNumber = value;
	}

	/**
	 * Gets the value of the parentLotKey property.
	 * 
	 */
	public long getParentLotKey() {
		return parentLotKey;
	}

	/**
	 * Sets the value of the parentLotKey property.
	 * 
	 */
	public void setParentLotKey(long value) {
		this.parentLotKey = value;
	}

	/**
	 * Gets the value of the parentSiteNumber property.
	 * 
	 */
	public int getParentSiteNumber() {
		return parentSiteNumber;
	}

	/**
	 * Sets the value of the parentSiteNumber property.
	 * 
	 */
	public void setParentSiteNumber(int value) {
		this.parentSiteNumber = value;
	}

	/**
	 * Gets the value of the parentUnitKey property.
	 * 
	 */
	public long getParentUnitKey() {
		return parentUnitKey;
	}

	/**
	 * Sets the value of the parentUnitKey property.
	 * 
	 */
	public void setParentUnitKey(long value) {
		this.parentUnitKey = value;
	}

	/**
	 * Gets the value of the partNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartNumber() {
		return partNumber;
	}

	/**
	 * Sets the value of the partNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartNumber(String value) {
		this.partNumber = value;
	}

	/**
	 * Gets the value of the partRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartRevision() {
		return partRevision;
	}

	/**
	 * Sets the value of the partRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartRevision(String value) {
		this.partRevision = value;
	}

	/**
	 * Gets the value of the serialNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Sets the value of the serialNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSerialNumber(String value) {
		this.serialNumber = value;
	}

	/**
	 * Gets the value of the tBomKey property.
	 * 
	 */
	public long getTBomKey() {
		return tBomKey;
	}

	/**
	 * Sets the value of the tBomKey property.
	 * 
	 */
	public void setTBomKey(long value) {
		this.tBomKey = value;
	}

}
