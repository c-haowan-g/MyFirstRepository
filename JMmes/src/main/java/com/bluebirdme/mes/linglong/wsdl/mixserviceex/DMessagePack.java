package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DMessagePack complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DMessagePack">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="localePacks" type="{dataobjects.common.plantops.datasweep.com}DLocalePack" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="messageIds" type="{dataobjects.common.plantops.datasweep.com}DMessageID" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="systemDefined" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DMessagePack", propOrder = { "deletePrivilegeKey",
		"localePacks", "messageIds", "systemDefined", "updatePrivilegeKey" })
public class DMessagePack extends DCategorical {

	protected long deletePrivilegeKey;
	@XmlElement(nillable = true)
	protected List<DLocalePack> localePacks;
	@XmlElement(nillable = true)
	protected List<DMessageID> messageIds;
	protected boolean systemDefined;
	protected long updatePrivilegeKey;

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
	 * Gets the value of the localePacks property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the localePacks property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getLocalePacks().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DLocalePack }
	 * 
	 * 
	 */
	public List<DLocalePack> getLocalePacks() {
		if (localePacks == null) {
			localePacks = new ArrayList<DLocalePack>();
		}
		return this.localePacks;
	}

	/**
	 * Gets the value of the messageIds property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the messageIds property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getMessageIds().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DMessageID }
	 * 
	 * 
	 */
	public List<DMessageID> getMessageIds() {
		if (messageIds == null) {
			messageIds = new ArrayList<DMessageID>();
		}
		return this.messageIds;
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

}
