package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DLogItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DLogItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="logEntrySeq" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="logLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serverTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="siteNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="srcId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="srcIpAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="srcTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="srcType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xfrUpdatePid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DLogItem", propOrder = { "logEntrySeq", "logLevel",
		"logMessage", "serverTime", "siteNum", "srcId", "srcIpAddress",
		"srcTime", "srcType", "xfrUpdatePid" })
public class DLogItem extends DKeyed {

	protected long logEntrySeq;
	protected String logLevel;
	protected String logMessage;
	protected DTimestamp serverTime;
	protected int siteNum;
	protected String srcId;
	protected String srcIpAddress;
	protected DTimestamp srcTime;
	protected String srcType;
	protected int xfrUpdatePid;

	/**
	 * Gets the value of the logEntrySeq property.
	 * 
	 */
	public long getLogEntrySeq() {
		return logEntrySeq;
	}

	/**
	 * Sets the value of the logEntrySeq property.
	 * 
	 */
	public void setLogEntrySeq(long value) {
		this.logEntrySeq = value;
	}

	/**
	 * Gets the value of the logLevel property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLogLevel() {
		return logLevel;
	}

	/**
	 * Sets the value of the logLevel property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLogLevel(String value) {
		this.logLevel = value;
	}

	/**
	 * Gets the value of the logMessage property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLogMessage() {
		return logMessage;
	}

	/**
	 * Sets the value of the logMessage property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLogMessage(String value) {
		this.logMessage = value;
	}

	/**
	 * Gets the value of the serverTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getServerTime() {
		return serverTime;
	}

	/**
	 * Sets the value of the serverTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setServerTime(DTimestamp value) {
		this.serverTime = value;
	}

	/**
	 * Gets the value of the siteNum property.
	 * 
	 */
	public int getSiteNum() {
		return siteNum;
	}

	/**
	 * Sets the value of the siteNum property.
	 * 
	 */
	public void setSiteNum(int value) {
		this.siteNum = value;
	}

	/**
	 * Gets the value of the srcId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSrcId() {
		return srcId;
	}

	/**
	 * Sets the value of the srcId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSrcId(String value) {
		this.srcId = value;
	}

	/**
	 * Gets the value of the srcIpAddress property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSrcIpAddress() {
		return srcIpAddress;
	}

	/**
	 * Sets the value of the srcIpAddress property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSrcIpAddress(String value) {
		this.srcIpAddress = value;
	}

	/**
	 * Gets the value of the srcTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getSrcTime() {
		return srcTime;
	}

	/**
	 * Sets the value of the srcTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setSrcTime(DTimestamp value) {
		this.srcTime = value;
	}

	/**
	 * Gets the value of the srcType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSrcType() {
		return srcType;
	}

	/**
	 * Sets the value of the srcType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSrcType(String value) {
		this.srcType = value;
	}

	/**
	 * Gets the value of the xfrUpdatePid property.
	 * 
	 */
	public int getXfrUpdatePid() {
		return xfrUpdatePid;
	}

	/**
	 * Sets the value of the xfrUpdatePid property.
	 * 
	 */
	public void setXfrUpdatePid(int value) {
		this.xfrUpdatePid = value;
	}

}
