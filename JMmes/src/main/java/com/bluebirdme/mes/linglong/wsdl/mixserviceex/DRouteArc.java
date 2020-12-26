package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DRouteArc complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DRouteArc">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="entryRules" type="{dataobjects.common.plantops.datasweep.com}DRouteArcRule" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fromNodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromNodeType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="mainPath" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="toNodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toNodeType" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
@XmlType(name = "DRouteArc", propOrder = { "entryRules", "fromNodeName",
		"fromNodeType", "mainPath", "toNodeName", "toNodeType",
		"userDefinedAttributes" })
public class DRouteArc extends DKeyed {

	@XmlElement(nillable = true)
	protected List<DRouteArcRule> entryRules;
	protected String fromNodeName;
	protected short fromNodeType;
	protected boolean mainPath;
	protected String toNodeName;
	protected short toNodeType;
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
	 * {@link DRouteArcRule }
	 * 
	 * 
	 */
	public List<DRouteArcRule> getEntryRules() {
		if (entryRules == null) {
			entryRules = new ArrayList<DRouteArcRule>();
		}
		return this.entryRules;
	}

	/**
	 * Gets the value of the fromNodeName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFromNodeName() {
		return fromNodeName;
	}

	/**
	 * Sets the value of the fromNodeName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFromNodeName(String value) {
		this.fromNodeName = value;
	}

	/**
	 * Gets the value of the fromNodeType property.
	 * 
	 */
	public short getFromNodeType() {
		return fromNodeType;
	}

	/**
	 * Sets the value of the fromNodeType property.
	 * 
	 */
	public void setFromNodeType(short value) {
		this.fromNodeType = value;
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
	 * Gets the value of the toNodeName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getToNodeName() {
		return toNodeName;
	}

	/**
	 * Sets the value of the toNodeName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setToNodeName(String value) {
		this.toNodeName = value;
	}

	/**
	 * Gets the value of the toNodeType property.
	 * 
	 */
	public short getToNodeType() {
		return toNodeType;
	}

	/**
	 * Sets the value of the toNodeType property.
	 * 
	 */
	public void setToNodeType(short value) {
		this.toNodeType = value;
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
