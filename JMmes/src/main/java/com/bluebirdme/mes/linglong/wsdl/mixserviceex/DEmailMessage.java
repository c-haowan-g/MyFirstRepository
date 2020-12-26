package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DEmailMessage complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DEmailMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attachments" type="{dataobjects.common.plantops.datasweep.com}DEmailAttachment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bccAddresses" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ccAddresses" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mimeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toAddresses" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DEmailMessage", propOrder = { "attachments", "bccAddresses",
		"ccAddresses", "fromAddress", "message", "mimeType", "subject",
		"toAddresses" })
public class DEmailMessage {

	@XmlElement(nillable = true)
	protected List<DEmailAttachment> attachments;
	protected String bccAddresses;
	protected String ccAddresses;
	protected String fromAddress;
	protected String message;
	protected String mimeType;
	protected String subject;
	protected String toAddresses;

	/**
	 * Gets the value of the attachments property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the attachments property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAttachments().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DEmailAttachment }
	 * 
	 * 
	 */
	public List<DEmailAttachment> getAttachments() {
		if (attachments == null) {
			attachments = new ArrayList<DEmailAttachment>();
		}
		return this.attachments;
	}

	/**
	 * Gets the value of the bccAddresses property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBccAddresses() {
		return bccAddresses;
	}

	/**
	 * Sets the value of the bccAddresses property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBccAddresses(String value) {
		this.bccAddresses = value;
	}

	/**
	 * Gets the value of the ccAddresses property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCcAddresses() {
		return ccAddresses;
	}

	/**
	 * Sets the value of the ccAddresses property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCcAddresses(String value) {
		this.ccAddresses = value;
	}

	/**
	 * Gets the value of the fromAddress property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFromAddress() {
		return fromAddress;
	}

	/**
	 * Sets the value of the fromAddress property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFromAddress(String value) {
		this.fromAddress = value;
	}

	/**
	 * Gets the value of the message property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the value of the message property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMessage(String value) {
		this.message = value;
	}

	/**
	 * Gets the value of the mimeType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * Sets the value of the mimeType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMimeType(String value) {
		this.mimeType = value;
	}

	/**
	 * Gets the value of the subject property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the value of the subject property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSubject(String value) {
		this.subject = value;
	}

	/**
	 * Gets the value of the toAddresses property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getToAddresses() {
		return toAddresses;
	}

	/**
	 * Sets the value of the toAddresses property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setToAddresses(String value) {
		this.toAddresses = value;
	}

}
