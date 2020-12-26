package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DDCSInstance complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DDCSInstance">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="dataItems" type="{dataobjects.common.plantops.datasweep.com}DDCSInstanceItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dcsDefinitionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="finished" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="routeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="routeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="routeStepName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DDCSInstance", propOrder = { "auditInfo", "comment",
		"creationTime", "dataItems", "dcsDefinitionKey", "finished",
		"lastModifiedTime", "location", "objectKey", "objectName",
		"objectType", "operationName", "routeKey", "routeName",
		"routeStepName", "userName" })
public class DDCSInstance extends DKeyed {

	protected DAuditInfo auditInfo;
	protected String comment;
	protected DTimestamp creationTime;
	@XmlElement(nillable = true)
	protected List<DDCSInstanceItem> dataItems;
	protected long dcsDefinitionKey;
	protected boolean finished;
	protected DTimestamp lastModifiedTime;
	protected String location;
	protected long objectKey;
	protected String objectName;
	protected String objectType;
	protected String operationName;
	protected long routeKey;
	protected String routeName;
	protected String routeStepName;
	protected String userName;

	/**
	 * Gets the value of the auditInfo property.
	 * 
	 * @return possible object is {@link DAuditInfo }
	 * 
	 */
	public DAuditInfo getAuditInfo() {
		return auditInfo;
	}

	/**
	 * Sets the value of the auditInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DAuditInfo }
	 * 
	 */
	public void setAuditInfo(DAuditInfo value) {
		this.auditInfo = value;
	}

	/**
	 * Gets the value of the comment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the value of the comment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setComment(String value) {
		this.comment = value;
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
	 * Gets the value of the dataItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dataItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDataItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DDCSInstanceItem }
	 * 
	 * 
	 */
	public List<DDCSInstanceItem> getDataItems() {
		if (dataItems == null) {
			dataItems = new ArrayList<DDCSInstanceItem>();
		}
		return this.dataItems;
	}

	/**
	 * Gets the value of the dcsDefinitionKey property.
	 * 
	 */
	public long getDcsDefinitionKey() {
		return dcsDefinitionKey;
	}

	/**
	 * Sets the value of the dcsDefinitionKey property.
	 * 
	 */
	public void setDcsDefinitionKey(long value) {
		this.dcsDefinitionKey = value;
	}

	/**
	 * Gets the value of the finished property.
	 * 
	 */
	public boolean isFinished() {
		return finished;
	}

	/**
	 * Sets the value of the finished property.
	 * 
	 */
	public void setFinished(boolean value) {
		this.finished = value;
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
	 * Gets the value of the location property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the value of the location property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLocation(String value) {
		this.location = value;
	}

	/**
	 * Gets the value of the objectKey property.
	 * 
	 */
	public long getObjectKey() {
		return objectKey;
	}

	/**
	 * Sets the value of the objectKey property.
	 * 
	 */
	public void setObjectKey(long value) {
		this.objectKey = value;
	}

	/**
	 * Gets the value of the objectName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getObjectName() {
		return objectName;
	}

	/**
	 * Sets the value of the objectName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setObjectName(String value) {
		this.objectName = value;
	}

	/**
	 * Gets the value of the objectType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getObjectType() {
		return objectType;
	}

	/**
	 * Sets the value of the objectType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setObjectType(String value) {
		this.objectType = value;
	}

	/**
	 * Gets the value of the operationName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOperationName() {
		return operationName;
	}

	/**
	 * Sets the value of the operationName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOperationName(String value) {
		this.operationName = value;
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
	 * Gets the value of the routeStepName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRouteStepName() {
		return routeStepName;
	}

	/**
	 * Sets the value of the routeStepName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRouteStepName(String value) {
		this.routeStepName = value;
	}

	/**
	 * Gets the value of the userName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the value of the userName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUserName(String value) {
		this.userName = value;
	}

}
