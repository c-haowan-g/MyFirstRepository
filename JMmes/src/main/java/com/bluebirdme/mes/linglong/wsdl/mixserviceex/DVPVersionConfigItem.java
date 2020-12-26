package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DVPVersionConfigItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DVPVersionConfigItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="childrenFunction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="parentFunction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relationShipName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="targetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VPVersionConfigurationKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVPVersionConfigItem", propOrder = { "childrenFunction",
		"objectType", "parentFunction", "relationShipName", "targetName",
		"vpVersionConfigurationKey" })
public class DVPVersionConfigItem extends DKeyed {

	protected String childrenFunction;
	protected short objectType;
	protected String parentFunction;
	protected String relationShipName;
	protected String targetName;
	@XmlElement(name = "VPVersionConfigurationKey")
	protected long vpVersionConfigurationKey;

	/**
	 * Gets the value of the childrenFunction property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getChildrenFunction() {
		return childrenFunction;
	}

	/**
	 * Sets the value of the childrenFunction property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setChildrenFunction(String value) {
		this.childrenFunction = value;
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
	 * Gets the value of the parentFunction property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getParentFunction() {
		return parentFunction;
	}

	/**
	 * Sets the value of the parentFunction property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setParentFunction(String value) {
		this.parentFunction = value;
	}

	/**
	 * Gets the value of the relationShipName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRelationShipName() {
		return relationShipName;
	}

	/**
	 * Sets the value of the relationShipName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRelationShipName(String value) {
		this.relationShipName = value;
	}

	/**
	 * Gets the value of the targetName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTargetName() {
		return targetName;
	}

	/**
	 * Sets the value of the targetName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTargetName(String value) {
		this.targetName = value;
	}

	/**
	 * Gets the value of the vpVersionConfigurationKey property.
	 * 
	 */
	public long getVPVersionConfigurationKey() {
		return vpVersionConfigurationKey;
	}

	/**
	 * Sets the value of the vpVersionConfigurationKey property.
	 * 
	 */
	public void setVPVersionConfigurationKey(long value) {
		this.vpVersionConfigurationKey = value;
	}

}
