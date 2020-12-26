package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DECODelta complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DECODelta">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="originalBomItem" type="{dataobjects.common.plantops.datasweep.com}DRuntimeBomItem" minOccurs="0"/>
 *         &lt;element name="removedConsumedParts" type="{dataobjects.common.plantops.datasweep.com}DConsumedPart" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="revisedBomItem" type="{dataobjects.common.plantops.datasweep.com}DRuntimeBomItem" minOccurs="0"/>
 *         &lt;element name="revisedBomName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="revisedBomRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DECODelta", propOrder = { "originalBomItem",
		"removedConsumedParts", "revisedBomItem", "revisedBomName",
		"revisedBomRevision", "type" })
public class DECODelta extends DDataObject {

	protected DRuntimeBomItem originalBomItem;
	@XmlElement(nillable = true)
	protected List<DConsumedPart> removedConsumedParts;
	protected DRuntimeBomItem revisedBomItem;
	protected String revisedBomName;
	protected String revisedBomRevision;
	protected short type;

	/**
	 * Gets the value of the originalBomItem property.
	 * 
	 * @return possible object is {@link DRuntimeBomItem }
	 * 
	 */
	public DRuntimeBomItem getOriginalBomItem() {
		return originalBomItem;
	}

	/**
	 * Sets the value of the originalBomItem property.
	 * 
	 * @param value
	 *            allowed object is {@link DRuntimeBomItem }
	 * 
	 */
	public void setOriginalBomItem(DRuntimeBomItem value) {
		this.originalBomItem = value;
	}

	/**
	 * Gets the value of the removedConsumedParts property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the removedConsumedParts property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRemovedConsumedParts().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DConsumedPart }
	 * 
	 * 
	 */
	public List<DConsumedPart> getRemovedConsumedParts() {
		if (removedConsumedParts == null) {
			removedConsumedParts = new ArrayList<DConsumedPart>();
		}
		return this.removedConsumedParts;
	}

	/**
	 * Gets the value of the revisedBomItem property.
	 * 
	 * @return possible object is {@link DRuntimeBomItem }
	 * 
	 */
	public DRuntimeBomItem getRevisedBomItem() {
		return revisedBomItem;
	}

	/**
	 * Sets the value of the revisedBomItem property.
	 * 
	 * @param value
	 *            allowed object is {@link DRuntimeBomItem }
	 * 
	 */
	public void setRevisedBomItem(DRuntimeBomItem value) {
		this.revisedBomItem = value;
	}

	/**
	 * Gets the value of the revisedBomName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRevisedBomName() {
		return revisedBomName;
	}

	/**
	 * Sets the value of the revisedBomName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRevisedBomName(String value) {
		this.revisedBomName = value;
	}

	/**
	 * Gets the value of the revisedBomRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRevisedBomRevision() {
		return revisedBomRevision;
	}

	/**
	 * Sets the value of the revisedBomRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRevisedBomRevision(String value) {
		this.revisedBomRevision = value;
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
