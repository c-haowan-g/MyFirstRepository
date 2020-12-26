package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DApplicationLogItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DApplicationLogItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="applicationKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DApplicationLogItems" type="{dataobjects.common.plantops.datasweep.com}DApplicationLogItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="logEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="parentKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="parentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DApplicationLogItem", propOrder = { "applicationKey",
		"dApplicationLogItems", "logEnabled", "parentKey", "parentType" })
public class DApplicationLogItem extends DCategorical {

	protected long applicationKey;
	@XmlElement(name = "DApplicationLogItems", nillable = true)
	protected List<DApplicationLogItem> dApplicationLogItems;
	protected boolean logEnabled;
	protected long parentKey;
	protected String parentType;

	/**
	 * Gets the value of the applicationKey property.
	 * 
	 */
	public long getApplicationKey() {
		return applicationKey;
	}

	/**
	 * Sets the value of the applicationKey property.
	 * 
	 */
	public void setApplicationKey(long value) {
		this.applicationKey = value;
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
	 * Gets the value of the logEnabled property.
	 * 
	 */
	public boolean isLogEnabled() {
		return logEnabled;
	}

	/**
	 * Sets the value of the logEnabled property.
	 * 
	 */
	public void setLogEnabled(boolean value) {
		this.logEnabled = value;
	}

	/**
	 * Gets the value of the parentKey property.
	 * 
	 */
	public long getParentKey() {
		return parentKey;
	}

	/**
	 * Sets the value of the parentKey property.
	 * 
	 */
	public void setParentKey(long value) {
		this.parentKey = value;
	}

	/**
	 * Gets the value of the parentType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getParentType() {
		return parentType;
	}

	/**
	 * Sets the value of the parentType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setParentType(String value) {
		this.parentType = value;
	}

}
