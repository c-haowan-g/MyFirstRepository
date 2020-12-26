package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DPerformerESigDefinition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DPerformerESigDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DESignatureDefinition">
 *       &lt;sequence>
 *         &lt;element name="twoTocken" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DPerformerESigDefinition", propOrder = { "twoTocken" })
public class DPerformerESigDefinition extends DESignatureDefinition {

	protected boolean twoTocken;

	/**
	 * Gets the value of the twoTocken property.
	 * 
	 */
	public boolean isTwoTocken() {
		return twoTocken;
	}

	/**
	 * Sets the value of the twoTocken property.
	 * 
	 */
	public void setTwoTocken(boolean value) {
		this.twoTocken = value;
	}

}
