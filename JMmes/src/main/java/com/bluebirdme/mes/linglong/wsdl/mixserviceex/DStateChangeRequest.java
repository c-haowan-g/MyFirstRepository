package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DStateChangeRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DStateChangeRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="effectivityEndTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="effectivityStartTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="extendedRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="STAInstance" type="{dataobjects.common.plantops.datasweep.com}DSTAInstance" minOccurs="0"/>
 *         &lt;element name="sameNamedVersionObject" type="{dataobjects.common.plantops.datasweep.com}DVersionedObject" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="transactionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DStateChangeRequest", propOrder = { "effectivityEndTime",
		"effectivityStartTime", "extendedRevision", "key", "staInstance",
		"sameNamedVersionObject", "transactionName", "type" })
public class DStateChangeRequest extends DDataObject {

	protected DTimestamp effectivityEndTime;
	protected DTimestamp effectivityStartTime;
	protected String extendedRevision;
	protected long key;
	@XmlElement(name = "STAInstance")
	protected DSTAInstance staInstance;
	@XmlElement(nillable = true)
	protected List<DVersionedObject> sameNamedVersionObject;
	protected String transactionName;
	protected short type;

	/**
	 * Gets the value of the effectivityEndTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEffectivityEndTime() {
		return effectivityEndTime;
	}

	/**
	 * Sets the value of the effectivityEndTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEffectivityEndTime(DTimestamp value) {
		this.effectivityEndTime = value;
	}

	/**
	 * Gets the value of the effectivityStartTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEffectivityStartTime() {
		return effectivityStartTime;
	}

	/**
	 * Sets the value of the effectivityStartTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEffectivityStartTime(DTimestamp value) {
		this.effectivityStartTime = value;
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
	 * Gets the value of the key property.
	 * 
	 */
	public long getKey() {
		return key;
	}

	/**
	 * Sets the value of the key property.
	 * 
	 */
	public void setKey(long value) {
		this.key = value;
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
	 * Gets the value of the sameNamedVersionObject property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the sameNamedVersionObject property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSameNamedVersionObject().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DVersionedObject }
	 * 
	 * 
	 */
	public List<DVersionedObject> getSameNamedVersionObject() {
		if (sameNamedVersionObject == null) {
			sameNamedVersionObject = new ArrayList<DVersionedObject>();
		}
		return this.sameNamedVersionObject;
	}

	/**
	 * Gets the value of the transactionName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionName() {
		return transactionName;
	}

	/**
	 * Sets the value of the transactionName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionName(String value) {
		this.transactionName = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 */
	public short getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 */
	public void setType(short value) {
		this.type = value;
	}

}
