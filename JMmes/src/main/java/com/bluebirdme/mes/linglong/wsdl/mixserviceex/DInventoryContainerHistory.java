package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DInventoryContainerHistory complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DInventoryContainerHistory">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="entryShiftKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="entryTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="entryUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="exitShiftKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="exitTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="exitUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inventoryContainerKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="inventoryContainerParentKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="inventoryContainerParentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inventoryContainerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DInventoryContainerHistory", propOrder = { "entryShiftKey",
		"entryTime", "entryUserName", "exitShiftKey", "exitTime",
		"exitUserName", "inventoryContainerKey", "inventoryContainerParentKey",
		"inventoryContainerParentType", "inventoryContainerType" })
public class DInventoryContainerHistory extends DKeyed {

	protected long entryShiftKey;
	protected DTimestamp entryTime;
	protected String entryUserName;
	protected long exitShiftKey;
	protected DTimestamp exitTime;
	protected String exitUserName;
	protected long inventoryContainerKey;
	protected long inventoryContainerParentKey;
	protected String inventoryContainerParentType;
	protected String inventoryContainerType;

	/**
	 * Gets the value of the entryShiftKey property.
	 * 
	 */
	public long getEntryShiftKey() {
		return entryShiftKey;
	}

	/**
	 * Sets the value of the entryShiftKey property.
	 * 
	 */
	public void setEntryShiftKey(long value) {
		this.entryShiftKey = value;
	}

	/**
	 * Gets the value of the entryTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEntryTime() {
		return entryTime;
	}

	/**
	 * Sets the value of the entryTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEntryTime(DTimestamp value) {
		this.entryTime = value;
	}

	/**
	 * Gets the value of the entryUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEntryUserName() {
		return entryUserName;
	}

	/**
	 * Sets the value of the entryUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntryUserName(String value) {
		this.entryUserName = value;
	}

	/**
	 * Gets the value of the exitShiftKey property.
	 * 
	 */
	public long getExitShiftKey() {
		return exitShiftKey;
	}

	/**
	 * Sets the value of the exitShiftKey property.
	 * 
	 */
	public void setExitShiftKey(long value) {
		this.exitShiftKey = value;
	}

	/**
	 * Gets the value of the exitTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getExitTime() {
		return exitTime;
	}

	/**
	 * Sets the value of the exitTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setExitTime(DTimestamp value) {
		this.exitTime = value;
	}

	/**
	 * Gets the value of the exitUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExitUserName() {
		return exitUserName;
	}

	/**
	 * Sets the value of the exitUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExitUserName(String value) {
		this.exitUserName = value;
	}

	/**
	 * Gets the value of the inventoryContainerKey property.
	 * 
	 */
	public long getInventoryContainerKey() {
		return inventoryContainerKey;
	}

	/**
	 * Sets the value of the inventoryContainerKey property.
	 * 
	 */
	public void setInventoryContainerKey(long value) {
		this.inventoryContainerKey = value;
	}

	/**
	 * Gets the value of the inventoryContainerParentKey property.
	 * 
	 */
	public long getInventoryContainerParentKey() {
		return inventoryContainerParentKey;
	}

	/**
	 * Sets the value of the inventoryContainerParentKey property.
	 * 
	 */
	public void setInventoryContainerParentKey(long value) {
		this.inventoryContainerParentKey = value;
	}

	/**
	 * Gets the value of the inventoryContainerParentType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getInventoryContainerParentType() {
		return inventoryContainerParentType;
	}

	/**
	 * Sets the value of the inventoryContainerParentType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInventoryContainerParentType(String value) {
		this.inventoryContainerParentType = value;
	}

	/**
	 * Gets the value of the inventoryContainerType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getInventoryContainerType() {
		return inventoryContainerType;
	}

	/**
	 * Sets the value of the inventoryContainerType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInventoryContainerType(String value) {
		this.inventoryContainerType = value;
	}

}
