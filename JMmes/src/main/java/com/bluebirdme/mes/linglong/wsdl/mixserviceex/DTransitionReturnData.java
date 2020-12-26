package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTransitionReturnData complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTransitionReturnData">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="printlnOutput" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transitionInfoItems" type="{dataobjects.common.plantops.datasweep.com}DTransitionInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTransitionReturnData", propOrder = { "printlnOutput",
		"transitionInfoItems" })
public class DTransitionReturnData extends DDataObject {

	protected String printlnOutput;
	@XmlElement(nillable = true)
	protected List<DTransitionInfo> transitionInfoItems;

	/**
	 * Gets the value of the printlnOutput property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPrintlnOutput() {
		return printlnOutput;
	}

	/**
	 * Sets the value of the printlnOutput property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPrintlnOutput(String value) {
		this.printlnOutput = value;
	}

	/**
	 * Gets the value of the transitionInfoItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the transitionInfoItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getTransitionInfoItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DTransitionInfo }
	 * 
	 * 
	 */
	public List<DTransitionInfo> getTransitionInfoItems() {
		if (transitionInfoItems == null) {
			transitionInfoItems = new ArrayList<DTransitionInfo>();
		}
		return this.transitionInfoItems;
	}

}
