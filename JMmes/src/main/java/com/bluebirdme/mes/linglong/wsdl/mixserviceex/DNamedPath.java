package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DNamedPath complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DNamedPath">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="destinationKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="destinationType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="namedPathSegments" type="{dataobjects.common.plantops.datasweep.com}DNamedPathSegment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="path" type="{dataobjects.common.plantops.datasweep.com}DPath" minOccurs="0"/>
 *         &lt;element name="sourceKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sourceType" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
@XmlType(name = "DNamedPath", propOrder = { "currentStates",
		"deletePrivilegeKey", "destinationKey", "destinationType", "enabled",
		"namedPathSegments", "path", "sourceKey", "sourceType",
		"updatePrivilegeKey", "userDefinedAttributes" })
public class DNamedPath extends DCategorical {

	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected long deletePrivilegeKey;
	protected long destinationKey;
	protected short destinationType;
	protected boolean enabled;
	@XmlElement(nillable = true)
	protected List<DNamedPathSegment> namedPathSegments;
	protected DPath path;
	protected long sourceKey;
	protected short sourceType;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;

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
	 * Gets the value of the destinationKey property.
	 * 
	 */
	public long getDestinationKey() {
		return destinationKey;
	}

	/**
	 * Sets the value of the destinationKey property.
	 * 
	 */
	public void setDestinationKey(long value) {
		this.destinationKey = value;
	}

	/**
	 * Gets the value of the destinationType property.
	 * 
	 */
	public short getDestinationType() {
		return destinationType;
	}

	/**
	 * Sets the value of the destinationType property.
	 * 
	 */
	public void setDestinationType(short value) {
		this.destinationType = value;
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
	 * Gets the value of the namedPathSegments property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the namedPathSegments property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getNamedPathSegments().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DNamedPathSegment }
	 * 
	 * 
	 */
	public List<DNamedPathSegment> getNamedPathSegments() {
		if (namedPathSegments == null) {
			namedPathSegments = new ArrayList<DNamedPathSegment>();
		}
		return this.namedPathSegments;
	}

	/**
	 * Gets the value of the path property.
	 * 
	 * @return possible object is {@link DPath }
	 * 
	 */
	public DPath getPath() {
		return path;
	}

	/**
	 * Sets the value of the path property.
	 * 
	 * @param value
	 *            allowed object is {@link DPath }
	 * 
	 */
	public void setPath(DPath value) {
		this.path = value;
	}

	/**
	 * Gets the value of the sourceKey property.
	 * 
	 */
	public long getSourceKey() {
		return sourceKey;
	}

	/**
	 * Sets the value of the sourceKey property.
	 * 
	 */
	public void setSourceKey(long value) {
		this.sourceKey = value;
	}

	/**
	 * Gets the value of the sourceType property.
	 * 
	 */
	public short getSourceType() {
		return sourceType;
	}

	/**
	 * Sets the value of the sourceType property.
	 * 
	 */
	public void setSourceType(short value) {
		this.sourceType = value;
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
