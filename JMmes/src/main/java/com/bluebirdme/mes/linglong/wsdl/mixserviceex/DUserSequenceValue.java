package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DUserSequenceValue complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DUserSequenceValue">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="dbTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="values" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DUserSequenceValue", propOrder = { "dbTime", "tag", "values" })
public class DUserSequenceValue extends DDataObject {

	protected DTimestamp dbTime;
	protected String tag;
	@XmlElement(type = Long.class)
	protected List<Long> values;

	/**
	 * Gets the value of the dbTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getDbTime() {
		return dbTime;
	}

	/**
	 * Sets the value of the dbTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setDbTime(DTimestamp value) {
		this.dbTime = value;
	}

	/**
	 * Gets the value of the tag property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Sets the value of the tag property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTag(String value) {
		this.tag = value;
	}

	/**
	 * Gets the value of the values property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the values property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getValues().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getValues() {
		if (values == null) {
			values = new ArrayList<Long>();
		}
		return this.values;
	}

}
