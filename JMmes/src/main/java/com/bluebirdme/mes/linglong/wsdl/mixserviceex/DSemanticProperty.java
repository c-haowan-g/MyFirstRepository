package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSemanticProperty complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSemanticProperty">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="defaultDataValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="semanticType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="systemDefined" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="usedFor" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSemanticProperty", propOrder = { "dataType",
		"defaultDataValue", "deletePrivilegeKey", "objectType", "semanticType",
		"systemDefined", "updatePrivilegeKey", "usedFor" })
public class DSemanticProperty extends DCategorical {

	protected short dataType;
	protected String defaultDataValue;
	protected long deletePrivilegeKey;
	protected short objectType;
	protected short semanticType;
	protected boolean systemDefined;
	protected long updatePrivilegeKey;
	protected short usedFor;

	/**
	 * Gets the value of the dataType property.
	 * 
	 */
	public short getDataType() {
		return dataType;
	}

	/**
	 * Sets the value of the dataType property.
	 * 
	 */
	public void setDataType(short value) {
		this.dataType = value;
	}

	/**
	 * Gets the value of the defaultDataValue property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDefaultDataValue() {
		return defaultDataValue;
	}

	/**
	 * Sets the value of the defaultDataValue property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDefaultDataValue(String value) {
		this.defaultDataValue = value;
	}

	/**
	 * Gets the value of the deletePrivilegeKey property.
	 * 
	 */
	public long getDeletePrivilegeKey() {
		return deletePrivilegeKey;
	}

	/**
	 * Sets the value of the deletePrivilegeKey property.
	 * 
	 */
	public void setDeletePrivilegeKey(long value) {
		this.deletePrivilegeKey = value;
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
	 * Gets the value of the semanticType property.
	 * 
	 */
	public short getSemanticType() {
		return semanticType;
	}

	/**
	 * Sets the value of the semanticType property.
	 * 
	 */
	public void setSemanticType(short value) {
		this.semanticType = value;
	}

	/**
	 * Gets the value of the systemDefined property.
	 * 
	 */
	public boolean isSystemDefined() {
		return systemDefined;
	}

	/**
	 * Sets the value of the systemDefined property.
	 * 
	 */
	public void setSystemDefined(boolean value) {
		this.systemDefined = value;
	}

	/**
	 * Gets the value of the updatePrivilegeKey property.
	 * 
	 */
	public long getUpdatePrivilegeKey() {
		return updatePrivilegeKey;
	}

	/**
	 * Sets the value of the updatePrivilegeKey property.
	 * 
	 */
	public void setUpdatePrivilegeKey(long value) {
		this.updatePrivilegeKey = value;
	}

	/**
	 * Gets the value of the usedFor property.
	 * 
	 */
	public short getUsedFor() {
		return usedFor;
	}

	/**
	 * Sets the value of the usedFor property.
	 * 
	 */
	public void setUsedFor(short value) {
		this.usedFor = value;
	}

}
