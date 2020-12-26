package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DPath complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DPath">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="connectables" type="{dataobjects.common.plantops.datasweep.com}DConnectable" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="connections" type="{dataobjects.common.plantops.datasweep.com}DConnection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pathSegments" type="{dataobjects.common.plantops.datasweep.com}DPathSegment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ports" type="{dataobjects.common.plantops.datasweep.com}DPort" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DPath", propOrder = { "connectables", "connections",
		"pathSegments", "ports" })
public class DPath extends DDataObject {

	@XmlElement(nillable = true)
	protected List<DConnectable> connectables;
	@XmlElement(nillable = true)
	protected List<DConnection> connections;
	@XmlElement(nillable = true)
	protected List<DPathSegment> pathSegments;
	@XmlElement(nillable = true)
	protected List<DPort> ports;

	/**
	 * Gets the value of the connectables property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the connectables property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getConnectables().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DConnectable }
	 * 
	 * 
	 */
	public List<DConnectable> getConnectables() {
		if (connectables == null) {
			connectables = new ArrayList<DConnectable>();
		}
		return this.connectables;
	}

	/**
	 * Gets the value of the connections property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the connections property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getConnections().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DConnection }
	 * 
	 * 
	 */
	public List<DConnection> getConnections() {
		if (connections == null) {
			connections = new ArrayList<DConnection>();
		}
		return this.connections;
	}

	/**
	 * Gets the value of the pathSegments property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the pathSegments property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPathSegments().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DPathSegment }
	 * 
	 * 
	 */
	public List<DPathSegment> getPathSegments() {
		if (pathSegments == null) {
			pathSegments = new ArrayList<DPathSegment>();
		}
		return this.pathSegments;
	}

	/**
	 * Gets the value of the ports property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the ports property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPorts().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DPort }
	 * 
	 * 
	 */
	public List<DPort> getPorts() {
		if (ports == null) {
			ports = new ArrayList<DPort>();
		}
		return this.ports;
	}

}
