package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTrackedObjectQueueHistory complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTrackedObjectQueueHistory">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="beginComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="beginQuantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="beginTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="beginUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="boxRevision" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="endComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endQuantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="endTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="endUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pauseDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productionLineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productionQueueName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="queueName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="routeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="routeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trackedObjectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="trackedObjectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTrackedObjectQueueHistory", propOrder = { "beginComment",
		"beginQuantity", "beginTime", "beginUserName", "boxRevision",
		"endComment", "endQuantity", "endTime", "endUserName", "pauseDuration",
		"productionLineName", "productionQueueName", "queueName", "routeKey",
		"routeName", "trackedObjectKey", "trackedObjectType" })
public class DTrackedObjectQueueHistory extends DKeyed {

	protected String beginComment;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal beginQuantity;
	protected DTimestamp beginTime;
	protected String beginUserName;
	protected int boxRevision;
	protected String endComment;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal endQuantity;
	protected DTimestamp endTime;
	protected String endUserName;
	protected int pauseDuration;
	protected String productionLineName;
	protected String productionQueueName;
	protected String queueName;
	protected long routeKey;
	protected String routeName;
	protected long trackedObjectKey;
	protected String trackedObjectType;

	/**
	 * Gets the value of the beginComment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBeginComment() {
		return beginComment;
	}

	/**
	 * Sets the value of the beginComment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBeginComment(String value) {
		this.beginComment = value;
	}

	/**
	 * Gets the value of the beginQuantity property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getBeginQuantity() {
		return beginQuantity;
	}

	/**
	 * Sets the value of the beginQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setBeginQuantity(BigDecimal value) {
		this.beginQuantity = value;
	}

	/**
	 * Gets the value of the beginTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getBeginTime() {
		return beginTime;
	}

	/**
	 * Sets the value of the beginTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setBeginTime(DTimestamp value) {
		this.beginTime = value;
	}

	/**
	 * Gets the value of the beginUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBeginUserName() {
		return beginUserName;
	}

	/**
	 * Sets the value of the beginUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBeginUserName(String value) {
		this.beginUserName = value;
	}

	/**
	 * Gets the value of the boxRevision property.
	 * 
	 */
	public int getBoxRevision() {
		return boxRevision;
	}

	/**
	 * Sets the value of the boxRevision property.
	 * 
	 */
	public void setBoxRevision(int value) {
		this.boxRevision = value;
	}

	/**
	 * Gets the value of the endComment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEndComment() {
		return endComment;
	}

	/**
	 * Sets the value of the endComment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEndComment(String value) {
		this.endComment = value;
	}

	/**
	 * Gets the value of the endQuantity property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getEndQuantity() {
		return endQuantity;
	}

	/**
	 * Sets the value of the endQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setEndQuantity(BigDecimal value) {
		this.endQuantity = value;
	}

	/**
	 * Gets the value of the endTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEndTime() {
		return endTime;
	}

	/**
	 * Sets the value of the endTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEndTime(DTimestamp value) {
		this.endTime = value;
	}

	/**
	 * Gets the value of the endUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEndUserName() {
		return endUserName;
	}

	/**
	 * Sets the value of the endUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEndUserName(String value) {
		this.endUserName = value;
	}

	/**
	 * Gets the value of the pauseDuration property.
	 * 
	 */
	public int getPauseDuration() {
		return pauseDuration;
	}

	/**
	 * Sets the value of the pauseDuration property.
	 * 
	 */
	public void setPauseDuration(int value) {
		this.pauseDuration = value;
	}

	/**
	 * Gets the value of the productionLineName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProductionLineName() {
		return productionLineName;
	}

	/**
	 * Sets the value of the productionLineName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProductionLineName(String value) {
		this.productionLineName = value;
	}

	/**
	 * Gets the value of the productionQueueName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProductionQueueName() {
		return productionQueueName;
	}

	/**
	 * Sets the value of the productionQueueName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProductionQueueName(String value) {
		this.productionQueueName = value;
	}

	/**
	 * Gets the value of the queueName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getQueueName() {
		return queueName;
	}

	/**
	 * Sets the value of the queueName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setQueueName(String value) {
		this.queueName = value;
	}

	/**
	 * Gets the value of the routeKey property.
	 * 
	 */
	public long getRouteKey() {
		return routeKey;
	}

	/**
	 * Sets the value of the routeKey property.
	 * 
	 */
	public void setRouteKey(long value) {
		this.routeKey = value;
	}

	/**
	 * Gets the value of the routeName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRouteName() {
		return routeName;
	}

	/**
	 * Sets the value of the routeName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRouteName(String value) {
		this.routeName = value;
	}

	/**
	 * Gets the value of the trackedObjectKey property.
	 * 
	 */
	public long getTrackedObjectKey() {
		return trackedObjectKey;
	}

	/**
	 * Sets the value of the trackedObjectKey property.
	 * 
	 */
	public void setTrackedObjectKey(long value) {
		this.trackedObjectKey = value;
	}

	/**
	 * Gets the value of the trackedObjectType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTrackedObjectType() {
		return trackedObjectType;
	}

	/**
	 * Sets the value of the trackedObjectType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTrackedObjectType(String value) {
		this.trackedObjectType = value;
	}

}
