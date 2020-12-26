package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DResourceObjectHistory complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DResourceObjectHistory">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="completeComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="completeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="completePauseDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="completeReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="completeTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="completeUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="queueTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="resourceConditionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resourceRouteName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resourceStepName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="robjKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="robjType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startPauseDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="startTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="startUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DResourceObjectHistory", propOrder = { "completeComment",
		"completeCount", "completePauseDuration", "completeReason",
		"completeTime", "completeUserName", "queueTime",
		"resourceConditionName", "resourceRouteName", "resourceStepName",
		"robjKey", "robjType", "startComment", "startPauseDuration",
		"startTime", "startUserName" })
public class DResourceObjectHistory extends DKeyed {

	protected String completeComment;
	protected int completeCount;
	protected int completePauseDuration;
	protected String completeReason;
	protected DTimestamp completeTime;
	protected String completeUserName;
	protected DTimestamp queueTime;
	protected String resourceConditionName;
	protected String resourceRouteName;
	protected String resourceStepName;
	protected long robjKey;
	protected String robjType;
	protected String startComment;
	protected int startPauseDuration;
	protected DTimestamp startTime;
	protected String startUserName;

	/**
	 * Gets the value of the completeComment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCompleteComment() {
		return completeComment;
	}

	/**
	 * Sets the value of the completeComment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCompleteComment(String value) {
		this.completeComment = value;
	}

	/**
	 * Gets the value of the completeCount property.
	 * 
	 */
	public int getCompleteCount() {
		return completeCount;
	}

	/**
	 * Sets the value of the completeCount property.
	 * 
	 */
	public void setCompleteCount(int value) {
		this.completeCount = value;
	}

	/**
	 * Gets the value of the completePauseDuration property.
	 * 
	 */
	public int getCompletePauseDuration() {
		return completePauseDuration;
	}

	/**
	 * Sets the value of the completePauseDuration property.
	 * 
	 */
	public void setCompletePauseDuration(int value) {
		this.completePauseDuration = value;
	}

	/**
	 * Gets the value of the completeReason property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCompleteReason() {
		return completeReason;
	}

	/**
	 * Sets the value of the completeReason property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCompleteReason(String value) {
		this.completeReason = value;
	}

	/**
	 * Gets the value of the completeTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getCompleteTime() {
		return completeTime;
	}

	/**
	 * Sets the value of the completeTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setCompleteTime(DTimestamp value) {
		this.completeTime = value;
	}

	/**
	 * Gets the value of the completeUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCompleteUserName() {
		return completeUserName;
	}

	/**
	 * Sets the value of the completeUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCompleteUserName(String value) {
		this.completeUserName = value;
	}

	/**
	 * Gets the value of the queueTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getQueueTime() {
		return queueTime;
	}

	/**
	 * Sets the value of the queueTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setQueueTime(DTimestamp value) {
		this.queueTime = value;
	}

	/**
	 * Gets the value of the resourceConditionName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getResourceConditionName() {
		return resourceConditionName;
	}

	/**
	 * Sets the value of the resourceConditionName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setResourceConditionName(String value) {
		this.resourceConditionName = value;
	}

	/**
	 * Gets the value of the resourceRouteName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getResourceRouteName() {
		return resourceRouteName;
	}

	/**
	 * Sets the value of the resourceRouteName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setResourceRouteName(String value) {
		this.resourceRouteName = value;
	}

	/**
	 * Gets the value of the resourceStepName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getResourceStepName() {
		return resourceStepName;
	}

	/**
	 * Sets the value of the resourceStepName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setResourceStepName(String value) {
		this.resourceStepName = value;
	}

	/**
	 * Gets the value of the robjKey property.
	 * 
	 */
	public long getRobjKey() {
		return robjKey;
	}

	/**
	 * Sets the value of the robjKey property.
	 * 
	 */
	public void setRobjKey(long value) {
		this.robjKey = value;
	}

	/**
	 * Gets the value of the robjType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRobjType() {
		return robjType;
	}

	/**
	 * Sets the value of the robjType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRobjType(String value) {
		this.robjType = value;
	}

	/**
	 * Gets the value of the startComment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStartComment() {
		return startComment;
	}

	/**
	 * Sets the value of the startComment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStartComment(String value) {
		this.startComment = value;
	}

	/**
	 * Gets the value of the startPauseDuration property.
	 * 
	 */
	public int getStartPauseDuration() {
		return startPauseDuration;
	}

	/**
	 * Sets the value of the startPauseDuration property.
	 * 
	 */
	public void setStartPauseDuration(int value) {
		this.startPauseDuration = value;
	}

	/**
	 * Gets the value of the startTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getStartTime() {
		return startTime;
	}

	/**
	 * Sets the value of the startTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setStartTime(DTimestamp value) {
		this.startTime = value;
	}

	/**
	 * Gets the value of the startUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStartUserName() {
		return startUserName;
	}

	/**
	 * Sets the value of the startUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStartUserName(String value) {
		this.startUserName = value;
	}

}
