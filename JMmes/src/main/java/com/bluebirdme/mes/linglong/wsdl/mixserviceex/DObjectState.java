package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DObjectState complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DObjectState">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="entryTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="FSMConfigItemKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FSMKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FSMRelationshipName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectStateHistoryKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="stateKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="stateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DObjectState", propOrder = { "entryTime", "fsmConfigItemKey",
		"fsmKey", "fsmRelationshipName", "objectKey", "objectStateHistoryKey",
		"objectType", "stateKey", "stateName" })
public class DObjectState extends DKeyed {

	protected DTimestamp entryTime;
	@XmlElement(name = "FSMConfigItemKey")
	protected long fsmConfigItemKey;
	@XmlElement(name = "FSMKey")
	protected long fsmKey;
	@XmlElement(name = "FSMRelationshipName")
	protected String fsmRelationshipName;
	protected long objectKey;
	protected long objectStateHistoryKey;
	protected short objectType;
	protected long stateKey;
	protected String stateName;

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
	 * Gets the value of the objectStateHistoryKey property.
	 * 
	 */
	public long getObjectStateHistoryKey() {
		return objectStateHistoryKey;
	}

	/**
	 * Sets the value of the objectStateHistoryKey property.
	 * 
	 */
	public void setObjectStateHistoryKey(long value) {
		this.objectStateHistoryKey = value;
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

}
