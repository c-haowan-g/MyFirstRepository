package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSTADefinitionIndexColumn complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSTADefinitionIndexColumn">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="column" type="{dataobjects.common.plantops.datasweep.com}DSTADefinitionItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSTADefinitionIndexColumn", propOrder = { "column" })
public class DSTADefinitionIndexColumn extends DDataObject {

	protected DSTADefinitionItem column;

	/**
	 * Gets the value of the column property.
	 * 
	 * @return possible object is {@link DSTADefinitionItem }
	 * 
	 */
	public DSTADefinitionItem getColumn() {
		return column;
	}

	/**
	 * Sets the value of the column property.
	 * 
	 * @param value
	 *            allowed object is {@link DSTADefinitionItem }
	 * 
	 */
	public void setColumn(DSTADefinitionItem value) {
		this.column = value;
	}

}
