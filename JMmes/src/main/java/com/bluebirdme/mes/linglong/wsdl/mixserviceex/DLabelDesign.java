package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DLabelDesign complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DLabelDesign">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="accessControlInfo" type="{dataobjects.common.plantops.datasweep.com}DAccessControlInfo" minOccurs="0"/>
 *         &lt;element name="blobData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="labelDesignName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="labelDesignRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="locked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="logPreview" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="logPrint" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="markReprinted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="persistData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="printer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="showPreview" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="xresolution" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="yresolution" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DLabelDesign", propOrder = { "accessControlInfo", "blobData",
		"currentStates", "deletePrivilegeKey", "height", "labelDesignName",
		"labelDesignRevision", "localeKey", "locked", "logPreview", "logPrint",
		"markReprinted", "persistData", "printer", "showPreview",
		"updatePrivilegeKey", "userDefinedAttributes", "width", "xresolution",
		"yresolution" })
public class DLabelDesign extends DCategorical {

	protected DAccessControlInfo accessControlInfo;
	protected byte[] blobData;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected long deletePrivilegeKey;
	protected int height;
	protected String labelDesignName;
	protected String labelDesignRevision;
	protected long localeKey;
	protected boolean locked;
	protected boolean logPreview;
	protected boolean logPrint;
	protected boolean markReprinted;
	protected boolean persistData;
	protected String printer;
	protected boolean showPreview;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;
	protected int width;
	protected int xresolution;
	protected int yresolution;

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
	 * Gets the value of the blobData property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getBlobData() {
		return blobData;
	}

	/**
	 * Sets the value of the blobData property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setBlobData(byte[] value) {
		this.blobData = ((byte[]) value);
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
	 * Gets the value of the height property.
	 * 
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the value of the height property.
	 * 
	 */
	public void setHeight(int value) {
		this.height = value;
	}

	/**
	 * Gets the value of the labelDesignName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLabelDesignName() {
		return labelDesignName;
	}

	/**
	 * Sets the value of the labelDesignName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLabelDesignName(String value) {
		this.labelDesignName = value;
	}

	/**
	 * Gets the value of the labelDesignRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLabelDesignRevision() {
		return labelDesignRevision;
	}

	/**
	 * Sets the value of the labelDesignRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLabelDesignRevision(String value) {
		this.labelDesignRevision = value;
	}

	/**
	 * Gets the value of the localeKey property.
	 * 
	 */
	public long getLocaleKey() {
		return localeKey;
	}

	/**
	 * Sets the value of the localeKey property.
	 * 
	 */
	public void setLocaleKey(long value) {
		this.localeKey = value;
	}

	/**
	 * Gets the value of the locked property.
	 * 
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * Sets the value of the locked property.
	 * 
	 */
	public void setLocked(boolean value) {
		this.locked = value;
	}

	/**
	 * Gets the value of the logPreview property.
	 * 
	 */
	public boolean isLogPreview() {
		return logPreview;
	}

	/**
	 * Sets the value of the logPreview property.
	 * 
	 */
	public void setLogPreview(boolean value) {
		this.logPreview = value;
	}

	/**
	 * Gets the value of the logPrint property.
	 * 
	 */
	public boolean isLogPrint() {
		return logPrint;
	}

	/**
	 * Sets the value of the logPrint property.
	 * 
	 */
	public void setLogPrint(boolean value) {
		this.logPrint = value;
	}

	/**
	 * Gets the value of the markReprinted property.
	 * 
	 */
	public boolean isMarkReprinted() {
		return markReprinted;
	}

	/**
	 * Sets the value of the markReprinted property.
	 * 
	 */
	public void setMarkReprinted(boolean value) {
		this.markReprinted = value;
	}

	/**
	 * Gets the value of the persistData property.
	 * 
	 */
	public boolean isPersistData() {
		return persistData;
	}

	/**
	 * Sets the value of the persistData property.
	 * 
	 */
	public void setPersistData(boolean value) {
		this.persistData = value;
	}

	/**
	 * Gets the value of the printer property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPrinter() {
		return printer;
	}

	/**
	 * Sets the value of the printer property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPrinter(String value) {
		this.printer = value;
	}

	/**
	 * Gets the value of the showPreview property.
	 * 
	 */
	public boolean isShowPreview() {
		return showPreview;
	}

	/**
	 * Sets the value of the showPreview property.
	 * 
	 */
	public void setShowPreview(boolean value) {
		this.showPreview = value;
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

	/**
	 * Gets the value of the width property.
	 * 
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the value of the width property.
	 * 
	 */
	public void setWidth(int value) {
		this.width = value;
	}

	/**
	 * Gets the value of the xresolution property.
	 * 
	 */
	public int getXresolution() {
		return xresolution;
	}

	/**
	 * Sets the value of the xresolution property.
	 * 
	 */
	public void setXresolution(int value) {
		this.xresolution = value;
	}

	/**
	 * Gets the value of the yresolution property.
	 * 
	 */
	public int getYresolution() {
		return yresolution;
	}

	/**
	 * Sets the value of the yresolution property.
	 * 
	 */
	public void setYresolution(int value) {
		this.yresolution = value;
	}

}
