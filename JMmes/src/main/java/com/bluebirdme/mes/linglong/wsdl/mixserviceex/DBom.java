package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DBom complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DBom">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DAbstractBom">
 *       &lt;sequence>
 *         &lt;element name="bomItems" type="{dataobjects.common.plantops.datasweep.com}DBomItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bomItemsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DBom", propOrder = { "bomItems", "bomItemsChanged" })
public class DBom extends DAbstractBom {

	@XmlElement(nillable = true)
	protected List<DBomItem> bomItems;
	protected boolean bomItemsChanged;

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
	 * Objects of the following type(s) are allowed in the list {@link DBomItem }
	 * 
	 * 
	 */
	public List<DBomItem> getBomItems() {
		if (bomItems == null) {
			bomItems = new ArrayList<DBomItem>();
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

}
