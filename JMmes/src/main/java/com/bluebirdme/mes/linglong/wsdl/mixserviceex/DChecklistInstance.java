package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DChecklistInstance complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DChecklistInstance">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DAbstractChecklist">
 *       &lt;sequence>
 *         &lt;element name="checklistItems" type="{dataobjects.common.plantops.datasweep.com}DChecklistInstanceItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="checklistItemsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="checklistName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="routeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="routeStepName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DChecklistInstance", propOrder = { "checklistItems",
		"checklistItemsChanged", "checklistName", "objectKey", "objectType",
		"routeKey", "routeStepName", "userName" })
public class DChecklistInstance extends DAbstractChecklist {

	@XmlElement(nillable = true)
	protected List<DChecklistInstanceItem> checklistItems;
	protected boolean checklistItemsChanged;
	protected String checklistName;
	protected long objectKey;
	protected String objectType;
	protected long routeKey;
	protected String routeStepName;
	protected String userName;

	/**
	 * Gets the value of the checklistItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the checklistItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getChecklistItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DChecklistInstanceItem }
	 * 
	 * 
	 */
	public List<DChecklistInstanceItem> getChecklistItems() {
		if (checklistItems == null) {
			checklistItems = new ArrayList<DChecklistInstanceItem>();
		}
		return this.checklistItems;
	}

	/**
	 * Gets the value of the checklistItemsChanged property.
	 * 
	 */
	public boolean isChecklistItemsChanged() {
		return checklistItemsChanged;
	}

	/**
	 * Sets the value of the checklistItemsChanged property.
	 * 
	 */
	public void setChecklistItemsChanged(boolean value) {
		this.checklistItemsChanged = value;
	}

	/**
	 * Gets the value of the checklistName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getChecklistName() {
		return checklistName;
	}

	/**
	 * Sets the value of the checklistName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setChecklistName(String value) {
		this.checklistName = value;
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
	 * @return possible object is {@link String }
	 * 
	 */
	public String getObjectType() {
		return objectType;
	}

	/**
	 * Sets the value of the objectType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setObjectType(String value) {
		this.objectType = value;
	}

	/**
	 * Gets the value of the routeKey property.
	 * 
	 */
	public long getRouteKey() {
		return routeKey;
	}

	/**
	 * Sets the value of the routeKey property.
	 * 
	 */
	public void setRouteKey(long value) {
		this.routeKey = value;
	}

	/**
	 * Gets the value of the routeStepName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRouteStepName() {
		return routeStepName;
	}

	/**
	 * Sets the value of the routeStepName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRouteStepName(String value) {
		this.routeStepName = value;
	}

	/**
	 * Gets the value of the userName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the value of the userName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUserName(String value) {
		this.userName = value;
	}

}
