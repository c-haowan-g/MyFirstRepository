package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DVersioningViolation complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DVersioningViolation">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="relationShipId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="violationDetails" type="{dataobjects.common.plantops.datasweep.com}DViolationDetail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="violationingVersionedObject" type="{dataobjects.common.plantops.datasweep.com}DVersionedObject" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVersioningViolation", propOrder = { "relationShipId",
		"violationDetails", "violationingVersionedObject" })
public class DVersioningViolation extends DKeyed {

	protected long relationShipId;
	@XmlElement(nillable = true)
	protected List<DViolationDetail> violationDetails;
	protected DVersionedObject violationingVersionedObject;

	/**
	 * Gets the value of the relationShipId property.
	 * 
	 */
	public long getRelationShipId() {
		return relationShipId;
	}

	/**
	 * Sets the value of the relationShipId property.
	 * 
	 */
	public void setRelationShipId(long value) {
		this.relationShipId = value;
	}

	/**
	 * Gets the value of the violationDetails property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the violationDetails property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getViolationDetails().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DViolationDetail }
	 * 
	 * 
	 */
	public List<DViolationDetail> getViolationDetails() {
		if (violationDetails == null) {
			violationDetails = new ArrayList<DViolationDetail>();
		}
		return this.violationDetails;
	}

	/**
	 * Gets the value of the violationingVersionedObject property.
	 * 
	 * @return possible object is {@link DVersionedObject }
	 * 
	 */
	public DVersionedObject getViolationingVersionedObject() {
		return violationingVersionedObject;
	}

	/**
	 * Sets the value of the violationingVersionedObject property.
	 * 
	 * @param value
	 *            allowed object is {@link DVersionedObject }
	 * 
	 */
	public void setViolationingVersionedObject(DVersionedObject value) {
		this.violationingVersionedObject = value;
	}

}
