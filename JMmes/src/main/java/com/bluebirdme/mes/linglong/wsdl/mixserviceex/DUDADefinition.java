package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DUDADefinition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DUDADefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="items" type="{dataobjects.common.plantops.datasweep.com}DUDADefinitionItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="predefinedDateItemCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="predefinedStringItemCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DUDADefinition", propOrder = { "auditInfo", "items",
		"lastModifiedTime", "predefinedDateItemCount",
		"predefinedStringItemCount" })
public class DUDADefinition extends DKeyed {

	protected DAuditInfo auditInfo;
	@XmlElement(nillable = true)
	protected List<DUDADefinitionItem> items;
	protected DTimestamp lastModifiedTime;
	protected int predefinedDateItemCount;
	protected int predefinedStringItemCount;

	/**
	 * Gets the value of the auditInfo property.
	 * 
	 * @return possible object is {@link DAuditInfo }
	 * 
	 */
	public DAuditInfo getAuditInfo() {
		return auditInfo;
	}

	/**
	 * Sets the value of the auditInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DAuditInfo }
	 * 
	 */
	public void setAuditInfo(DAuditInfo value) {
		this.auditInfo = value;
	}

	/**
	 * Gets the value of the items property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the items property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DUDADefinitionItem }
	 * 
	 * 
	 */
	public List<DUDADefinitionItem> getItems() {
		if (items == null) {
			items = new ArrayList<DUDADefinitionItem>();
		}
		return this.items;
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

	/**
	 * Gets the value of the predefinedDateItemCount property.
	 * 
	 */
	public int getPredefinedDateItemCount() {
		return predefinedDateItemCount;
	}

	/**
	 * Sets the value of the predefinedDateItemCount property.
	 * 
	 */
	public void setPredefinedDateItemCount(int value) {
		this.predefinedDateItemCount = value;
	}

	/**
	 * Gets the value of the predefinedStringItemCount property.
	 * 
	 */
	public int getPredefinedStringItemCount() {
		return predefinedStringItemCount;
	}

	/**
	 * Sets the value of the predefinedStringItemCount property.
	 * 
	 */
	public void setPredefinedStringItemCount(int value) {
		this.predefinedStringItemCount = value;
	}

}
