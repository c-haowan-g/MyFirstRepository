package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DFSMConfigurationItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DFSMConfigurationItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="FSMConfigurationKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FSMKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FSMRelationshipName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FSMRelationshipType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DFSMConfigurationItem", propOrder = { "fsmConfigurationKey",
		"fsmKey", "fsmRelationshipName", "fsmRelationshipType" })
public class DFSMConfigurationItem extends DKeyed {

	@XmlElement(name = "FSMConfigurationKey")
	protected long fsmConfigurationKey;
	@XmlElement(name = "FSMKey")
	protected long fsmKey;
	@XmlElement(name = "FSMRelationshipName")
	protected String fsmRelationshipName;
	@XmlElement(name = "FSMRelationshipType")
	protected short fsmRelationshipType;

	/**
	 * Gets the value of the fsmConfigurationKey property.
	 * 
	 */
	public long getFSMConfigurationKey() {
		return fsmConfigurationKey;
	}

	/**
	 * Sets the value of the fsmConfigurationKey property.
	 * 
	 */
	public void setFSMConfigurationKey(long value) {
		this.fsmConfigurationKey = value;
	}

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
	 * Gets the value of the fsmRelationshipName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFSMRelationshipName() {
		return fsmRelationshipName;
	}

	/**
	 * Sets the value of the fsmRelationshipName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFSMRelationshipName(String value) {
		this.fsmRelationshipName = value;
	}

	/**
	 * Gets the value of the fsmRelationshipType property.
	 * 
	 */
	public short getFSMRelationshipType() {
		return fsmRelationshipType;
	}

	/**
	 * Sets the value of the fsmRelationshipType property.
	 * 
	 */
	public void setFSMRelationshipType(short value) {
		this.fsmRelationshipType = value;
	}

}
