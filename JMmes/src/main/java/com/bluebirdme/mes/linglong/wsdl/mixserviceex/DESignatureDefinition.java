package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DESignatureDefinition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DESignatureDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="commentFormat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="commentPackKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="commentRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descriptionMessageID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localMessagePack" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reasonMessageID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendEmail" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DESignatureDefinition", propOrder = { "commentFormat",
		"commentPackKey", "commentRequired", "description",
		"descriptionMessageID", "localMessagePack", "reason",
		"reasonMessageID", "sendEmail" })
public class DESignatureDefinition extends DKeyed {

	protected int commentFormat;
	protected long commentPackKey;
	protected boolean commentRequired;
	protected String description;
	protected String descriptionMessageID;
	protected long localMessagePack;
	protected String reason;
	protected String reasonMessageID;
	protected boolean sendEmail;

	/**
	 * Gets the value of the commentFormat property.
	 * 
	 */
	public int getCommentFormat() {
		return commentFormat;
	}

	/**
	 * Sets the value of the commentFormat property.
	 * 
	 */
	public void setCommentFormat(int value) {
		this.commentFormat = value;
	}

	/**
	 * Gets the value of the commentPackKey property.
	 * 
	 */
	public long getCommentPackKey() {
		return commentPackKey;
	}

	/**
	 * Sets the value of the commentPackKey property.
	 * 
	 */
	public void setCommentPackKey(long value) {
		this.commentPackKey = value;
	}

	/**
	 * Gets the value of the commentRequired property.
	 * 
	 */
	public boolean isCommentRequired() {
		return commentRequired;
	}

	/**
	 * Sets the value of the commentRequired property.
	 * 
	 */
	public void setCommentRequired(boolean value) {
		this.commentRequired = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the descriptionMessageID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescriptionMessageID() {
		return descriptionMessageID;
	}

	/**
	 * Sets the value of the descriptionMessageID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescriptionMessageID(String value) {
		this.descriptionMessageID = value;
	}

	/**
	 * Gets the value of the localMessagePack property.
	 * 
	 */
	public long getLocalMessagePack() {
		return localMessagePack;
	}

	/**
	 * Sets the value of the localMessagePack property.
	 * 
	 */
	public void setLocalMessagePack(long value) {
		this.localMessagePack = value;
	}

	/**
	 * Gets the value of the reason property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * Sets the value of the reason property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReason(String value) {
		this.reason = value;
	}

	/**
	 * Gets the value of the reasonMessageID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReasonMessageID() {
		return reasonMessageID;
	}

	/**
	 * Sets the value of the reasonMessageID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReasonMessageID(String value) {
		this.reasonMessageID = value;
	}

	/**
	 * Gets the value of the sendEmail property.
	 * 
	 */
	public boolean isSendEmail() {
		return sendEmail;
	}

	/**
	 * Sets the value of the sendEmail property.
	 * 
	 */
	public void setSendEmail(boolean value) {
		this.sendEmail = value;
	}

}
