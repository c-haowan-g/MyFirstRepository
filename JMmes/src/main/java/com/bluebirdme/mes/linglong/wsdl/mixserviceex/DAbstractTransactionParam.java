package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAbstractTransactionParam complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAbstractTransactionParam">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trxInfo" type="{dataobjects.common.plantops.datasweep.com}DTrxInfo" minOccurs="0"/>
 *         &lt;element name="trxTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="xferType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DAbstractTransactionParam", propOrder = { "comment",
		"trxInfo", "trxTime", "xferType" })
public class DAbstractTransactionParam {

	protected String comment;
	protected DTrxInfo trxInfo;
	protected DTimestamp trxTime;
	protected short xferType;

	/**
	 * Gets the value of the comment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the value of the comment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setComment(String value) {
		this.comment = value;
	}

	/**
	 * Gets the value of the trxInfo property.
	 * 
	 * @return possible object is {@link DTrxInfo }
	 * 
	 */
	public DTrxInfo getTrxInfo() {
		return trxInfo;
	}

	/**
	 * Sets the value of the trxInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DTrxInfo }
	 * 
	 */
	public void setTrxInfo(DTrxInfo value) {
		this.trxInfo = value;
	}

	/**
	 * Gets the value of the trxTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getTrxTime() {
		return trxTime;
	}

	/**
	 * Sets the value of the trxTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setTrxTime(DTimestamp value) {
		this.trxTime = value;
	}

	/**
	 * Gets the value of the xferType property.
	 * 
	 */
	public short getXferType() {
		return xferType;
	}

	/**
	 * Sets the value of the xferType property.
	 * 
	 */
	public void setXferType(short value) {
		this.xferType = value;
	}

}
