package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTestInstance complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTestInstance">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="collectionLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="completeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="defectRepairEntries" type="{dataobjects.common.plantops.datasweep.com}DDefectRepairEntry" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="locationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productionLineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="routeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="routeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="routeStepName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="testDefinitionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="testEndTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="testEquipmentKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="testPassed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="testResults" type="{dataobjects.common.plantops.datasweep.com}DTestResult" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="testStartTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="testValid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="trackedObjectHistoryKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
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
@XmlType(name = "DTestInstance", propOrder = { "collectionLevel", "comment",
		"completeCount", "defectRepairEntries", "locationName", "objectKey",
		"objectName", "objectType", "operationName", "passCount",
		"productionLineName", "routeKey", "routeName", "routeStepName",
		"testDefinitionKey", "testEndTime", "testEquipmentKey", "testPassed",
		"testResults", "testStartTime", "testValid", "trackedObjectHistoryKey",
		"userDefinedAttributes", "userName" })
public class DTestInstance extends DCategorical {

	protected int collectionLevel;
	protected String comment;
	protected int completeCount;
	@XmlElement(nillable = true)
	protected List<DDefectRepairEntry> defectRepairEntries;
	protected String locationName;
	protected long objectKey;
	protected String objectName;
	protected String objectType;
	protected String operationName;
	protected int passCount;
	protected String productionLineName;
	protected long routeKey;
	protected String routeName;
	protected String routeStepName;
	protected long testDefinitionKey;
	protected DTimestamp testEndTime;
	protected long testEquipmentKey;
	protected boolean testPassed;
	@XmlElement(nillable = true)
	protected List<DTestResult> testResults;
	protected DTimestamp testStartTime;
	protected boolean testValid;
	protected long trackedObjectHistoryKey;
	protected DUDAInstance userDefinedAttributes;
	protected String userName;

	/**
	 * Gets the value of the collectionLevel property.
	 * 
	 */
	public int getCollectionLevel() {
		return collectionLevel;
	}

	/**
	 * Sets the value of the collectionLevel property.
	 * 
	 */
	public void setCollectionLevel(int value) {
		this.collectionLevel = value;
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
	 * Gets the value of the defectRepairEntries property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the defectRepairEntries property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDefectRepairEntries().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DDefectRepairEntry }
	 * 
	 * 
	 */
	public List<DDefectRepairEntry> getDefectRepairEntries() {
		if (defectRepairEntries == null) {
			defectRepairEntries = new ArrayList<DDefectRepairEntry>();
		}
		return this.defectRepairEntries;
	}

	/**
	 * Gets the value of the locationName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * Sets the value of the locationName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLocationName(String value) {
		this.locationName = value;
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
	 * Gets the value of the passCount property.
	 * 
	 */
	public int getPassCount() {
		return passCount;
	}

	/**
	 * Sets the value of the passCount property.
	 * 
	 */
	public void setPassCount(int value) {
		this.passCount = value;
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
	 * Gets the value of the testDefinitionKey property.
	 * 
	 */
	public long getTestDefinitionKey() {
		return testDefinitionKey;
	}

	/**
	 * Sets the value of the testDefinitionKey property.
	 * 
	 */
	public void setTestDefinitionKey(long value) {
		this.testDefinitionKey = value;
	}

	/**
	 * Gets the value of the testEndTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getTestEndTime() {
		return testEndTime;
	}

	/**
	 * Sets the value of the testEndTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setTestEndTime(DTimestamp value) {
		this.testEndTime = value;
	}

	/**
	 * Gets the value of the testEquipmentKey property.
	 * 
	 */
	public long getTestEquipmentKey() {
		return testEquipmentKey;
	}

	/**
	 * Sets the value of the testEquipmentKey property.
	 * 
	 */
	public void setTestEquipmentKey(long value) {
		this.testEquipmentKey = value;
	}

	/**
	 * Gets the value of the testPassed property.
	 * 
	 */
	public boolean isTestPassed() {
		return testPassed;
	}

	/**
	 * Sets the value of the testPassed property.
	 * 
	 */
	public void setTestPassed(boolean value) {
		this.testPassed = value;
	}

	/**
	 * Gets the value of the testResults property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the testResults property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getTestResults().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DTestResult }
	 * 
	 * 
	 */
	public List<DTestResult> getTestResults() {
		if (testResults == null) {
			testResults = new ArrayList<DTestResult>();
		}
		return this.testResults;
	}

	/**
	 * Gets the value of the testStartTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getTestStartTime() {
		return testStartTime;
	}

	/**
	 * Sets the value of the testStartTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setTestStartTime(DTimestamp value) {
		this.testStartTime = value;
	}

	/**
	 * Gets the value of the testValid property.
	 * 
	 */
	public boolean isTestValid() {
		return testValid;
	}

	/**
	 * Sets the value of the testValid property.
	 * 
	 */
	public void setTestValid(boolean value) {
		this.testValid = value;
	}

	/**
	 * Gets the value of the trackedObjectHistoryKey property.
	 * 
	 */
	public long getTrackedObjectHistoryKey() {
		return trackedObjectHistoryKey;
	}

	/**
	 * Sets the value of the trackedObjectHistoryKey property.
	 * 
	 */
	public void setTrackedObjectHistoryKey(long value) {
		this.trackedObjectHistoryKey = value;
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
