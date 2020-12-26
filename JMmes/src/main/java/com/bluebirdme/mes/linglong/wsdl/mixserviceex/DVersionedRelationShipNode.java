package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DVersionedRelationShipNode complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DVersionedRelationShipNode">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="nodes" type="{dataobjects.common.plantops.datasweep.com}DVersionedObject" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="relationShipKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="relationShipName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVersionedRelationShipNode", propOrder = { "nodes",
		"relationShipKey", "relationShipName" })
public class DVersionedRelationShipNode extends DDataObject {

	@XmlElement(nillable = true)
	protected List<DVersionedObject> nodes;
	protected long relationShipKey;
	protected String relationShipName;

	/**
	 * Gets the value of the nodes property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the nodes property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getNodes().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DVersionedObject }
	 * 
	 * 
	 */
	public List<DVersionedObject> getNodes() {
		if (nodes == null) {
			nodes = new ArrayList<DVersionedObject>();
		}
		return this.nodes;
	}

	/**
	 * Gets the value of the relationShipKey property.
	 * 
	 */
	public long getRelationShipKey() {
		return relationShipKey;
	}

	/**
	 * Sets the value of the relationShipKey property.
	 * 
	 */
	public void setRelationShipKey(long value) {
		this.relationShipKey = value;
	}

	/**
	 * Gets the value of the relationShipName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRelationShipName() {
		return relationShipName;
	}

	/**
	 * Sets the value of the relationShipName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRelationShipName(String value) {
		this.relationShipName = value;
	}

}
