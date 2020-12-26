package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DApplicationItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DApplicationItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="DApplicationItems" type="{dataobjects.common.plantops.datasweep.com}DApplicationItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DApplicationLogItems" type="{dataobjects.common.plantops.datasweep.com}DApplicationLogItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DConfigurationProperties" type="{dataobjects.common.plantops.datasweep.com}DConfigurationProperty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="itemsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="objectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="ownerKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ownerType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="owningApplicationKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DApplicationItem", propOrder = { "dApplicationItems",
		"dApplicationLogItems", "dConfigurationProperties", "itemsChanged",
		"objectKey", "objectType", "ownerKey", "ownerType",
		"owningApplicationKey" })
public class DApplicationItem extends DKeyed {

	@XmlElement(name = "DApplicationItems", nillable = true)
	protected List<DApplicationItem> dApplicationItems;
	@XmlElement(name = "DApplicationLogItems", nillable = true)
	protected List<DApplicationLogItem> dApplicationLogItems;
	@XmlElement(name = "DConfigurationProperties", nillable = true)
	protected List<DConfigurationProperty> dConfigurationProperties;
	protected boolean itemsChanged;
	protected long objectKey;
	protected short objectType;
	protected long ownerKey;
	protected short ownerType;
	protected long owningApplicationKey;

	/**
	 * Gets the value of the dApplicationItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dApplicationItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDApplicationItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DApplicationItem }
	 * 
	 * 
	 */
	public List<DApplicationItem> getDApplicationItems() {
		if (dApplicationItems == null) {
			dApplicationItems = new ArrayList<DApplicationItem>();
		}
		return this.dApplicationItems;
	}

	/**
	 * Gets the value of the dApplicationLogItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dApplicationLogItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDApplicationLogItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DApplicationLogItem }
	 * 
	 * 
	 */
	public List<DApplicationLogItem> getDApplicationLogItems() {
		if (dApplicationLogItems == null) {
			dApplicationLogItems = new ArrayList<DApplicationLogItem>();
		}
		return this.dApplicationLogItems;
	}

	/**
	 * Gets the value of the dConfigurationProperties property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dConfigurationProperties property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDConfigurationProperties().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DConfigurationProperty }
	 * 
	 * 
	 */
	public List<DConfigurationProperty> getDConfigurationProperties() {
		if (dConfigurationProperties == null) {
			dConfigurationProperties = new ArrayList<DConfigurationProperty>();
		}
		return this.dConfigurationProperties;
	}

	/**
	 * Gets the value of the itemsChanged property.
	 * 
	 */
	public boolean isItemsChanged() {
		return itemsChanged;
	}

	/**
	 * Sets the value of the itemsChanged property.
	 * 
	 */
	public void setItemsChanged(boolean value) {
		this.itemsChanged = value;
	}

	/**
	 * Gets the value of the objectKey property.
	 * 
	 */
	public long getObjectKey() {
		return objectKey;
	}

	/**
	 * Sets the value of the objectKey property.
	 * 
	 */
	public void setObjectKey(long value) {
		this.objectKey = value;
	}

	/**
	 * Gets the value of the objectType property.
	 * 
	 */
	public short getObjectType() {
		return objectType;
	}

	/**
	 * Sets the value of the objectType property.
	 * 
	 */
	public void setObjectType(short value) {
		this.objectType = value;
	}

	/**
	 * Gets the value of the ownerKey property.
	 * 
	 */
	public long getOwnerKey() {
		return ownerKey;
	}

	/**
	 * Sets the value of the ownerKey property.
	 * 
	 */
	public void setOwnerKey(long value) {
		this.ownerKey = value;
	}

	/**
	 * Gets the value of the ownerType property.
	 * 
	 */
	public short getOwnerType() {
		return ownerType;
	}

	/**
	 * Sets the value of the ownerType property.
	 * 
	 */
	public void setOwnerType(short value) {
		this.ownerType = value;
	}

	/**
	 * Gets the value of the owningApplicationKey property.
	 * 
	 */
	public long getOwningApplicationKey() {
		return owningApplicationKey;
	}

	/**
	 * Sets the value of the owningApplicationKey property.
	 * 
	 */
	public void setOwningApplicationKey(long value) {
		this.owningApplicationKey = value;
	}

}
