package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DUserSessionSnapshot complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DUserSessionSnapshot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adminCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="designerCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GMTDate" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="GMTDay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GMTHour" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GMTMonth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GMTWeekday" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GMTYear" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="guestCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="operatorCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="siteId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="supervisorCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DUserSessionSnapshot", propOrder = { "adminCount",
		"creationTime", "designerCount", "gmtDate", "gmtDay", "gmtHour",
		"gmtMonth", "gmtWeekday", "gmtYear", "guestCount", "lastModifiedTime",
		"operatorCount", "organization", "processed", "siteId",
		"supervisorCount", "totalCount" })
public class DUserSessionSnapshot {

	protected int adminCount;
	protected DTimestamp creationTime;
	protected int designerCount;
	@XmlElement(name = "GMTDate")
	protected DTimestamp gmtDate;
	@XmlElement(name = "GMTDay")
	protected int gmtDay;
	@XmlElement(name = "GMTHour")
	protected int gmtHour;
	@XmlElement(name = "GMTMonth")
	protected int gmtMonth;
	@XmlElement(name = "GMTWeekday")
	protected int gmtWeekday;
	@XmlElement(name = "GMTYear")
	protected int gmtYear;
	protected int guestCount;
	protected DTimestamp lastModifiedTime;
	protected int operatorCount;
	protected String organization;
	protected boolean processed;
	protected String siteId;
	protected int supervisorCount;
	protected int totalCount;

	/**
	 * Gets the value of the adminCount property.
	 * 
	 */
	public int getAdminCount() {
		return adminCount;
	}

	/**
	 * Sets the value of the adminCount property.
	 * 
	 */
	public void setAdminCount(int value) {
		this.adminCount = value;
	}

	/**
	 * Gets the value of the creationTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getCreationTime() {
		return creationTime;
	}

	/**
	 * Sets the value of the creationTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setCreationTime(DTimestamp value) {
		this.creationTime = value;
	}

	/**
	 * Gets the value of the designerCount property.
	 * 
	 */
	public int getDesignerCount() {
		return designerCount;
	}

	/**
	 * Sets the value of the designerCount property.
	 * 
	 */
	public void setDesignerCount(int value) {
		this.designerCount = value;
	}

	/**
	 * Gets the value of the gmtDate property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getGMTDate() {
		return gmtDate;
	}

	/**
	 * Sets the value of the gmtDate property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setGMTDate(DTimestamp value) {
		this.gmtDate = value;
	}

	/**
	 * Gets the value of the gmtDay property.
	 * 
	 */
	public int getGMTDay() {
		return gmtDay;
	}

	/**
	 * Sets the value of the gmtDay property.
	 * 
	 */
	public void setGMTDay(int value) {
		this.gmtDay = value;
	}

	/**
	 * Gets the value of the gmtHour property.
	 * 
	 */
	public int getGMTHour() {
		return gmtHour;
	}

	/**
	 * Sets the value of the gmtHour property.
	 * 
	 */
	public void setGMTHour(int value) {
		this.gmtHour = value;
	}

	/**
	 * Gets the value of the gmtMonth property.
	 * 
	 */
	public int getGMTMonth() {
		return gmtMonth;
	}

	/**
	 * Sets the value of the gmtMonth property.
	 * 
	 */
	public void setGMTMonth(int value) {
		this.gmtMonth = value;
	}

	/**
	 * Gets the value of the gmtWeekday property.
	 * 
	 */
	public int getGMTWeekday() {
		return gmtWeekday;
	}

	/**
	 * Sets the value of the gmtWeekday property.
	 * 
	 */
	public void setGMTWeekday(int value) {
		this.gmtWeekday = value;
	}

	/**
	 * Gets the value of the gmtYear property.
	 * 
	 */
	public int getGMTYear() {
		return gmtYear;
	}

	/**
	 * Sets the value of the gmtYear property.
	 * 
	 */
	public void setGMTYear(int value) {
		this.gmtYear = value;
	}

	/**
	 * Gets the value of the guestCount property.
	 * 
	 */
	public int getGuestCount() {
		return guestCount;
	}

	/**
	 * Sets the value of the guestCount property.
	 * 
	 */
	public void setGuestCount(int value) {
		this.guestCount = value;
	}

	/**
	 * Gets the value of the lastModifiedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getLastModifiedTime() {
		return lastModifiedTime;
	}

	/**
	 * Sets the value of the lastModifiedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setLastModifiedTime(DTimestamp value) {
		this.lastModifiedTime = value;
	}

	/**
	 * Gets the value of the operatorCount property.
	 * 
	 */
	public int getOperatorCount() {
		return operatorCount;
	}

	/**
	 * Sets the value of the operatorCount property.
	 * 
	 */
	public void setOperatorCount(int value) {
		this.operatorCount = value;
	}

	/**
	 * Gets the value of the organization property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * Sets the value of the organization property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrganization(String value) {
		this.organization = value;
	}

	/**
	 * Gets the value of the processed property.
	 * 
	 */
	public boolean isProcessed() {
		return processed;
	}

	/**
	 * Sets the value of the processed property.
	 * 
	 */
	public void setProcessed(boolean value) {
		this.processed = value;
	}

	/**
	 * Gets the value of the siteId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSiteId() {
		return siteId;
	}

	/**
	 * Sets the value of the siteId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSiteId(String value) {
		this.siteId = value;
	}

	/**
	 * Gets the value of the supervisorCount property.
	 * 
	 */
	public int getSupervisorCount() {
		return supervisorCount;
	}

	/**
	 * Sets the value of the supervisorCount property.
	 * 
	 */
	public void setSupervisorCount(int value) {
		this.supervisorCount = value;
	}

	/**
	 * Gets the value of the totalCount property.
	 * 
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * Sets the value of the totalCount property.
	 * 
	 */
	public void setTotalCount(int value) {
		this.totalCount = value;
	}

}
