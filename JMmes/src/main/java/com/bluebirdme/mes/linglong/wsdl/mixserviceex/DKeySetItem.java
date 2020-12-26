package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DKeySetItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DKeySetItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="keySetItemArrays" type="{dataobjects.common.plantops.datasweep.com}DKeySetItemArray" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="objectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DKeySetItem", propOrder = { "keySetItemArrays", "objectKey" })
public class DKeySetItem extends DDataObject {

	@XmlElement(nillable = true)
	protected List<DKeySetItemArray> keySetItemArrays;
	protected long objectKey;

	/**
	 * Gets the value of the keySetItemArrays property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the keySetItemArrays property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getKeySetItemArrays().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DKeySetItemArray }
	 * 
	 * 
	 */
	public List<DKeySetItemArray> getKeySetItemArrays() {
		if (keySetItemArrays == null) {
			keySetItemArrays = new ArrayList<DKeySetItemArray>();
		}
		return this.keySetItemArrays;
	}

	/**
	 * Gets the value of the objectKey property.
	 * 
	 */
	public long getObjectKey() {
		return objectKey;
	}

	/**
	 * Sets the value of the objectKey property.
	 * 
	 */
	public void setObjectKey(long value) {
		this.objectKey = value;
	}

}
