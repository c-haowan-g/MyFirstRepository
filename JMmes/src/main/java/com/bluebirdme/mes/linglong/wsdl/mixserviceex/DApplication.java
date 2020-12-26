package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DApplication complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DApplication">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="accessControlInfo" type="{dataobjects.common.plantops.datasweep.com}DAccessControlInfo" minOccurs="0"/>
 *         &lt;element name="copyright" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DApplicationItems" type="{dataobjects.common.plantops.datasweep.com}DApplicationItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DApplicationLogItems" type="{dataobjects.common.plantops.datasweep.com}DApplicationLogItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DConfigurationProperties" type="{dataobjects.common.plantops.datasweep.com}DConfigurationProperty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="itemsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="majorVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minorVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="patchVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DApplication", propOrder = { "accessControlInfo", "copyright",
		"dApplicationItems", "dApplicationLogItems",
		"dConfigurationProperties", "deletePrivilegeKey", "itemsChanged",
		"majorVersion", "minorVersion", "originator", "patchVersion",
		"updatePrivilegeKey", "userDefinedAttributes" })
public class DApplication extends DCategorical {

	protected DAccessControlInfo accessControlInfo;
	protected String copyright;
	@XmlElement(name = "DApplicationItems", nillable = true)
	protected List<DApplicationItem> dApplicationItems;
	@XmlElement(name = "DApplicationLogItems", nillable = true)
	protected List<DApplicationLogItem> dApplicationLogItems;
	@XmlElement(name = "DConfigurationProperties", nillable = true)
	protected List<DConfigurationProperty> dConfigurationProperties;
	protected long deletePrivilegeKey;
	protected boolean itemsChanged;
	protected String majorVersion;
	protected String minorVersion;
	protected String originator;
	protected String patchVersion;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the accessControlInfo property.
	 * 
	 * @return possible object is {@link DAccessControlInfo }
	 * 
	 */
	public DAccessControlInfo getAccessControlInfo() {
		return accessControlInfo;
	}

	/**
	 * Sets the value of the accessControlInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DAccessControlInfo }
	 * 
	 */
	public void setAccessControlInfo(DAccessControlInfo value) {
		this.accessControlInfo = value;
	}

	/**
	 * Gets the value of the copyright property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCopyright() {
		return copyright;
	}

	/**
	 * Sets the value of the copyright property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCopyright(String value) {
		this.copyright = value;
	}

	/**
	 * Gets the value of the dApplicationItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dApplicationItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDApplicationItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DApplicationItem }
	 * 
	 * 
	 */
	public List<DApplicationItem> getDApplicationItems() {
		if (dApplicationItems == null) {
			dApplicationItems = new ArrayList<DApplicationItem>();
		}
		return this.dApplicationItems;
	}

	/**
	 * Gets the value of the dApplicationLogItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dApplicationLogItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDApplicationLogItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DApplicationLogItem }
	 * 
	 * 
	 */
	public List<DApplicationLogItem> getDApplicationLogItems() {
		if (dApplicationLogItems == null) {
			dApplicationLogItems = new ArrayList<DApplicationLogItem>();
		}
		return this.dApplicationLogItems;
	}

	/**
	 * Gets the value of the dConfigurationProperties property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dConfigurationProperties property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDConfigurationProperties().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DConfigurationProperty }
	 * 
	 * 
	 */
	public List<DConfigurationProperty> getDConfigurationProperties() {
		if (dConfigurationProperties == null) {
			dConfigurationProperties = new ArrayList<DConfigurationProperty>();
		}
		return this.dConfigurationProperties;
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
	 * Gets the value of the itemsChanged property.
	 * 
	 */
	public boolean isItemsChanged() {
		return itemsChanged;
	}

	/**
	 * Sets the value of the itemsChanged property.
	 * 
	 */
	public void setItemsChanged(boolean value) {
		this.itemsChanged = value;
	}

	/**
	 * Gets the value of the majorVersion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMajorVersion() {
		return majorVersion;
	}

	/**
	 * Sets the value of the majorVersion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMajorVersion(String value) {
		this.majorVersion = value;
	}

	/**
	 * Gets the value of the minorVersion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMinorVersion() {
		return minorVersion;
	}

	/**
	 * Sets the value of the minorVersion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMinorVersion(String value) {
		this.minorVersion = value;
	}

	/**
	 * Gets the value of the originator property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOriginator() {
		return originator;
	}

	/**
	 * Sets the value of the originator property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOriginator(String value) {
		this.originator = value;
	}

	/**
	 * Gets the value of the patchVersion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPatchVersion() {
		return patchVersion;
	}

	/**
	 * Sets the value of the patchVersion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPatchVersion(String value) {
		this.patchVersion = value;
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
