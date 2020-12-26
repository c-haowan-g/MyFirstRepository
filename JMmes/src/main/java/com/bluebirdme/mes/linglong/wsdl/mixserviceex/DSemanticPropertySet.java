package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSemanticPropertySet complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSemanticPropertySet">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="semanticPropertyKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="semanticPropertyKeysChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="semanticPropertyListKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DSemanticPropertySet", propOrder = { "deletePrivilegeKey",
		"semanticPropertyKeys", "semanticPropertyKeysChanged",
		"semanticPropertyListKey", "updatePrivilegeKey",
		"userDefinedAttributes" })
public class DSemanticPropertySet extends DCategorical {

	protected long deletePrivilegeKey;
	@XmlElement(type = Long.class)
	protected List<Long> semanticPropertyKeys;
	protected boolean semanticPropertyKeysChanged;
	protected long semanticPropertyListKey;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;

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
	 * Gets the value of the semanticPropertyKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the semanticPropertyKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSemanticPropertyKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getSemanticPropertyKeys() {
		if (semanticPropertyKeys == null) {
			semanticPropertyKeys = new ArrayList<Long>();
		}
		return this.semanticPropertyKeys;
	}

	/**
	 * Gets the value of the semanticPropertyKeysChanged property.
	 * 
	 */
	public boolean isSemanticPropertyKeysChanged() {
		return semanticPropertyKeysChanged;
	}

	/**
	 * Sets the value of the semanticPropertyKeysChanged property.
	 * 
	 */
	public void setSemanticPropertyKeysChanged(boolean value) {
		this.semanticPropertyKeysChanged = value;
	}

	/**
	 * Gets the value of the semanticPropertyListKey property.
	 * 
	 */
	public long getSemanticPropertyListKey() {
		return semanticPropertyListKey;
	}

	/**
	 * Sets the value of the semanticPropertyListKey property.
	 * 
	 */
	public void setSemanticPropertyListKey(long value) {
		this.semanticPropertyListKey = value;
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
