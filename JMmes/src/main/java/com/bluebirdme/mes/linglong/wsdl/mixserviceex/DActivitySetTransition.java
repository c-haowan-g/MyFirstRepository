package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DActivitySetTransition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DActivitySetTransition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="condition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gridX" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="gridY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="guid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DActivitySetTransition", propOrder = { "condition", "gridX",
		"gridY", "guid", "userDefinedAttributes" })
public class DActivitySetTransition extends DKeyed {

	protected String condition;
	protected int gridX;
	protected int gridY;
	protected String guid;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the condition property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * Sets the value of the condition property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCondition(String value) {
		this.condition = value;
	}

	/**
	 * Gets the value of the gridX property.
	 * 
	 */
	public int getGridX() {
		return gridX;
	}

	/**
	 * Sets the value of the gridX property.
	 * 
	 */
	public void setGridX(int value) {
		this.gridX = value;
	}

	/**
	 * Gets the value of the gridY property.
	 * 
	 */
	public int getGridY() {
		return gridY;
	}

	/**
	 * Sets the value of the gridY property.
	 * 
	 */
	public void setGridY(int value) {
		this.gridY = value;
	}

	/**
	 * Gets the value of the guid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGuid() {
		return guid;
	}

	/**
	 * Sets the value of the guid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGuid(String value) {
		this.guid = value;
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

}
