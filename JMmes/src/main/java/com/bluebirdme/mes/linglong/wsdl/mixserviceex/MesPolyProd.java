package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for MesPolyProd complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="MesPolyProd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOT_NO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CARRIER_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RFID_ISOK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RFID_ETYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RFID_REMARK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EQUIP_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EQUIP_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MATERIAL_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MATERIAL_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATE_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BASEUNIT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WAREHOUSEID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STORE_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STORE_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TRAY_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MATCHINGCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SHELVES_NUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SET_BEGIN_TRAIN_NUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SET_END_TRAIN_NUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BEGIN_TRAIN_NUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="END_TRAIN_NUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SET_WEIGHT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REAL_WEIGHT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SHIFT_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GROUP_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_NO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RECIPE_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RECIPE_BOM_VERSION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CUT_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROD_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROD_LOCATION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRINT_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IS_CHECK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IS_SELFCHECK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRODUCT_TIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EXPIRY_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QC_MARK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="METAL_NUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MASTER_BY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MASTER_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SPLICE_BY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SPLICE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IS_BINDTRAIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SPARE1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SPARE2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SPARE3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SPARE4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SPARE5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="S_FACTORY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AGENC_NO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED_TIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHANGED_BY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHANGED_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHANGED_TIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ARCH_FLAG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RECORD_FLAG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MesPolyProd", namespace = "http://tempuri.org/", propOrder = {
		"id", "lotno", "carriercode", "rfidisok", "rfidetype", "rfidremark",
		"equipcode", "equipname", "materialcode", "materialname", "statecode",
		"baseunit", "warehouseid", "storetype", "storecode", "traycode",
		"matchingcode", "shelvesnum", "setbegintrainnum", "setendtrainnum",
		"begintrainnum", "endtrainnum", "setweight", "realweight", "shiftcode",
		"groupcode", "wono", "recipecode", "recipebomversion", "cuttype",
		"prodtype", "prodlocation", "printtype", "ischeck", "isselfcheck",
		"producttime", "expirydate", "qcmark", "metalnum", "masterby",
		"mastername", "spliceby", "splicename", "isbindtrain", "spare1",
		"spare2", "spare3", "spare4", "spare5", "sfactory", "agencno",
		"createdby", "createdname", "createdtime", "changedby", "changedname",
		"changedtime", "archflag", "recordflag" })
public class MesPolyProd {

	@XmlElement(name = "ID", namespace = "http://tempuri.org/")
	protected String id;
	@XmlElement(name = "LOT_NO", namespace = "http://tempuri.org/")
	protected String lotno;
	@XmlElement(name = "CARRIER_CODE", namespace = "http://tempuri.org/")
	protected String carriercode;
	@XmlElement(name = "RFID_ISOK", namespace = "http://tempuri.org/")
	protected String rfidisok;
	@XmlElement(name = "RFID_ETYPE", namespace = "http://tempuri.org/")
	protected String rfidetype;
	@XmlElement(name = "RFID_REMARK", namespace = "http://tempuri.org/")
	protected String rfidremark;
	@XmlElement(name = "EQUIP_CODE", namespace = "http://tempuri.org/")
	protected String equipcode;
	@XmlElement(name = "EQUIP_NAME", namespace = "http://tempuri.org/")
	protected String equipname;
	@XmlElement(name = "MATERIAL_CODE", namespace = "http://tempuri.org/")
	protected String materialcode;
	@XmlElement(name = "MATERIAL_NAME", namespace = "http://tempuri.org/")
	protected String materialname;
	@XmlElement(name = "STATE_CODE", namespace = "http://tempuri.org/")
	protected String statecode;
	@XmlElement(name = "BASEUNIT", namespace = "http://tempuri.org/")
	protected String baseunit;
	@XmlElement(name = "WAREHOUSEID", namespace = "http://tempuri.org/")
	protected String warehouseid;
	@XmlElement(name = "STORE_TYPE", namespace = "http://tempuri.org/")
	protected String storetype;
	@XmlElement(name = "STORE_CODE", namespace = "http://tempuri.org/")
	protected String storecode;
	@XmlElement(name = "TRAY_CODE", namespace = "http://tempuri.org/")
	protected String traycode;
	@XmlElement(name = "MATCHINGCODE", namespace = "http://tempuri.org/")
	protected String matchingcode;
	@XmlElement(name = "SHELVES_NUM", namespace = "http://tempuri.org/")
	protected String shelvesnum;
	@XmlElement(name = "SET_BEGIN_TRAIN_NUM", namespace = "http://tempuri.org/")
	protected String setbegintrainnum;
	@XmlElement(name = "SET_END_TRAIN_NUM", namespace = "http://tempuri.org/")
	protected String setendtrainnum;
	@XmlElement(name = "BEGIN_TRAIN_NUM", namespace = "http://tempuri.org/")
	protected String begintrainnum;
	@XmlElement(name = "END_TRAIN_NUM", namespace = "http://tempuri.org/")
	protected String endtrainnum;
	@XmlElement(name = "SET_WEIGHT", namespace = "http://tempuri.org/")
	protected String setweight;
	@XmlElement(name = "REAL_WEIGHT", namespace = "http://tempuri.org/")
	protected String realweight;
	@XmlElement(name = "SHIFT_CODE", namespace = "http://tempuri.org/")
	protected String shiftcode;
	@XmlElement(name = "GROUP_CODE", namespace = "http://tempuri.org/")
	protected String groupcode;
	@XmlElement(name = "WO_NO", namespace = "http://tempuri.org/")
	protected String wono;
	@XmlElement(name = "RECIPE_CODE", namespace = "http://tempuri.org/")
	protected String recipecode;
	@XmlElement(name = "RECIPE_BOM_VERSION", namespace = "http://tempuri.org/")
	protected String recipebomversion;
	@XmlElement(name = "CUT_TYPE", namespace = "http://tempuri.org/")
	protected String cuttype;
	@XmlElement(name = "PROD_TYPE", namespace = "http://tempuri.org/")
	protected String prodtype;
	@XmlElement(name = "PROD_LOCATION", namespace = "http://tempuri.org/")
	protected String prodlocation;
	@XmlElement(name = "PRINT_TYPE", namespace = "http://tempuri.org/")
	protected String printtype;
	@XmlElement(name = "IS_CHECK", namespace = "http://tempuri.org/")
	protected String ischeck;
	@XmlElement(name = "IS_SELFCHECK", namespace = "http://tempuri.org/")
	protected String isselfcheck;
	@XmlElement(name = "PRODUCT_TIME", namespace = "http://tempuri.org/")
	protected String producttime;
	@XmlElement(name = "EXPIRY_DATE", namespace = "http://tempuri.org/")
	protected String expirydate;
	@XmlElement(name = "QC_MARK", namespace = "http://tempuri.org/")
	protected String qcmark;
	@XmlElement(name = "METAL_NUM", namespace = "http://tempuri.org/")
	protected String metalnum;
	@XmlElement(name = "MASTER_BY", namespace = "http://tempuri.org/")
	protected String masterby;
	@XmlElement(name = "MASTER_NAME", namespace = "http://tempuri.org/")
	protected String mastername;
	@XmlElement(name = "SPLICE_BY", namespace = "http://tempuri.org/")
	protected String spliceby;
	@XmlElement(name = "SPLICE_NAME", namespace = "http://tempuri.org/")
	protected String splicename;
	@XmlElement(name = "IS_BINDTRAIN", namespace = "http://tempuri.org/")
	protected String isbindtrain;
	@XmlElement(name = "SPARE1", namespace = "http://tempuri.org/")
	protected String spare1;
	@XmlElement(name = "SPARE2", namespace = "http://tempuri.org/")
	protected String spare2;
	@XmlElement(name = "SPARE3", namespace = "http://tempuri.org/")
	protected String spare3;
	@XmlElement(name = "SPARE4", namespace = "http://tempuri.org/")
	protected String spare4;
	@XmlElement(name = "SPARE5", namespace = "http://tempuri.org/")
	protected String spare5;
	@XmlElement(name = "S_FACTORY", namespace = "http://tempuri.org/")
	protected String sfactory;
	@XmlElement(name = "AGENC_NO", namespace = "http://tempuri.org/")
	protected String agencno;
	@XmlElement(name = "CREATED_BY", namespace = "http://tempuri.org/")
	protected String createdby;
	@XmlElement(name = "CREATED_NAME", namespace = "http://tempuri.org/")
	protected String createdname;
	@XmlElement(name = "CREATED_TIME", namespace = "http://tempuri.org/")
	protected String createdtime;
	@XmlElement(name = "CHANGED_BY", namespace = "http://tempuri.org/")
	protected String changedby;
	@XmlElement(name = "CHANGED_NAME", namespace = "http://tempuri.org/")
	protected String changedname;
	@XmlElement(name = "CHANGED_TIME", namespace = "http://tempuri.org/")
	protected String changedtime;
	@XmlElement(name = "ARCH_FLAG", namespace = "http://tempuri.org/")
	protected String archflag;
	@XmlElement(name = "RECORD_FLAG", namespace = "http://tempuri.org/")
	protected String recordflag;

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getID() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setID(String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the lotno property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLOTNO() {
		return lotno;
	}

	/**
	 * Sets the value of the lotno property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLOTNO(String value) {
		this.lotno = value;
	}

	/**
	 * Gets the value of the carriercode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCARRIERCODE() {
		return carriercode;
	}

	/**
	 * Sets the value of the carriercode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCARRIERCODE(String value) {
		this.carriercode = value;
	}

	/**
	 * Gets the value of the rfidisok property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRFIDISOK() {
		return rfidisok;
	}

	/**
	 * Sets the value of the rfidisok property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRFIDISOK(String value) {
		this.rfidisok = value;
	}

	/**
	 * Gets the value of the rfidetype property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRFIDETYPE() {
		return rfidetype;
	}

	/**
	 * Sets the value of the rfidetype property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRFIDETYPE(String value) {
		this.rfidetype = value;
	}

	/**
	 * Gets the value of the rfidremark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRFIDREMARK() {
		return rfidremark;
	}

	/**
	 * Sets the value of the rfidremark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRFIDREMARK(String value) {
		this.rfidremark = value;
	}

	/**
	 * Gets the value of the equipcode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEQUIPCODE() {
		return equipcode;
	}

	/**
	 * Sets the value of the equipcode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEQUIPCODE(String value) {
		this.equipcode = value;
	}

	/**
	 * Gets the value of the equipname property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEQUIPNAME() {
		return equipname;
	}

	/**
	 * Sets the value of the equipname property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEQUIPNAME(String value) {
		this.equipname = value;
	}

	/**
	 * Gets the value of the materialcode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMATERIALCODE() {
		return materialcode;
	}

	/**
	 * Sets the value of the materialcode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMATERIALCODE(String value) {
		this.materialcode = value;
	}

	/**
	 * Gets the value of the materialname property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMATERIALNAME() {
		return materialname;
	}

	/**
	 * Sets the value of the materialname property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMATERIALNAME(String value) {
		this.materialname = value;
	}

	/**
	 * Gets the value of the statecode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSTATECODE() {
		return statecode;
	}

	/**
	 * Sets the value of the statecode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSTATECODE(String value) {
		this.statecode = value;
	}

	/**
	 * Gets the value of the baseunit property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBASEUNIT() {
		return baseunit;
	}

	/**
	 * Sets the value of the baseunit property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBASEUNIT(String value) {
		this.baseunit = value;
	}

	/**
	 * Gets the value of the warehouseid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWAREHOUSEID() {
		return warehouseid;
	}

	/**
	 * Sets the value of the warehouseid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWAREHOUSEID(String value) {
		this.warehouseid = value;
	}

	/**
	 * Gets the value of the storetype property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSTORETYPE() {
		return storetype;
	}

	/**
	 * Sets the value of the storetype property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSTORETYPE(String value) {
		this.storetype = value;
	}

	/**
	 * Gets the value of the storecode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSTORECODE() {
		return storecode;
	}

	/**
	 * Sets the value of the storecode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSTORECODE(String value) {
		this.storecode = value;
	}

	/**
	 * Gets the value of the traycode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTRAYCODE() {
		return traycode;
	}

	/**
	 * Sets the value of the traycode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTRAYCODE(String value) {
		this.traycode = value;
	}

	/**
	 * Gets the value of the matchingcode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMATCHINGCODE() {
		return matchingcode;
	}

	/**
	 * Sets the value of the matchingcode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMATCHINGCODE(String value) {
		this.matchingcode = value;
	}

	/**
	 * Gets the value of the shelvesnum property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSHELVESNUM() {
		return shelvesnum;
	}

	/**
	 * Sets the value of the shelvesnum property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSHELVESNUM(String value) {
		this.shelvesnum = value;
	}

	/**
	 * Gets the value of the setbegintrainnum property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSETBEGINTRAINNUM() {
		return setbegintrainnum;
	}

	/**
	 * Sets the value of the setbegintrainnum property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSETBEGINTRAINNUM(String value) {
		this.setbegintrainnum = value;
	}

	/**
	 * Gets the value of the setendtrainnum property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSETENDTRAINNUM() {
		return setendtrainnum;
	}

	/**
	 * Sets the value of the setendtrainnum property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSETENDTRAINNUM(String value) {
		this.setendtrainnum = value;
	}

	/**
	 * Gets the value of the begintrainnum property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBEGINTRAINNUM() {
		return begintrainnum;
	}

	/**
	 * Sets the value of the begintrainnum property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBEGINTRAINNUM(String value) {
		this.begintrainnum = value;
	}

	/**
	 * Gets the value of the endtrainnum property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getENDTRAINNUM() {
		return endtrainnum;
	}

	/**
	 * Sets the value of the endtrainnum property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setENDTRAINNUM(String value) {
		this.endtrainnum = value;
	}

	/**
	 * Gets the value of the setweight property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSETWEIGHT() {
		return setweight;
	}

	/**
	 * Sets the value of the setweight property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSETWEIGHT(String value) {
		this.setweight = value;
	}

	/**
	 * Gets the value of the realweight property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getREALWEIGHT() {
		return realweight;
	}

	/**
	 * Sets the value of the realweight property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setREALWEIGHT(String value) {
		this.realweight = value;
	}

	/**
	 * Gets the value of the shiftcode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSHIFTCODE() {
		return shiftcode;
	}

	/**
	 * Sets the value of the shiftcode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSHIFTCODE(String value) {
		this.shiftcode = value;
	}

	/**
	 * Gets the value of the groupcode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGROUPCODE() {
		return groupcode;
	}

	/**
	 * Sets the value of the groupcode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGROUPCODE(String value) {
		this.groupcode = value;
	}

	/**
	 * Gets the value of the wono property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWONO() {
		return wono;
	}

	/**
	 * Sets the value of the wono property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWONO(String value) {
		this.wono = value;
	}

	/**
	 * Gets the value of the recipecode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRECIPECODE() {
		return recipecode;
	}

	/**
	 * Sets the value of the recipecode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRECIPECODE(String value) {
		this.recipecode = value;
	}

	/**
	 * Gets the value of the recipebomversion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRECIPEBOMVERSION() {
		return recipebomversion;
	}

	/**
	 * Sets the value of the recipebomversion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRECIPEBOMVERSION(String value) {
		this.recipebomversion = value;
	}

	/**
	 * Gets the value of the cuttype property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCUTTYPE() {
		return cuttype;
	}

	/**
	 * Sets the value of the cuttype property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCUTTYPE(String value) {
		this.cuttype = value;
	}

	/**
	 * Gets the value of the prodtype property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPRODTYPE() {
		return prodtype;
	}

	/**
	 * Sets the value of the prodtype property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPRODTYPE(String value) {
		this.prodtype = value;
	}

	/**
	 * Gets the value of the prodlocation property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPRODLOCATION() {
		return prodlocation;
	}

	/**
	 * Sets the value of the prodlocation property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPRODLOCATION(String value) {
		this.prodlocation = value;
	}

	/**
	 * Gets the value of the printtype property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPRINTTYPE() {
		return printtype;
	}

	/**
	 * Sets the value of the printtype property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPRINTTYPE(String value) {
		this.printtype = value;
	}

	/**
	 * Gets the value of the ischeck property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getISCHECK() {
		return ischeck;
	}

	/**
	 * Sets the value of the ischeck property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setISCHECK(String value) {
		this.ischeck = value;
	}

	/**
	 * Gets the value of the isselfcheck property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getISSELFCHECK() {
		return isselfcheck;
	}

	/**
	 * Sets the value of the isselfcheck property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setISSELFCHECK(String value) {
		this.isselfcheck = value;
	}

	/**
	 * Gets the value of the producttime property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPRODUCTTIME() {
		return producttime;
	}

	/**
	 * Sets the value of the producttime property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPRODUCTTIME(String value) {
		this.producttime = value;
	}

	/**
	 * Gets the value of the expirydate property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEXPIRYDATE() {
		return expirydate;
	}

	/**
	 * Sets the value of the expirydate property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEXPIRYDATE(String value) {
		this.expirydate = value;
	}

	/**
	 * Gets the value of the qcmark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getQCMARK() {
		return qcmark;
	}

	/**
	 * Sets the value of the qcmark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setQCMARK(String value) {
		this.qcmark = value;
	}

	/**
	 * Gets the value of the metalnum property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMETALNUM() {
		return metalnum;
	}

	/**
	 * Sets the value of the metalnum property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMETALNUM(String value) {
		this.metalnum = value;
	}

	/**
	 * Gets the value of the masterby property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMASTERBY() {
		return masterby;
	}

	/**
	 * Sets the value of the masterby property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMASTERBY(String value) {
		this.masterby = value;
	}

	/**
	 * Gets the value of the mastername property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMASTERNAME() {
		return mastername;
	}

	/**
	 * Sets the value of the mastername property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMASTERNAME(String value) {
		this.mastername = value;
	}

	/**
	 * Gets the value of the spliceby property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSPLICEBY() {
		return spliceby;
	}

	/**
	 * Sets the value of the spliceby property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSPLICEBY(String value) {
		this.spliceby = value;
	}

	/**
	 * Gets the value of the splicename property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSPLICENAME() {
		return splicename;
	}

	/**
	 * Sets the value of the splicename property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSPLICENAME(String value) {
		this.splicename = value;
	}

	/**
	 * Gets the value of the isbindtrain property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getISBINDTRAIN() {
		return isbindtrain;
	}

	/**
	 * Sets the value of the isbindtrain property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setISBINDTRAIN(String value) {
		this.isbindtrain = value;
	}

	/**
	 * Gets the value of the spare1 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSPARE1() {
		return spare1;
	}

	/**
	 * Sets the value of the spare1 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSPARE1(String value) {
		this.spare1 = value;
	}

	/**
	 * Gets the value of the spare2 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSPARE2() {
		return spare2;
	}

	/**
	 * Sets the value of the spare2 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSPARE2(String value) {
		this.spare2 = value;
	}

	/**
	 * Gets the value of the spare3 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSPARE3() {
		return spare3;
	}

	/**
	 * Sets the value of the spare3 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSPARE3(String value) {
		this.spare3 = value;
	}

	/**
	 * Gets the value of the spare4 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSPARE4() {
		return spare4;
	}

	/**
	 * Sets the value of the spare4 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSPARE4(String value) {
		this.spare4 = value;
	}

	/**
	 * Gets the value of the spare5 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSPARE5() {
		return spare5;
	}

	/**
	 * Sets the value of the spare5 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSPARE5(String value) {
		this.spare5 = value;
	}

	/**
	 * Gets the value of the sfactory property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSFACTORY() {
		return sfactory;
	}

	/**
	 * Sets the value of the sfactory property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSFACTORY(String value) {
		this.sfactory = value;
	}

	/**
	 * Gets the value of the agencno property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAGENCNO() {
		return agencno;
	}

	/**
	 * Sets the value of the agencno property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAGENCNO(String value) {
		this.agencno = value;
	}

	/**
	 * Gets the value of the createdby property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCREATEDBY() {
		return createdby;
	}

	/**
	 * Sets the value of the createdby property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCREATEDBY(String value) {
		this.createdby = value;
	}

	/**
	 * Gets the value of the createdname property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCREATEDNAME() {
		return createdname;
	}

	/**
	 * Sets the value of the createdname property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCREATEDNAME(String value) {
		this.createdname = value;
	}

	/**
	 * Gets the value of the createdtime property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCREATEDTIME() {
		return createdtime;
	}

	/**
	 * Sets the value of the createdtime property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCREATEDTIME(String value) {
		this.createdtime = value;
	}

	/**
	 * Gets the value of the changedby property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCHANGEDBY() {
		return changedby;
	}

	/**
	 * Sets the value of the changedby property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCHANGEDBY(String value) {
		this.changedby = value;
	}

	/**
	 * Gets the value of the changedname property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCHANGEDNAME() {
		return changedname;
	}

	/**
	 * Sets the value of the changedname property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCHANGEDNAME(String value) {
		this.changedname = value;
	}

	/**
	 * Gets the value of the changedtime property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCHANGEDTIME() {
		return changedtime;
	}

	/**
	 * Sets the value of the changedtime property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCHANGEDTIME(String value) {
		this.changedtime = value;
	}

	/**
	 * Gets the value of the archflag property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getARCHFLAG() {
		return archflag;
	}

	/**
	 * Sets the value of the archflag property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setARCHFLAG(String value) {
		this.archflag = value;
	}

	/**
	 * Gets the value of the recordflag property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRECORDFLAG() {
		return recordflag;
	}

	/**
	 * Sets the value of the recordflag property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRECORDFLAG(String value) {
		this.recordflag = value;
	}

}
