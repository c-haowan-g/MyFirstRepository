package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DActivitySetStep complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DActivitySetStep">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="activityBlob" type="{dataobjects.common.plantops.datasweep.com}DActivitySetStepBlobData" minOccurs="0"/>
 *         &lt;element name="activityClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activitySetKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="addonKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="gridX" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="gridY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="guid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imageKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="inputMappingBlob" type="{dataobjects.common.plantops.datasweep.com}DActivitySetStepBlobData" minOccurs="0"/>
 *         &lt;element name="outputMappingBlob" type="{dataobjects.common.plantops.datasweep.com}DActivitySetStepBlobData" minOccurs="0"/>
 *         &lt;element name="savePoint" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="textID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "DActivitySetStep", propOrder = { "activityBlob",
		"activityClassName", "activitySetKey", "addonKey", "auditInfo",
		"gridX", "gridY", "guid", "imageKey", "inputMappingBlob",
		"outputMappingBlob", "savePoint", "text", "textID", "type",
		"userDefinedAttributes" })
public class DActivitySetStep extends DKeyed {

	protected DActivitySetStepBlobData activityBlob;
	protected String activityClassName;
	protected long activitySetKey;
	protected long addonKey;
	protected DAuditInfo auditInfo;
	protected int gridX;
	protected int gridY;
	protected String guid;
	protected long imageKey;
	protected DActivitySetStepBlobData inputMappingBlob;
	protected DActivitySetStepBlobData outputMappingBlob;
	protected boolean savePoint;
	protected String text;
	protected String textID;
	protected int type;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the activityBlob property.
	 * 
	 * @return possible object is {@link DActivitySetStepBlobData }
	 * 
	 */
	public DActivitySetStepBlobData getActivityBlob() {
		return activityBlob;
	}

	/**
	 * Sets the value of the activityBlob property.
	 * 
	 * @param value
	 *            allowed object is {@link DActivitySetStepBlobData }
	 * 
	 */
	public void setActivityBlob(DActivitySetStepBlobData value) {
		this.activityBlob = value;
	}

	/**
	 * Gets the value of the activityClassName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getActivityClassName() {
		return activityClassName;
	}

	/**
	 * Sets the value of the activityClassName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setActivityClassName(String value) {
		this.activityClassName = value;
	}

	/**
	 * Gets the value of the activitySetKey property.
	 * 
	 */
	public long getActivitySetKey() {
		return activitySetKey;
	}

	/**
	 * Sets the value of the activitySetKey property.
	 * 
	 */
	public void setActivitySetKey(long value) {
		this.activitySetKey = value;
	}

	/**
	 * Gets the value of the addonKey property.
	 * 
	 */
	public long getAddonKey() {
		return addonKey;
	}

	/**
	 * Sets the value of the addonKey property.
	 * 
	 */
	public void setAddonKey(long value) {
		this.addonKey = value;
	}

	/**
	 * Gets the value of the auditInfo property.
	 * 
	 * @return possible object is {@link DAuditInfo }
	 * 
	 */
	public DAuditInfo getAuditInfo() {
		return auditInfo;
	}

	/**
	 * Sets the value of the auditInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DAuditInfo }
	 * 
	 */
	public void setAuditInfo(DAuditInfo value) {
		this.auditInfo = value;
	}

	/**
	 * Gets the value of the gridX property.
	 * 
	 */
	public int getGridX() {
		return gridX;
	}

	/**
	 * Sets the value of the gridX property.
	 * 
	 */
	public void setGridX(int value) {
		this.gridX = value;
	}

	/**
	 * Gets the value of the gridY property.
	 * 
	 */
	public int getGridY() {
		return gridY;
	}

	/**
	 * Sets the value of the gridY property.
	 * 
	 */
	public void setGridY(int value) {
		this.gridY = value;
	}

	/**
	 * Gets the value of the guid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGuid() {
		return guid;
	}

	/**
	 * Sets the value of the guid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGuid(String value) {
		this.guid = value;
	}

	/**
	 * Gets the value of the imageKey property.
	 * 
	 */
	public long getImageKey() {
		return imageKey;
	}

	/**
	 * Sets the value of the imageKey property.
	 * 
	 */
	public void setImageKey(long value) {
		this.imageKey = value;
	}

	/**
	 * Gets the value of the inputMappingBlob property.
	 * 
	 * @return possible object is {@link DActivitySetStepBlobData }
	 * 
	 */
	public DActivitySetStepBlobData getInputMappingBlob() {
		return inputMappingBlob;
	}

	/**
	 * Sets the value of the inputMappingBlob property.
	 * 
	 * @param value
	 *            allowed object is {@link DActivitySetStepBlobData }
	 * 
	 */
	public void setInputMappingBlob(DActivitySetStepBlobData value) {
		this.inputMappingBlob = value;
	}

	/**
	 * Gets the value of the outputMappingBlob property.
	 * 
	 * @return possible object is {@link DActivitySetStepBlobData }
	 * 
	 */
	public DActivitySetStepBlobData getOutputMappingBlob() {
		return outputMappingBlob;
	}

	/**
	 * Sets the value of the outputMappingBlob property.
	 * 
	 * @param value
	 *            allowed object is {@link DActivitySetStepBlobData }
	 * 
	 */
	public void setOutputMappingBlob(DActivitySetStepBlobData value) {
		this.outputMappingBlob = value;
	}

	/**
	 * Gets the value of the savePoint property.
	 * 
	 */
	public boolean isSavePoint() {
		return savePoint;
	}

	/**
	 * Sets the value of the savePoint property.
	 * 
	 */
	public void setSavePoint(boolean value) {
		this.savePoint = value;
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
	 * Gets the value of the textID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTextID() {
		return textID;
	}

	/**
	 * Sets the value of the textID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTextID(String value) {
		this.textID = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 */
	public int getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 */
	public void setType(int value) {
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
