package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DPort complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DPort">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="edgeAssociation" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="inComingConnections" type="{dataobjects.common.plantops.datasweep.com}DConnection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="outGoingConnections" type="{dataobjects.common.plantops.datasweep.com}DConnection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ownerKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ownerType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="productionQueueKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
@XmlType(name = "DPort", propOrder = { "currentStates", "edgeAssociation",
		"enabled", "inComingConnections", "outGoingConnections", "ownerKey",
		"ownerType", "productionQueueKey", "text", "type",
		"userDefinedAttributes" })
public class DPort extends DCategorical {

	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected short edgeAssociation;
	protected boolean enabled;
	@XmlElement(nillable = true)
	protected List<DConnection> inComingConnections;
	@XmlElement(nillable = true)
	protected List<DConnection> outGoingConnections;
	protected long ownerKey;
	protected short ownerType;
	protected long productionQueueKey;
	protected String text;
	protected short type;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the currentStates property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the currentStates property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCurrentStates().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DObjectState }
	 * 
	 * 
	 */
	public List<DObjectState> getCurrentStates() {
		if (currentStates == null) {
			currentStates = new ArrayList<DObjectState>();
		}
		return this.currentStates;
	}

	/**
	 * Gets the value of the edgeAssociation property.
	 * 
	 */
	public short getEdgeAssociation() {
		return edgeAssociation;
	}

	/**
	 * Sets the value of the edgeAssociation property.
	 * 
	 */
	public void setEdgeAssociation(short value) {
		this.edgeAssociation = value;
	}

	/**
	 * Gets the value of the enabled property.
	 * 
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Sets the value of the enabled property.
	 * 
	 */
	public void setEnabled(boolean value) {
		this.enabled = value;
	}

	/**
	 * Gets the value of the inComingConnections property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the inComingConnections property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getInComingConnections().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DConnection }
	 * 
	 * 
	 */
	public List<DConnection> getInComingConnections() {
		if (inComingConnections == null) {
			inComingConnections = new ArrayList<DConnection>();
		}
		return this.inComingConnections;
	}

	/**
	 * Gets the value of the outGoingConnections property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the outGoingConnections property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getOutGoingConnections().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DConnection }
	 * 
	 * 
	 */
	public List<DConnection> getOutGoingConnections() {
		if (outGoingConnections == null) {
			outGoingConnections = new ArrayList<DConnection>();
		}
		return this.outGoingConnections;
	}

	/**
	 * Gets the value of the ownerKey property.
	 * 
	 */
	public long getOwnerKey() {
		return ownerKey;
	}

	/**
	 * Sets the value of the ownerKey property.
	 * 
	 */
	public void setOwnerKey(long value) {
		this.ownerKey = value;
	}

	/**
	 * Gets the value of the ownerType property.
	 * 
	 */
	public short getOwnerType() {
		return ownerType;
	}

	/**
	 * Sets the value of the ownerType property.
	 * 
	 */
	public void setOwnerType(short value) {
		this.ownerType = value;
	}

	/**
	 * Gets the value of the productionQueueKey property.
	 * 
	 */
	public long getProductionQueueKey() {
		return productionQueueKey;
	}

	/**
	 * Sets the value of the productionQueueKey property.
	 * 
	 */
	public void setProductionQueueKey(long value) {
		this.productionQueueKey = value;
	}

	/**
	 * Gets the value of the text property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the value of the text property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setText(String value) {
		this.text = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 */
	public short getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 */
	public void setType(short value) {
		this.type = value;
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
