package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DWorkInstruction complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DWorkInstruction">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="blobData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="filePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fileType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="link" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DWorkInstruction", propOrder = { "blobData", "currentStates",
		"deletePrivilegeKey", "filePath", "fileType", "link",
		"updatePrivilegeKey", "userDefinedAttributes" })
public class DWorkInstruction extends DCategorical {

	protected byte[] blobData;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected long deletePrivilegeKey;
	protected String filePath;
	protected int fileType;
	protected boolean link;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the blobData property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getBlobData() {
		return blobData;
	}

	/**
	 * Sets the value of the blobData property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setBlobData(byte[] value) {
		this.blobData = ((byte[]) value);
	}

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
	 * Gets the value of the deletePrivilegeKey property.
	 * 
	 */
	public long getDeletePrivilegeKey() {
		return deletePrivilegeKey;
	}

	/**
	 * Sets the value of the deletePrivilegeKey property.
	 * 
	 */
	public void setDeletePrivilegeKey(long value) {
		this.deletePrivilegeKey = value;
	}

	/**
	 * Gets the value of the filePath property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * Sets the value of the filePath property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFilePath(String value) {
		this.filePath = value;
	}

	/**
	 * Gets the value of the fileType property.
	 * 
	 */
	public int getFileType() {
		return fileType;
	}

	/**
	 * Sets the value of the fileType property.
	 * 
	 */
	public void setFileType(int value) {
		this.fileType = value;
	}

	/**
	 * Gets the value of the link property.
	 * 
	 */
	public boolean isLink() {
		return link;
	}

	/**
	 * Sets the value of the link property.
	 * 
	 */
	public void setLink(boolean value) {
		this.link = value;
	}

	/**
	 * Gets the value of the updatePrivilegeKey property.
	 * 
	 */
	public long getUpdatePrivilegeKey() {
		return updatePrivilegeKey;
	}

	/**
	 * Sets the value of the updatePrivilegeKey property.
	 * 
	 */
	public void setUpdatePrivilegeKey(long value) {
		this.updatePrivilegeKey = value;
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
