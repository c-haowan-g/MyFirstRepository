package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DResourceArc complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DResourceArc">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="entryRules" type="{dataobjects.common.plantops.datasweep.com}DResourceArcRule" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fromStepName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mainPath" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="toStepName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DResourceArc", propOrder = { "entryRules", "fromStepName",
		"mainPath", "toStepName", "userDefinedAttributes" })
public class DResourceArc extends DKeyed {

	@XmlElement(nillable = true)
	protected List<DResourceArcRule> entryRules;
	protected String fromStepName;
	protected boolean mainPath;
	protected String toStepName;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the entryRules property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the entryRules property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getEntryRules().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DResourceArcRule }
	 * 
	 * 
	 */
	public List<DResourceArcRule> getEntryRules() {
		if (entryRules == null) {
			entryRules = new ArrayList<DResourceArcRule>();
		}
		return this.entryRules;
	}

	/**
	 * Gets the value of the fromStepName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFromStepName() {
		return fromStepName;
	}

	/**
	 * Sets the value of the fromStepName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFromStepName(String value) {
		this.fromStepName = value;
	}

	/**
	 * Gets the value of the mainPath property.
	 * 
	 */
	public boolean isMainPath() {
		return mainPath;
	}

	/**
	 * Sets the value of the mainPath property.
	 * 
	 */
	public void setMainPath(boolean value) {
		this.mainPath = value;
	}

	/**
	 * Gets the value of the toStepName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getToStepName() {
		return toStepName;
	}

	/**
	 * Sets the value of the toStepName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setToStepName(String value) {
		this.toStepName = value;
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
