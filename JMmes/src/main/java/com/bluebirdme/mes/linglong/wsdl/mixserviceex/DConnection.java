package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DConnection complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DConnection">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="applicationType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="directions" type="{dataobjects.common.plantops.datasweep.com}DConnectionDirection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ownerKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ownerType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="sublotAccessType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DConnection", propOrder = { "applicationType",
		"currentStates", "directions", "enabled", "ownerKey", "ownerType",
		"sublotAccessType", "text", "userDefinedAttributes" })
public class DConnection extends DCategorical {

	protected int applicationType;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	@XmlElement(nillable = true)
	protected List<DConnectionDirection> directions;
	protected boolean enabled;
	protected long ownerKey;
	protected short ownerType;
	protected short sublotAccessType;
	protected String text;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the applicationType property.
	 * 
	 */
	public int getApplicationType() {
		return applicationType;
	}

	/**
	 * Sets the value of the applicationType property.
	 * 
	 */
	public void setApplicationType(int value) {
		this.applicationType = value;
	}

	/**
	 * Gets the value of the currentStates property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the currentStates property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCurrentStates().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DObjectState }
	 * 
	 * 
	 */
	public List<DObjectState> getCurrentStates() {
		if (currentStates == null) {
			currentStates = new ArrayList<DObjectState>();
		}
		return this.currentStates;
	}

	/**
	 * Gets the value of the directions property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the directions property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDirections().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DConnectionDirection }
	 * 
	 * 
	 */
	public List<DConnectionDirection> getDirections() {
		if (directions == null) {
			directions = new ArrayList<DConnectionDirection>();
		}
		return this.directions;
	}

	/**
	 * Gets the value of the enabled property.
	 * 
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Sets the value of the enabled property.
	 * 
	 */
	public void setEnabled(boolean value) {
		this.enabled = value;
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
	 * Gets the value of the sublotAccessType property.
	 * 
	 */
	public short getSublotAccessType() {
		return sublotAccessType;
	}

	/**
	 * Sets the value of the sublotAccessType property.
	 * 
	 */
	public void setSublotAccessType(short value) {
		this.sublotAccessType = value;
	}

	/**
	 * Gets the value of the text property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the value of the text property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setText(String value) {
		this.text = value;
	}

	/**
	 * Gets the value of the userDefinedAttributes property.
	 * 
	 * @return possible object is {@link DUDAInstance }
	 * 
	 */
	public DUDAInstance getUserDefinedAttributes() {
		return userDefinedAttributes;
	}

	/**
	 * Sets the value of the userDefinedAttributes property.
	 * 
	 * @param value
	 *            allowed object is {@link DUDAInstance }
	 * 
	 */
	public void setUserDefinedAttributes(DUDAInstance value) {
		this.userDefinedAttributes = value;
	}

}
