package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DReportDesign complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DReportDesign">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="accessControlInfo" type="{dataobjects.common.plantops.datasweep.com}DAccessControlInfo" minOccurs="0"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="layoutInfo" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="localeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="logExport" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="logPreview" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="logPrintout" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="markAsReprint" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="pageFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pageHeight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pageWidth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reportDataDefKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="reportDesignName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportDesignRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reprintPossible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="showPreview" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DReportDesign", propOrder = { "accessControlInfo",
		"currentStates", "deletePrivilegeKey", "layoutInfo", "localeKey",
		"logExport", "logPreview", "logPrintout", "markAsReprint",
		"pageFormat", "pageHeight", "pageWidth", "reportDataDefKey",
		"reportDesignName", "reportDesignRevision", "reprintPossible",
		"showPreview", "status", "updatePrivilegeKey", "userDefinedAttributes" })
public class DReportDesign extends DCategorical {

	protected DAccessControlInfo accessControlInfo;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected long deletePrivilegeKey;
	protected byte[] layoutInfo;
	protected long localeKey;
	protected boolean logExport;
	protected boolean logPreview;
	protected boolean logPrintout;
	protected boolean markAsReprint;
	protected String pageFormat;
	protected int pageHeight;
	protected int pageWidth;
	protected long reportDataDefKey;
	protected String reportDesignName;
	protected String reportDesignRevision;
	protected boolean reprintPossible;
	protected boolean showPreview;
	protected String status;
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
	 * Gets the value of the layoutInfo property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getLayoutInfo() {
		return layoutInfo;
	}

	/**
	 * Sets the value of the layoutInfo property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setLayoutInfo(byte[] value) {
		this.layoutInfo = ((byte[]) value);
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
	 * Gets the value of the logExport property.
	 * 
	 */
	public boolean isLogExport() {
		return logExport;
	}

	/**
	 * Sets the value of the logExport property.
	 * 
	 */
	public void setLogExport(boolean value) {
		this.logExport = value;
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
	 * Gets the value of the logPrintout property.
	 * 
	 */
	public boolean isLogPrintout() {
		return logPrintout;
	}

	/**
	 * Sets the value of the logPrintout property.
	 * 
	 */
	public void setLogPrintout(boolean value) {
		this.logPrintout = value;
	}

	/**
	 * Gets the value of the markAsReprint property.
	 * 
	 */
	public boolean isMarkAsReprint() {
		return markAsReprint;
	}

	/**
	 * Sets the value of the markAsReprint property.
	 * 
	 */
	public void setMarkAsReprint(boolean value) {
		this.markAsReprint = value;
	}

	/**
	 * Gets the value of the pageFormat property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPageFormat() {
		return pageFormat;
	}

	/**
	 * Sets the value of the pageFormat property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPageFormat(String value) {
		this.pageFormat = value;
	}

	/**
	 * Gets the value of the pageHeight property.
	 * 
	 */
	public int getPageHeight() {
		return pageHeight;
	}

	/**
	 * Sets the value of the pageHeight property.
	 * 
	 */
	public void setPageHeight(int value) {
		this.pageHeight = value;
	}

	/**
	 * Gets the value of the pageWidth property.
	 * 
	 */
	public int getPageWidth() {
		return pageWidth;
	}

	/**
	 * Sets the value of the pageWidth property.
	 * 
	 */
	public void setPageWidth(int value) {
		this.pageWidth = value;
	}

	/**
	 * Gets the value of the reportDataDefKey property.
	 * 
	 */
	public long getReportDataDefKey() {
		return reportDataDefKey;
	}

	/**
	 * Sets the value of the reportDataDefKey property.
	 * 
	 */
	public void setReportDataDefKey(long value) {
		this.reportDataDefKey = value;
	}

	/**
	 * Gets the value of the reportDesignName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReportDesignName() {
		return reportDesignName;
	}

	/**
	 * Sets the value of the reportDesignName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReportDesignName(String value) {
		this.reportDesignName = value;
	}

	/**
	 * Gets the value of the reportDesignRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReportDesignRevision() {
		return reportDesignRevision;
	}

	/**
	 * Sets the value of the reportDesignRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReportDesignRevision(String value) {
		this.reportDesignRevision = value;
	}

	/**
	 * Gets the value of the reprintPossible property.
	 * 
	 */
	public boolean isReprintPossible() {
		return reprintPossible;
	}

	/**
	 * Sets the value of the reprintPossible property.
	 * 
	 */
	public void setReprintPossible(boolean value) {
		this.reprintPossible = value;
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
	 * Gets the value of the status property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStatus(String value) {
		this.status = value;
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
