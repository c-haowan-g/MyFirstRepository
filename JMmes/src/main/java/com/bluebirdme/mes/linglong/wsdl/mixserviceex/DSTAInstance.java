package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSTAInstance complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSTAInstance">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="FSMKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="ownerKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="STADefinitionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="STAInstanceItems" type="{dataobjects.common.plantops.datasweep.com}DSTAInstanceItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSTAInstance", propOrder = { "fsmKey", "lastModifiedTime",
		"ownerKey", "staDefinitionKey", "staInstanceItems" })
public class DSTAInstance extends DKeyed {

	@XmlElement(name = "FSMKey")
	protected long fsmKey;
	protected DTimestamp lastModifiedTime;
	protected long ownerKey;
	@XmlElement(name = "STADefinitionKey")
	protected long staDefinitionKey;
	@XmlElement(name = "STAInstanceItems", nillable = true)
	protected List<DSTAInstanceItem> staInstanceItems;

	/**
	 * Gets the value of the fsmKey property.
	 * 
	 */
	public long getFSMKey() {
		return fsmKey;
	}

	/**
	 * Sets the value of the fsmKey property.
	 * 
	 */
	public void setFSMKey(long value) {
		this.fsmKey = value;
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
	 * Gets the value of the staDefinitionKey property.
	 * 
	 */
	public long getSTADefinitionKey() {
		return staDefinitionKey;
	}

	/**
	 * Sets the value of the staDefinitionKey property.
	 * 
	 */
	public void setSTADefinitionKey(long value) {
		this.staDefinitionKey = value;
	}

	/**
	 * Gets the value of the staInstanceItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the staInstanceItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSTAInstanceItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DSTAInstanceItem }
	 * 
	 * 
	 */
	public List<DSTAInstanceItem> getSTAInstanceItems() {
		if (staInstanceItems == null) {
			staInstanceItems = new ArrayList<DSTAInstanceItem>();
		}
		return this.staInstanceItems;
	}

}
