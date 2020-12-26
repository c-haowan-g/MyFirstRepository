package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTransitionInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTransitionInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fsmConfigItemKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="fsmRelationshipName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectStateHistory" type="{dataobjects.common.plantops.datasweep.com}DObjectStateHistory" minOccurs="0"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTransitionInfo", propOrder = { "currentStates",
		"fsmConfigItemKey", "fsmRelationshipName", "objectKey",
		"objectStateHistory", "objectType" })
public class DTransitionInfo extends DDataObject {

	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected long fsmConfigItemKey;
	protected String fsmRelationshipName;
	protected long objectKey;
	protected DObjectStateHistory objectStateHistory;
	protected short objectType;

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
	 * Gets the value of the fsmConfigItemKey property.
	 * 
	 */
	public long getFsmConfigItemKey() {
		return fsmConfigItemKey;
	}

	/**
	 * Sets the value of the fsmConfigItemKey property.
	 * 
	 */
	public void setFsmConfigItemKey(long value) {
		this.fsmConfigItemKey = value;
	}

	/**
	 * Gets the value of the fsmRelationshipName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFsmRelationshipName() {
		return fsmRelationshipName;
	}

	/**
	 * Sets the value of the fsmRelationshipName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFsmRelationshipName(String value) {
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
	 * Gets the value of the objectStateHistory property.
	 * 
	 * @return possible object is {@link DObjectStateHistory }
	 * 
	 */
	public DObjectStateHistory getObjectStateHistory() {
		return objectStateHistory;
	}

	/**
	 * Sets the value of the objectStateHistory property.
	 * 
	 * @param value
	 *            allowed object is {@link DObjectStateHistory }
	 * 
	 */
	public void setObjectStateHistory(DObjectStateHistory value) {
		this.objectStateHistory = value;
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

}
