package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DDataSet complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DDataSet">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="dataRows" type="{dataobjects.common.plantops.datasweep.com}DRow" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="metaData" type="{dataobjects.common.plantops.datasweep.com}DAttributeInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DDataSet", propOrder = { "dataRows", "metaData" })
public class DDataSet extends DDataObject {

	@XmlElement(nillable = true)
	protected List<DRow> dataRows;
	@XmlElement(nillable = true)
	protected List<DAttributeInfo> metaData;

	/**
	 * Gets the value of the dataRows property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dataRows property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDataRows().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DRow }
	 * 
	 * 
	 */
	public List<DRow> getDataRows() {
		if (dataRows == null) {
			dataRows = new ArrayList<DRow>();
		}
		return this.dataRows;
	}

	/**
	 * Gets the value of the metaData property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the metaData property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getMetaData().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DAttributeInfo }
	 * 
	 * 
	 */
	public List<DAttributeInfo> getMetaData() {
		if (metaData == null) {
			metaData = new ArrayList<DAttributeInfo>();
		}
		return this.metaData;
	}

}
