package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DObjectStateHistory complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DObjectStateHistory">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="entryShiftKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="entryTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="entryUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="exitShiftKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="exitTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="exitUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extendedRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FSMConfigItemKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FSMKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FSMRelationshipName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nextHistoryKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="prevHistoryKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="previousStateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="revision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STAInstance" type="{dataobjects.common.plantops.datasweep.com}DSTAInstance" minOccurs="0"/>
 *         &lt;element name="stateKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="stateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stateVisitedCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transitionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="transitionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DObjectStateHistory", propOrder = { "entryShiftKey",
		"entryTime", "entryUserName", "exitShiftKey", "exitTime",
		"exitUserName", "extendedRevision", "fsmConfigItemKey", "fsmKey",
		"fsmRelationshipName", "nextHistoryKey", "objectKey", "objectName",
		"objectType", "prevHistoryKey", "previousStateName", "revision",
		"staInstance", "stateKey", "stateName", "stateVisitedCount",
		"transitionKey", "transitionName" })
public class DObjectStateHistory extends DKeyed {

	protected long entryShiftKey;
	protected DTimestamp entryTime;
	protected String entryUserName;
	protected long exitShiftKey;
	protected DTimestamp exitTime;
	protected String exitUserName;
	protected String extendedRevision;
	@XmlElement(name = "FSMConfigItemKey")
	protected long fsmConfigItemKey;
	@XmlElement(name = "FSMKey")
	protected long fsmKey;
	@XmlElement(name = "FSMRelationshipName")
	protected String fsmRelationshipName;
	protected long nextHistoryKey;
	protected long objectKey;
	protected String objectName;
	protected short objectType;
	protected long prevHistoryKey;
	protected String previousStateName;
	protected String revision;
	@XmlElement(name = "STAInstance")
	protected DSTAInstance staInstance;
	protected long stateKey;
	protected String stateName;
	protected int stateVisitedCount;
	protected long transitionKey;
	protected String transitionName;

	/**
	 * Gets the value of the entryShiftKey property.
	 * 
	 */
	public long getEntryShiftKey() {
		return entryShiftKey;
	}

	/**
	 * Sets the value of the entryShiftKey property.
	 * 
	 */
	public void setEntryShiftKey(long value) {
		this.entryShiftKey = value;
	}

	/**
	 * Gets the value of the entryTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEntryTime() {
		return entryTime;
	}

	/**
	 * Sets the value of the entryTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEntryTime(DTimestamp value) {
		this.entryTime = value;
	}

	/**
	 * Gets the value of the entryUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEntryUserName() {
		return entryUserName;
	}

	/**
	 * Sets the value of the entryUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntryUserName(String value) {
		this.entryUserName = value;
	}

	/**
	 * Gets the value of the exitShiftKey property.
	 * 
	 */
	public long getExitShiftKey() {
		return exitShiftKey;
	}

	/**
	 * Sets the value of the exitShiftKey property.
	 * 
	 */
	public void setExitShiftKey(long value) {
		this.exitShiftKey = value;
	}

	/**
	 * Gets the value of the exitTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getExitTime() {
		return exitTime;
	}

	/**
	 * Sets the value of the exitTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setExitTime(DTimestamp value) {
		this.exitTime = value;
	}

	/**
	 * Gets the value of the exitUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExitUserName() {
		return exitUserName;
	}

	/**
	 * Sets the value of the exitUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExitUserName(String value) {
		this.exitUserName = value;
	}

	/**
	 * Gets the value of the extendedRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExtendedRevision() {
		return extendedRevision;
	}

	/**
	 * Sets the value of the extendedRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExtendedRevision(String value) {
		this.extendedRevision = value;
	}

	/**
	 * Gets the value of the fsmConfigItemKey property.
	 * 
	 */
	public long getFSMConfigItemKey() {
		return fsmConfigItemKey;
	}

	/**
	 * Sets the value of the fsmConfigItemKey property.
	 * 
	 */
	public void setFSMConfigItemKey(long value) {
		this.fsmConfigItemKey = value;
	}

	/**
	 * Gets the value of the fsmKey property.
	 * 
	 */
	public long getFSMKey() {
		return fsmKey;
	}

	/**
	 * Sets the value of the fsmKey property.
	 * 
	 */
	public void setFSMKey(long value) {
		this.fsmKey = value;
	}

	/**
	 * Gets the value of the fsmRelationshipName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFSMRelationshipName() {
		return fsmRelationshipName;
	}

	/**
	 * Sets the value of the fsmRelationshipName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFSMRelationshipName(String value) {
		this.fsmRelationshipName = value;
	}

	/**
	 * Gets the value of the nextHistoryKey property.
	 * 
	 */
	public long getNextHistoryKey() {
		return nextHistoryKey;
	}

	/**
	 * Sets the value of the nextHistoryKey property.
	 * 
	 */
	public void setNextHistoryKey(long value) {
		this.nextHistoryKey = value;
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
	 */
	public short getObjectType() {
		return objectType;
	}

	/**
	 * Sets the value of the objectType property.
	 * 
	 */
	public void setObjectType(short value) {
		this.objectType = value;
	}

	/**
	 * Gets the value of the prevHistoryKey property.
	 * 
	 */
	public long getPrevHistoryKey() {
		return prevHistoryKey;
	}

	/**
	 * Sets the value of the prevHistoryKey property.
	 * 
	 */
	public void setPrevHistoryKey(long value) {
		this.prevHistoryKey = value;
	}

	/**
	 * Gets the value of the previousStateName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPreviousStateName() {
		return previousStateName;
	}

	/**
	 * Sets the value of the previousStateName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPreviousStateName(String value) {
		this.previousStateName = value;
	}

	/**
	 * Gets the value of the revision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRevision() {
		return revision;
	}

	/**
	 * Sets the value of the revision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRevision(String value) {
		this.revision = value;
	}

	/**
	 * Gets the value of the staInstance property.
	 * 
	 * @return possible object is {@link DSTAInstance }
	 * 
	 */
	public DSTAInstance getSTAInstance() {
		return staInstance;
	}

	/**
	 * Sets the value of the staInstance property.
	 * 
	 * @param value
	 *            allowed object is {@link DSTAInstance }
	 * 
	 */
	public void setSTAInstance(DSTAInstance value) {
		this.staInstance = value;
	}

	/**
	 * Gets the value of the stateKey property.
	 * 
	 */
	public long getStateKey() {
		return stateKey;
	}

	/**
	 * Sets the value of the stateKey property.
	 * 
	 */
	public void setStateKey(long value) {
		this.stateKey = value;
	}

	/**
	 * Gets the value of the stateName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * Sets the value of the stateName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStateName(String value) {
		this.stateName = value;
	}

	/**
	 * Gets the value of the stateVisitedCount property.
	 * 
	 */
	public int getStateVisitedCount() {
		return stateVisitedCount;
	}

	/**
	 * Sets the value of the stateVisitedCount property.
	 * 
	 */
	public void setStateVisitedCount(int value) {
		this.stateVisitedCount = value;
	}

	/**
	 * Gets the value of the transitionKey property.
	 * 
	 */
	public long getTransitionKey() {
		return transitionKey;
	}

	/**
	 * Sets the value of the transitionKey property.
	 * 
	 */
	public void setTransitionKey(long value) {
		this.transitionKey = value;
	}

	/**
	 * Gets the value of the transitionName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransitionName() {
		return transitionName;
	}

	/**
	 * Sets the value of the transitionName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransitionName(String value) {
		this.transitionName = value;
	}

}
