package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTemplateBom complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTemplateBom">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DAbstractBom">
 *       &lt;sequence>
 *         &lt;element name="bomItems" type="{dataobjects.common.plantops.datasweep.com}DTemplateBomItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bomKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bomLevel" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="handleKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="imageKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="modified" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="templateExpirationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="templateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTemplateBom", propOrder = { "bomItems", "bomKey", "bomLevel",
		"handleKey", "imageKey", "modified", "templateExpirationTime",
		"templateType" })
public class DTemplateBom extends DAbstractBom {

	@XmlElement(nillable = true)
	protected List<DTemplateBomItem> bomItems;
	protected long bomKey;
	protected short bomLevel;
	protected long handleKey;
	protected long imageKey;
	protected boolean modified;
	protected DTimestamp templateExpirationTime;
	protected String templateType;

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
	 * {@link DTemplateBomItem }
	 * 
	 * 
	 */
	public List<DTemplateBomItem> getBomItems() {
		if (bomItems == null) {
			bomItems = new ArrayList<DTemplateBomItem>();
		}
		return this.bomItems;
	}

	/**
	 * Gets the value of the bomKey property.
	 * 
	 */
	public long getBomKey() {
		return bomKey;
	}

	/**
	 * Sets the value of the bomKey property.
	 * 
	 */
	public void setBomKey(long value) {
		this.bomKey = value;
	}

	/**
	 * Gets the value of the bomLevel property.
	 * 
	 */
	public short getBomLevel() {
		return bomLevel;
	}

	/**
	 * Sets the value of the bomLevel property.
	 * 
	 */
	public void setBomLevel(short value) {
		this.bomLevel = value;
	}

	/**
	 * Gets the value of the handleKey property.
	 * 
	 */
	public long getHandleKey() {
		return handleKey;
	}

	/**
	 * Sets the value of the handleKey property.
	 * 
	 */
	public void setHandleKey(long value) {
		this.handleKey = value;
	}

	/**
	 * Gets the value of the imageKey property.
	 * 
	 */
	public long getImageKey() {
		return imageKey;
	}

	/**
	 * Sets the value of the imageKey property.
	 * 
	 */
	public void setImageKey(long value) {
		this.imageKey = value;
	}

	/**
	 * Gets the value of the modified property.
	 * 
	 */
	public boolean isModified() {
		return modified;
	}

	/**
	 * Sets the value of the modified property.
	 * 
	 */
	public void setModified(boolean value) {
		this.modified = value;
	}

	/**
	 * Gets the value of the templateExpirationTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getTemplateExpirationTime() {
		return templateExpirationTime;
	}

	/**
	 * Sets the value of the templateExpirationTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setTemplateExpirationTime(DTimestamp value) {
		this.templateExpirationTime = value;
	}

	/**
	 * Gets the value of the templateType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTemplateType() {
		return templateType;
	}

	/**
	 * Sets the value of the templateType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTemplateType(String value) {
		this.templateType = value;
	}

}
