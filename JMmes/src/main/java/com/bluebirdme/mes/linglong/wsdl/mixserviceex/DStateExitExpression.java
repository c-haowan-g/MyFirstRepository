package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DStateExitExpression complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DStateExitExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="expression" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isFalseTransitionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isTrueTransitionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stateKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DStateExitExpression", propOrder = { "expression",
		"isFalseTransitionName", "isTrueTransitionName", "stateKey" })
public class DStateExitExpression extends DKeyed {

	protected String expression;
	protected String isFalseTransitionName;
	protected String isTrueTransitionName;
	protected long stateKey;

	/**
	 * Gets the value of the expression property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * Sets the value of the expression property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExpression(String value) {
		this.expression = value;
	}

	/**
	 * Gets the value of the isFalseTransitionName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIsFalseTransitionName() {
		return isFalseTransitionName;
	}

	/**
	 * Sets the value of the isFalseTransitionName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIsFalseTransitionName(String value) {
		this.isFalseTransitionName = value;
	}

	/**
	 * Gets the value of the isTrueTransitionName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIsTrueTransitionName() {
		return isTrueTransitionName;
	}

	/**
	 * Sets the value of the isTrueTransitionName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIsTrueTransitionName(String value) {
		this.isTrueTransitionName = value;
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

}
