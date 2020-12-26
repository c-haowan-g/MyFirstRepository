package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DRuntimeBom complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DRuntimeBom">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DAbstractBom">
 *       &lt;sequence>
 *         &lt;element name="bomItems" type="{dataobjects.common.plantops.datasweep.com}DRuntimeBomItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bomItemsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "DRuntimeBom", propOrder = { "bomItems", "bomItemsChanged",
		"trackedObjectKey", "trackedObjectType" })
public class DRuntimeBom extends DAbstractBom {

	@XmlElement(nillable = true)
	protected List<DRuntimeBomItem> bomItems;
	protected boolean bomItemsChanged;
	protected long trackedObjectKey;
	protected String trackedObjectType;

	/**
	 * Gets the value of the bomItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the bomItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getBomItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DRuntimeBomItem }
	 * 
	 * 
	 */
	public List<DRuntimeBomItem> getBomItems() {
		if (bomItems == null) {
			bomItems = new ArrayList<DRuntimeBomItem>();
		}
		return this.bomItems;
	}

	/**
	 * Gets the value of the bomItemsChanged property.
	 * 
	 */
	public boolean isBomItemsChanged() {
		return bomItemsChanged;
	}

	/**
	 * Sets the value of the bomItemsChanged property.
	 * 
	 */
	public void setBomItemsChanged(boolean value) {
		this.bomItemsChanged = value;
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
