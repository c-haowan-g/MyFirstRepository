package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAbstractChecklistItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAbstractChecklistItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="dataItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="itemOrder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DAbstractChecklistItem", propOrder = { "dataItemName",
		"description", "itemOrder", "lastModifiedTime" })
public abstract class DAbstractChecklistItem extends DKeyed {

	protected String dataItemName;
	protected String description;
	protected int itemOrder;
	protected DTimestamp lastModifiedTime;

	/**
	 * Gets the value of the dataItemName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDataItemName() {
		return dataItemName;
	}

	/**
	 * Sets the value of the dataItemName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDataItemName(String value) {
		this.dataItemName = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the itemOrder property.
	 * 
	 */
	public int getItemOrder() {
		return itemOrder;
	}

	/**
	 * Sets the value of the itemOrder property.
	 * 
	 */
	public void setItemOrder(int value) {
		this.itemOrder = value;
	}

	/**
	 * Gets the value of the lastModifiedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getLastModifiedTime() {
		return lastModifiedTime;
	}

	/**
	 * Sets the value of the lastModifiedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setLastModifiedTime(DTimestamp value) {
		this.lastModifiedTime = value;
	}

}
