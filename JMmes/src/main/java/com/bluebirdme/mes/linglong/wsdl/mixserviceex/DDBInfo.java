package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DDBInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DDBInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="accessPrivilegeRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="activeDBDatabaseName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activeDBDatabaseProductName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activeDBDatabaseProductType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="activeDBDatabaseProductVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activeDBDatabaseURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activeDBDriverName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activeDBDriverVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activeDBSchemaMajorVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="activeDBSchemaMinorVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="activeDBSiteId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activeDBSiteNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="activeDBUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="applicationLogRetentionCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="applicationLogRetentionPeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="auditOverrides" type="{dataobjects.common.plantops.datasweep.com}DAuditOverride" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="authorizationCacheTimeout" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="caseInSensitiveTargetCase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="caseSensitiveNonDatasweepAuthentication" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="clientTimeout" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="closeLotWhenCompletelyConsumed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="createRTActivitySetHistory" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="defaultUserGroupNameForNewUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="disallowUserDeletion" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="enableConsolidatedLogging" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="enableDistributedEvent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="enableKeyedObjectChangedEvent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="enableServerStateChangeEvent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="enableSublotRevision" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="expectedDBSchemaInfo" type="{dataobjects.common.plantops.datasweep.com}DExpectedDBSchemaInfo" minOccurs="0"/>
 *         &lt;element name="failedLoginAttemptCount" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="filterByUTC" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="historicalDBDatabaseName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="historicalDBDatabaseProductName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="historicalDBDatabaseProductType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="historicalDBDatabaseProductVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="historicalDBDatabaseURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="historicalDBDriverName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="historicalDBDriverVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="historicalDBSchemaMajorVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="historicalDBSchemaMinorVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="historicalDBUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="historicalSiteInfo" type="{dataobjects.common.plantops.datasweep.com}DSiteInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="historyLoggingLevel" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="IOServerNumberOfBackupNodes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IOServerSyncPeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="inventoryBatchSublotNameSpecification" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="jmsPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jmsServerUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jmsUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licOrgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licSMTPBackupServer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licSMTPServer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licSenderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loggingPropertiesArray" type="{dataobjects.common.plantops.datasweep.com}DLoggingProperties" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lotMergeOption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mailPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mailProtocol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mailServerPort" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mailUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxElapseRetry" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="maxEmailAttachmentSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxRowsInFilter" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="messagingType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minElapseRetry" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="minPwdLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="objectRevisioningLevel" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="orderByUTC" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="periodJobConfigured" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="periodJobInterval" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pidIncrementPeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="purgeCommandTimeout" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="purgeDataAndTestRetentionPeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="purgePIDInterval" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="purgeRuntimeRetentionPeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="purgeTrxRetentionPeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="purgeUpdateStatistics" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pwdLowercaseLettersLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pwdNumericCharactersLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pwdSpecialCharactersLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pwdUppercaseLettersLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recordTrxForRTActivitySets" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="redoRetry" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SMTPFromAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SOAPFailoverAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="securityProviderIsDatasweep" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="serverType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siteSMTPHostId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sosFailoverClusterTimeout" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sosFailoverConnectionTimeout" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sosFailoverPingPeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sublotQuantityConstraint" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transactionLoggingLevel" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="validateRowSizeLimitConfig" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xfrBasePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xfrDSMonitorEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xfrFieldSepCmdLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xfrFieldSepControlFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xfrFieldSepDataFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xfrLogLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="xfrMaxExtractInterval" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="xfrMaxTableTimeout" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="xfrPreProcess" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xfrRecSepCmdLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xfrRecSepControlFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xfrRecSepDataFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xfrSetDSMonitor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="xfrUseFetchHint" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DDBInfo", propOrder = { "accessPrivilegeRequired",
		"activeDBDatabaseName", "activeDBDatabaseProductName",
		"activeDBDatabaseProductType", "activeDBDatabaseProductVersion",
		"activeDBDatabaseURL", "activeDBDriverName", "activeDBDriverVersion",
		"activeDBSchemaMajorVersion", "activeDBSchemaMinorVersion",
		"activeDBSiteId", "activeDBSiteNumber", "activeDBUserName",
		"applicationLogRetentionCount", "applicationLogRetentionPeriod",
		"auditOverrides", "authorizationCacheTimeout",
		"caseInSensitiveTargetCase", "caseSensitiveNonDatasweepAuthentication",
		"clientTimeout", "closeLotWhenCompletelyConsumed",
		"createRTActivitySetHistory", "defaultUserGroupNameForNewUser",
		"disallowUserDeletion", "enableConsolidatedLogging",
		"enableDistributedEvent", "enableKeyedObjectChangedEvent",
		"enableServerStateChangeEvent", "enableSublotRevision",
		"expectedDBSchemaInfo", "failedLoginAttemptCount", "filterByUTC",
		"historicalDBDatabaseName", "historicalDBDatabaseProductName",
		"historicalDBDatabaseProductType",
		"historicalDBDatabaseProductVersion", "historicalDBDatabaseURL",
		"historicalDBDriverName", "historicalDBDriverVersion",
		"historicalDBSchemaMajorVersion", "historicalDBSchemaMinorVersion",
		"historicalDBUserName", "historicalSiteInfo", "historyLoggingLevel",
		"ioServerNumberOfBackupNodes", "ioServerSyncPeriod",
		"inventoryBatchSublotNameSpecification", "jmsPassword", "jmsServerUrl",
		"jmsUserName", "licOrgName", "licSMTPBackupServer", "licSMTPServer",
		"licSenderName", "loggingPropertiesArray", "lotMergeOption",
		"mailPassword", "mailProtocol", "mailServerPort", "mailUserName",
		"maxElapseRetry", "maxEmailAttachmentSize", "maxRowsInFilter",
		"messagingType", "minElapseRetry", "minPwdLength",
		"objectRevisioningLevel", "orderByUTC", "periodJobConfigured",
		"periodJobInterval", "pidIncrementPeriod", "purgeCommandTimeout",
		"purgeDataAndTestRetentionPeriod", "purgePIDInterval",
		"purgeRuntimeRetentionPeriod", "purgeTrxRetentionPeriod",
		"purgeUpdateStatistics", "pwdLowercaseLettersLength",
		"pwdNumericCharactersLength", "pwdSpecialCharactersLength",
		"pwdUppercaseLettersLength", "recordTrxForRTActivitySets", "redoRetry",
		"smtpFromAddress", "soapFailoverAllowed",
		"securityProviderIsDatasweep", "serverType", "siteSMTPHostId",
		"sosFailoverClusterTimeout", "sosFailoverConnectionTimeout",
		"sosFailoverPingPeriod", "sublotQuantityConstraint",
		"transactionLoggingLevel", "validateRowSizeLimitConfig", "xfrBasePath",
		"xfrDSMonitorEmail", "xfrFieldSepCmdLine", "xfrFieldSepControlFile",
		"xfrFieldSepDataFile", "xfrLogLevel", "xfrMaxExtractInterval",
		"xfrMaxTableTimeout", "xfrPreProcess", "xfrRecSepCmdLine",
		"xfrRecSepControlFile", "xfrRecSepDataFile", "xfrSetDSMonitor",
		"xfrUseFetchHint" })
public class DDBInfo extends DDataObject {

	protected boolean accessPrivilegeRequired;
	protected String activeDBDatabaseName;
	protected String activeDBDatabaseProductName;
	protected short activeDBDatabaseProductType;
	protected String activeDBDatabaseProductVersion;
	protected String activeDBDatabaseURL;
	protected String activeDBDriverName;
	protected String activeDBDriverVersion;
	protected int activeDBSchemaMajorVersion;
	protected int activeDBSchemaMinorVersion;
	protected String activeDBSiteId;
	protected int activeDBSiteNumber;
	protected String activeDBUserName;
	protected int applicationLogRetentionCount;
	protected int applicationLogRetentionPeriod;
	@XmlElement(nillable = true)
	protected List<DAuditOverride> auditOverrides;
	protected int authorizationCacheTimeout;
	protected String caseInSensitiveTargetCase;
	protected boolean caseSensitiveNonDatasweepAuthentication;
	protected int clientTimeout;
	protected boolean closeLotWhenCompletelyConsumed;
	protected boolean createRTActivitySetHistory;
	protected String defaultUserGroupNameForNewUser;
	protected boolean disallowUserDeletion;
	protected boolean enableConsolidatedLogging;
	protected boolean enableDistributedEvent;
	protected boolean enableKeyedObjectChangedEvent;
	protected boolean enableServerStateChangeEvent;
	protected boolean enableSublotRevision;
	protected DExpectedDBSchemaInfo expectedDBSchemaInfo;
	protected short failedLoginAttemptCount;
	protected boolean filterByUTC;
	protected String historicalDBDatabaseName;
	protected String historicalDBDatabaseProductName;
	protected short historicalDBDatabaseProductType;
	protected String historicalDBDatabaseProductVersion;
	protected String historicalDBDatabaseURL;
	protected String historicalDBDriverName;
	protected String historicalDBDriverVersion;
	protected int historicalDBSchemaMajorVersion;
	protected int historicalDBSchemaMinorVersion;
	protected String historicalDBUserName;
	@XmlElement(nillable = true)
	protected List<DSiteInfo> historicalSiteInfo;
	protected short historyLoggingLevel;
	@XmlElement(name = "IOServerNumberOfBackupNodes")
	protected int ioServerNumberOfBackupNodes;
	@XmlElement(name = "IOServerSyncPeriod")
	protected int ioServerSyncPeriod;
	protected int inventoryBatchSublotNameSpecification;
	protected String jmsPassword;
	protected String jmsServerUrl;
	protected String jmsUserName;
	protected String licOrgName;
	protected String licSMTPBackupServer;
	protected String licSMTPServer;
	protected String licSenderName;
	@XmlElement(nillable = true)
	protected List<DLoggingProperties> loggingPropertiesArray;
	protected String lotMergeOption;
	protected String mailPassword;
	protected String mailProtocol;
	protected int mailServerPort;
	protected String mailUserName;
	protected long maxElapseRetry;
	protected int maxEmailAttachmentSize;
	protected int maxRowsInFilter;
	protected String messagingType;
	protected long minElapseRetry;
	protected int minPwdLength;
	protected short objectRevisioningLevel;
	protected boolean orderByUTC;
	protected int periodJobConfigured;
	protected int periodJobInterval;
	protected int pidIncrementPeriod;
	protected int purgeCommandTimeout;
	protected int purgeDataAndTestRetentionPeriod;
	protected int purgePIDInterval;
	protected int purgeRuntimeRetentionPeriod;
	protected int purgeTrxRetentionPeriod;
	protected String purgeUpdateStatistics;
	protected int pwdLowercaseLettersLength;
	protected int pwdNumericCharactersLength;
	protected int pwdSpecialCharactersLength;
	protected int pwdUppercaseLettersLength;
	protected boolean recordTrxForRTActivitySets;
	protected int redoRetry;
	@XmlElement(name = "SMTPFromAddress")
	protected String smtpFromAddress;
	@XmlElement(name = "SOAPFailoverAllowed")
	protected boolean soapFailoverAllowed;
	protected boolean securityProviderIsDatasweep;
	protected String serverType;
	protected String siteSMTPHostId;
	protected int sosFailoverClusterTimeout;
	protected int sosFailoverConnectionTimeout;
	protected int sosFailoverPingPeriod;
	protected int sublotQuantityConstraint;
	protected short transactionLoggingLevel;
	protected String validateRowSizeLimitConfig;
	protected String xfrBasePath;
	protected String xfrDSMonitorEmail;
	protected String xfrFieldSepCmdLine;
	protected String xfrFieldSepControlFile;
	protected String xfrFieldSepDataFile;
	protected int xfrLogLevel;
	protected int xfrMaxExtractInterval;
	protected int xfrMaxTableTimeout;
	protected String xfrPreProcess;
	protected String xfrRecSepCmdLine;
	protected String xfrRecSepControlFile;
	protected String xfrRecSepDataFile;
	protected int xfrSetDSMonitor;
	protected int xfrUseFetchHint;

	/**
	 * Gets the value of the accessPrivilegeRequired property.
	 * 
	 */
	public boolean isAccessPrivilegeRequired() {
		return accessPrivilegeRequired;
	}

	/**
	 * Sets the value of the accessPrivilegeRequired property.
	 * 
	 */
	public void setAccessPrivilegeRequired(boolean value) {
		this.accessPrivilegeRequired = value;
	}

	/**
	 * Gets the value of the activeDBDatabaseName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getActiveDBDatabaseName() {
		return activeDBDatabaseName;
	}

	/**
	 * Sets the value of the activeDBDatabaseName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setActiveDBDatabaseName(String value) {
		this.activeDBDatabaseName = value;
	}

	/**
	 * Gets the value of the activeDBDatabaseProductName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getActiveDBDatabaseProductName() {
		return activeDBDatabaseProductName;
	}

	/**
	 * Sets the value of the activeDBDatabaseProductName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setActiveDBDatabaseProductName(String value) {
		this.activeDBDatabaseProductName = value;
	}

	/**
	 * Gets the value of the activeDBDatabaseProductType property.
	 * 
	 */
	public short getActiveDBDatabaseProductType() {
		return activeDBDatabaseProductType;
	}

	/**
	 * Sets the value of the activeDBDatabaseProductType property.
	 * 
	 */
	public void setActiveDBDatabaseProductType(short value) {
		this.activeDBDatabaseProductType = value;
	}

	/**
	 * Gets the value of the activeDBDatabaseProductVersion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getActiveDBDatabaseProductVersion() {
		return activeDBDatabaseProductVersion;
	}

	/**
	 * Sets the value of the activeDBDatabaseProductVersion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setActiveDBDatabaseProductVersion(String value) {
		this.activeDBDatabaseProductVersion = value;
	}

	/**
	 * Gets the value of the activeDBDatabaseURL property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getActiveDBDatabaseURL() {
		return activeDBDatabaseURL;
	}

	/**
	 * Sets the value of the activeDBDatabaseURL property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setActiveDBDatabaseURL(String value) {
		this.activeDBDatabaseURL = value;
	}

	/**
	 * Gets the value of the activeDBDriverName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getActiveDBDriverName() {
		return activeDBDriverName;
	}

	/**
	 * Sets the value of the activeDBDriverName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setActiveDBDriverName(String value) {
		this.activeDBDriverName = value;
	}

	/**
	 * Gets the value of the activeDBDriverVersion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getActiveDBDriverVersion() {
		return activeDBDriverVersion;
	}

	/**
	 * Sets the value of the activeDBDriverVersion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setActiveDBDriverVersion(String value) {
		this.activeDBDriverVersion = value;
	}

	/**
	 * Gets the value of the activeDBSchemaMajorVersion property.
	 * 
	 */
	public int getActiveDBSchemaMajorVersion() {
		return activeDBSchemaMajorVersion;
	}

	/**
	 * Sets the value of the activeDBSchemaMajorVersion property.
	 * 
	 */
	public void setActiveDBSchemaMajorVersion(int value) {
		this.activeDBSchemaMajorVersion = value;
	}

	/**
	 * Gets the value of the activeDBSchemaMinorVersion property.
	 * 
	 */
	public int getActiveDBSchemaMinorVersion() {
		return activeDBSchemaMinorVersion;
	}

	/**
	 * Sets the value of the activeDBSchemaMinorVersion property.
	 * 
	 */
	public void setActiveDBSchemaMinorVersion(int value) {
		this.activeDBSchemaMinorVersion = value;
	}

	/**
	 * Gets the value of the activeDBSiteId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getActiveDBSiteId() {
		return activeDBSiteId;
	}

	/**
	 * Sets the value of the activeDBSiteId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setActiveDBSiteId(String value) {
		this.activeDBSiteId = value;
	}

	/**
	 * Gets the value of the activeDBSiteNumber property.
	 * 
	 */
	public int getActiveDBSiteNumber() {
		return activeDBSiteNumber;
	}

	/**
	 * Sets the value of the activeDBSiteNumber property.
	 * 
	 */
	public void setActiveDBSiteNumber(int value) {
		this.activeDBSiteNumber = value;
	}

	/**
	 * Gets the value of the activeDBUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getActiveDBUserName() {
		return activeDBUserName;
	}

	/**
	 * Sets the value of the activeDBUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setActiveDBUserName(String value) {
		this.activeDBUserName = value;
	}

	/**
	 * Gets the value of the applicationLogRetentionCount property.
	 * 
	 */
	public int getApplicationLogRetentionCount() {
		return applicationLogRetentionCount;
	}

	/**
	 * Sets the value of the applicationLogRetentionCount property.
	 * 
	 */
	public void setApplicationLogRetentionCount(int value) {
		this.applicationLogRetentionCount = value;
	}

	/**
	 * Gets the value of the applicationLogRetentionPeriod property.
	 * 
	 */
	public int getApplicationLogRetentionPeriod() {
		return applicationLogRetentionPeriod;
	}

	/**
	 * Sets the value of the applicationLogRetentionPeriod property.
	 * 
	 */
	public void setApplicationLogRetentionPeriod(int value) {
		this.applicationLogRetentionPeriod = value;
	}

	/**
	 * Gets the value of the auditOverrides property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the auditOverrides property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAuditOverrides().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DAuditOverride }
	 * 
	 * 
	 */
	public List<DAuditOverride> getAuditOverrides() {
		if (auditOverrides == null) {
			auditOverrides = new ArrayList<DAuditOverride>();
		}
		return this.auditOverrides;
	}

	/**
	 * Gets the value of the authorizationCacheTimeout property.
	 * 
	 */
	public int getAuthorizationCacheTimeout() {
		return authorizationCacheTimeout;
	}

	/**
	 * Sets the value of the authorizationCacheTimeout property.
	 * 
	 */
	public void setAuthorizationCacheTimeout(int value) {
		this.authorizationCacheTimeout = value;
	}

	/**
	 * Gets the value of the caseInSensitiveTargetCase property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCaseInSensitiveTargetCase() {
		return caseInSensitiveTargetCase;
	}

	/**
	 * Sets the value of the caseInSensitiveTargetCase property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCaseInSensitiveTargetCase(String value) {
		this.caseInSensitiveTargetCase = value;
	}

	/**
	 * Gets the value of the caseSensitiveNonDatasweepAuthentication property.
	 * 
	 */
	public boolean isCaseSensitiveNonDatasweepAuthentication() {
		return caseSensitiveNonDatasweepAuthentication;
	}

	/**
	 * Sets the value of the caseSensitiveNonDatasweepAuthentication property.
	 * 
	 */
	public void setCaseSensitiveNonDatasweepAuthentication(boolean value) {
		this.caseSensitiveNonDatasweepAuthentication = value;
	}

	/**
	 * Gets the value of the clientTimeout property.
	 * 
	 */
	public int getClientTimeout() {
		return clientTimeout;
	}

	/**
	 * Sets the value of the clientTimeout property.
	 * 
	 */
	public void setClientTimeout(int value) {
		this.clientTimeout = value;
	}

	/**
	 * Gets the value of the closeLotWhenCompletelyConsumed property.
	 * 
	 */
	public boolean isCloseLotWhenCompletelyConsumed() {
		return closeLotWhenCompletelyConsumed;
	}

	/**
	 * Sets the value of the closeLotWhenCompletelyConsumed property.
	 * 
	 */
	public void setCloseLotWhenCompletelyConsumed(boolean value) {
		this.closeLotWhenCompletelyConsumed = value;
	}

	/**
	 * Gets the value of the createRTActivitySetHistory property.
	 * 
	 */
	public boolean isCreateRTActivitySetHistory() {
		return createRTActivitySetHistory;
	}

	/**
	 * Sets the value of the createRTActivitySetHistory property.
	 * 
	 */
	public void setCreateRTActivitySetHistory(boolean value) {
		this.createRTActivitySetHistory = value;
	}

	/**
	 * Gets the value of the defaultUserGroupNameForNewUser property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDefaultUserGroupNameForNewUser() {
		return defaultUserGroupNameForNewUser;
	}

	/**
	 * Sets the value of the defaultUserGroupNameForNewUser property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDefaultUserGroupNameForNewUser(String value) {
		this.defaultUserGroupNameForNewUser = value;
	}

	/**
	 * Gets the value of the disallowUserDeletion property.
	 * 
	 */
	public boolean isDisallowUserDeletion() {
		return disallowUserDeletion;
	}

	/**
	 * Sets the value of the disallowUserDeletion property.
	 * 
	 */
	public void setDisallowUserDeletion(boolean value) {
		this.disallowUserDeletion = value;
	}

	/**
	 * Gets the value of the enableConsolidatedLogging property.
	 * 
	 */
	public boolean isEnableConsolidatedLogging() {
		return enableConsolidatedLogging;
	}

	/**
	 * Sets the value of the enableConsolidatedLogging property.
	 * 
	 */
	public void setEnableConsolidatedLogging(boolean value) {
		this.enableConsolidatedLogging = value;
	}

	/**
	 * Gets the value of the enableDistributedEvent property.
	 * 
	 */
	public boolean isEnableDistributedEvent() {
		return enableDistributedEvent;
	}

	/**
	 * Sets the value of the enableDistributedEvent property.
	 * 
	 */
	public void setEnableDistributedEvent(boolean value) {
		this.enableDistributedEvent = value;
	}

	/**
	 * Gets the value of the enableKeyedObjectChangedEvent property.
	 * 
	 */
	public boolean isEnableKeyedObjectChangedEvent() {
		return enableKeyedObjectChangedEvent;
	}

	/**
	 * Sets the value of the enableKeyedObjectChangedEvent property.
	 * 
	 */
	public void setEnableKeyedObjectChangedEvent(boolean value) {
		this.enableKeyedObjectChangedEvent = value;
	}

	/**
	 * Gets the value of the enableServerStateChangeEvent property.
	 * 
	 */
	public boolean isEnableServerStateChangeEvent() {
		return enableServerStateChangeEvent;
	}

	/**
	 * Sets the value of the enableServerStateChangeEvent property.
	 * 
	 */
	public void setEnableServerStateChangeEvent(boolean value) {
		this.enableServerStateChangeEvent = value;
	}

	/**
	 * Gets the value of the enableSublotRevision property.
	 * 
	 */
	public boolean isEnableSublotRevision() {
		return enableSublotRevision;
	}

	/**
	 * Sets the value of the enableSublotRevision property.
	 * 
	 */
	public void setEnableSublotRevision(boolean value) {
		this.enableSublotRevision = value;
	}

	/**
	 * Gets the value of the expectedDBSchemaInfo property.
	 * 
	 * @return possible object is {@link DExpectedDBSchemaInfo }
	 * 
	 */
	public DExpectedDBSchemaInfo getExpectedDBSchemaInfo() {
		return expectedDBSchemaInfo;
	}

	/**
	 * Sets the value of the expectedDBSchemaInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DExpectedDBSchemaInfo }
	 * 
	 */
	public void setExpectedDBSchemaInfo(DExpectedDBSchemaInfo value) {
		this.expectedDBSchemaInfo = value;
	}

	/**
	 * Gets the value of the failedLoginAttemptCount property.
	 * 
	 */
	public short getFailedLoginAttemptCount() {
		return failedLoginAttemptCount;
	}

	/**
	 * Sets the value of the failedLoginAttemptCount property.
	 * 
	 */
	public void setFailedLoginAttemptCount(short value) {
		this.failedLoginAttemptCount = value;
	}

	/**
	 * Gets the value of the filterByUTC property.
	 * 
	 */
	public boolean isFilterByUTC() {
		return filterByUTC;
	}

	/**
	 * Sets the value of the filterByUTC property.
	 * 
	 */
	public void setFilterByUTC(boolean value) {
		this.filterByUTC = value;
	}

	/**
	 * Gets the value of the historicalDBDatabaseName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHistoricalDBDatabaseName() {
		return historicalDBDatabaseName;
	}

	/**
	 * Sets the value of the historicalDBDatabaseName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHistoricalDBDatabaseName(String value) {
		this.historicalDBDatabaseName = value;
	}

	/**
	 * Gets the value of the historicalDBDatabaseProductName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHistoricalDBDatabaseProductName() {
		return historicalDBDatabaseProductName;
	}

	/**
	 * Sets the value of the historicalDBDatabaseProductName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHistoricalDBDatabaseProductName(String value) {
		this.historicalDBDatabaseProductName = value;
	}

	/**
	 * Gets the value of the historicalDBDatabaseProductType property.
	 * 
	 */
	public short getHistoricalDBDatabaseProductType() {
		return historicalDBDatabaseProductType;
	}

	/**
	 * Sets the value of the historicalDBDatabaseProductType property.
	 * 
	 */
	public void setHistoricalDBDatabaseProductType(short value) {
		this.historicalDBDatabaseProductType = value;
	}

	/**
	 * Gets the value of the historicalDBDatabaseProductVersion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHistoricalDBDatabaseProductVersion() {
		return historicalDBDatabaseProductVersion;
	}

	/**
	 * Sets the value of the historicalDBDatabaseProductVersion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHistoricalDBDatabaseProductVersion(String value) {
		this.historicalDBDatabaseProductVersion = value;
	}

	/**
	 * Gets the value of the historicalDBDatabaseURL property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHistoricalDBDatabaseURL() {
		return historicalDBDatabaseURL;
	}

	/**
	 * Sets the value of the historicalDBDatabaseURL property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHistoricalDBDatabaseURL(String value) {
		this.historicalDBDatabaseURL = value;
	}

	/**
	 * Gets the value of the historicalDBDriverName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHistoricalDBDriverName() {
		return historicalDBDriverName;
	}

	/**
	 * Sets the value of the historicalDBDriverName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHistoricalDBDriverName(String value) {
		this.historicalDBDriverName = value;
	}

	/**
	 * Gets the value of the historicalDBDriverVersion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHistoricalDBDriverVersion() {
		return historicalDBDriverVersion;
	}

	/**
	 * Sets the value of the historicalDBDriverVersion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHistoricalDBDriverVersion(String value) {
		this.historicalDBDriverVersion = value;
	}

	/**
	 * Gets the value of the historicalDBSchemaMajorVersion property.
	 * 
	 */
	public int getHistoricalDBSchemaMajorVersion() {
		return historicalDBSchemaMajorVersion;
	}

	/**
	 * Sets the value of the historicalDBSchemaMajorVersion property.
	 * 
	 */
	public void setHistoricalDBSchemaMajorVersion(int value) {
		this.historicalDBSchemaMajorVersion = value;
	}

	/**
	 * Gets the value of the historicalDBSchemaMinorVersion property.
	 * 
	 */
	public int getHistoricalDBSchemaMinorVersion() {
		return historicalDBSchemaMinorVersion;
	}

	/**
	 * Sets the value of the historicalDBSchemaMinorVersion property.
	 * 
	 */
	public void setHistoricalDBSchemaMinorVersion(int value) {
		this.historicalDBSchemaMinorVersion = value;
	}

	/**
	 * Gets the value of the historicalDBUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHistoricalDBUserName() {
		return historicalDBUserName;
	}

	/**
	 * Sets the value of the historicalDBUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHistoricalDBUserName(String value) {
		this.historicalDBUserName = value;
	}

	/**
	 * Gets the value of the historicalSiteInfo property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the historicalSiteInfo property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getHistoricalSiteInfo().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DSiteInfo }
	 * 
	 * 
	 */
	public List<DSiteInfo> getHistoricalSiteInfo() {
		if (historicalSiteInfo == null) {
			historicalSiteInfo = new ArrayList<DSiteInfo>();
		}
		return this.historicalSiteInfo;
	}

	/**
	 * Gets the value of the historyLoggingLevel property.
	 * 
	 */
	public short getHistoryLoggingLevel() {
		return historyLoggingLevel;
	}

	/**
	 * Sets the value of the historyLoggingLevel property.
	 * 
	 */
	public void setHistoryLoggingLevel(short value) {
		this.historyLoggingLevel = value;
	}

	/**
	 * Gets the value of the ioServerNumberOfBackupNodes property.
	 * 
	 */
	public int getIOServerNumberOfBackupNodes() {
		return ioServerNumberOfBackupNodes;
	}

	/**
	 * Sets the value of the ioServerNumberOfBackupNodes property.
	 * 
	 */
	public void setIOServerNumberOfBackupNodes(int value) {
		this.ioServerNumberOfBackupNodes = value;
	}

	/**
	 * Gets the value of the ioServerSyncPeriod property.
	 * 
	 */
	public int getIOServerSyncPeriod() {
		return ioServerSyncPeriod;
	}

	/**
	 * Sets the value of the ioServerSyncPeriod property.
	 * 
	 */
	public void setIOServerSyncPeriod(int value) {
		this.ioServerSyncPeriod = value;
	}

	/**
	 * Gets the value of the inventoryBatchSublotNameSpecification property.
	 * 
	 */
	public int getInventoryBatchSublotNameSpecification() {
		return inventoryBatchSublotNameSpecification;
	}

	/**
	 * Sets the value of the inventoryBatchSublotNameSpecification property.
	 * 
	 */
	public void setInventoryBatchSublotNameSpecification(int value) {
		this.inventoryBatchSublotNameSpecification = value;
	}

	/**
	 * Gets the value of the jmsPassword property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJmsPassword() {
		return jmsPassword;
	}

	/**
	 * Sets the value of the jmsPassword property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setJmsPassword(String value) {
		this.jmsPassword = value;
	}

	/**
	 * Gets the value of the jmsServerUrl property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJmsServerUrl() {
		return jmsServerUrl;
	}

	/**
	 * Sets the value of the jmsServerUrl property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setJmsServerUrl(String value) {
		this.jmsServerUrl = value;
	}

	/**
	 * Gets the value of the jmsUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJmsUserName() {
		return jmsUserName;
	}

	/**
	 * Sets the value of the jmsUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setJmsUserName(String value) {
		this.jmsUserName = value;
	}

	/**
	 * Gets the value of the licOrgName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLicOrgName() {
		return licOrgName;
	}

	/**
	 * Sets the value of the licOrgName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLicOrgName(String value) {
		this.licOrgName = value;
	}

	/**
	 * Gets the value of the licSMTPBackupServer property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLicSMTPBackupServer() {
		return licSMTPBackupServer;
	}

	/**
	 * Sets the value of the licSMTPBackupServer property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLicSMTPBackupServer(String value) {
		this.licSMTPBackupServer = value;
	}

	/**
	 * Gets the value of the licSMTPServer property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLicSMTPServer() {
		return licSMTPServer;
	}

	/**
	 * Sets the value of the licSMTPServer property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLicSMTPServer(String value) {
		this.licSMTPServer = value;
	}

	/**
	 * Gets the value of the licSenderName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLicSenderName() {
		return licSenderName;
	}

	/**
	 * Sets the value of the licSenderName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLicSenderName(String value) {
		this.licSenderName = value;
	}

	/**
	 * Gets the value of the loggingPropertiesArray property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the loggingPropertiesArray property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getLoggingPropertiesArray().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DLoggingProperties }
	 * 
	 * 
	 */
	public List<DLoggingProperties> getLoggingPropertiesArray() {
		if (loggingPropertiesArray == null) {
			loggingPropertiesArray = new ArrayList<DLoggingProperties>();
		}
		return this.loggingPropertiesArray;
	}

	/**
	 * Gets the value of the lotMergeOption property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLotMergeOption() {
		return lotMergeOption;
	}

	/**
	 * Sets the value of the lotMergeOption property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLotMergeOption(String value) {
		this.lotMergeOption = value;
	}

	/**
	 * Gets the value of the mailPassword property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMailPassword() {
		return mailPassword;
	}

	/**
	 * Sets the value of the mailPassword property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMailPassword(String value) {
		this.mailPassword = value;
	}

	/**
	 * Gets the value of the mailProtocol property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMailProtocol() {
		return mailProtocol;
	}

	/**
	 * Sets the value of the mailProtocol property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMailProtocol(String value) {
		this.mailProtocol = value;
	}

	/**
	 * Gets the value of the mailServerPort property.
	 * 
	 */
	public int getMailServerPort() {
		return mailServerPort;
	}

	/**
	 * Sets the value of the mailServerPort property.
	 * 
	 */
	public void setMailServerPort(int value) {
		this.mailServerPort = value;
	}

	/**
	 * Gets the value of the mailUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMailUserName() {
		return mailUserName;
	}

	/**
	 * Sets the value of the mailUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMailUserName(String value) {
		this.mailUserName = value;
	}

	/**
	 * Gets the value of the maxElapseRetry property.
	 * 
	 */
	public long getMaxElapseRetry() {
		return maxElapseRetry;
	}

	/**
	 * Sets the value of the maxElapseRetry property.
	 * 
	 */
	public void setMaxElapseRetry(long value) {
		this.maxElapseRetry = value;
	}

	/**
	 * Gets the value of the maxEmailAttachmentSize property.
	 * 
	 */
	public int getMaxEmailAttachmentSize() {
		return maxEmailAttachmentSize;
	}

	/**
	 * Sets the value of the maxEmailAttachmentSize property.
	 * 
	 */
	public void setMaxEmailAttachmentSize(int value) {
		this.maxEmailAttachmentSize = value;
	}

	/**
	 * Gets the value of the maxRowsInFilter property.
	 * 
	 */
	public int getMaxRowsInFilter() {
		return maxRowsInFilter;
	}

	/**
	 * Sets the value of the maxRowsInFilter property.
	 * 
	 */
	public void setMaxRowsInFilter(int value) {
		this.maxRowsInFilter = value;
	}

	/**
	 * Gets the value of the messagingType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMessagingType() {
		return messagingType;
	}

	/**
	 * Sets the value of the messagingType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMessagingType(String value) {
		this.messagingType = value;
	}

	/**
	 * Gets the value of the minElapseRetry property.
	 * 
	 */
	public long getMinElapseRetry() {
		return minElapseRetry;
	}

	/**
	 * Sets the value of the minElapseRetry property.
	 * 
	 */
	public void setMinElapseRetry(long value) {
		this.minElapseRetry = value;
	}

	/**
	 * Gets the value of the minPwdLength property.
	 * 
	 */
	public int getMinPwdLength() {
		return minPwdLength;
	}

	/**
	 * Sets the value of the minPwdLength property.
	 * 
	 */
	public void setMinPwdLength(int value) {
		this.minPwdLength = value;
	}

	/**
	 * Gets the value of the objectRevisioningLevel property.
	 * 
	 */
	public short getObjectRevisioningLevel() {
		return objectRevisioningLevel;
	}

	/**
	 * Sets the value of the objectRevisioningLevel property.
	 * 
	 */
	public void setObjectRevisioningLevel(short value) {
		this.objectRevisioningLevel = value;
	}

	/**
	 * Gets the value of the orderByUTC property.
	 * 
	 */
	public boolean isOrderByUTC() {
		return orderByUTC;
	}

	/**
	 * Sets the value of the orderByUTC property.
	 * 
	 */
	public void setOrderByUTC(boolean value) {
		this.orderByUTC = value;
	}

	/**
	 * Gets the value of the periodJobConfigured property.
	 * 
	 */
	public int getPeriodJobConfigured() {
		return periodJobConfigured;
	}

	/**
	 * Sets the value of the periodJobConfigured property.
	 * 
	 */
	public void setPeriodJobConfigured(int value) {
		this.periodJobConfigured = value;
	}

	/**
	 * Gets the value of the periodJobInterval property.
	 * 
	 */
	public int getPeriodJobInterval() {
		return periodJobInterval;
	}

	/**
	 * Sets the value of the periodJobInterval property.
	 * 
	 */
	public void setPeriodJobInterval(int value) {
		this.periodJobInterval = value;
	}

	/**
	 * Gets the value of the pidIncrementPeriod property.
	 * 
	 */
	public int getPidIncrementPeriod() {
		return pidIncrementPeriod;
	}

	/**
	 * Sets the value of the pidIncrementPeriod property.
	 * 
	 */
	public void setPidIncrementPeriod(int value) {
		this.pidIncrementPeriod = value;
	}

	/**
	 * Gets the value of the purgeCommandTimeout property.
	 * 
	 */
	public int getPurgeCommandTimeout() {
		return purgeCommandTimeout;
	}

	/**
	 * Sets the value of the purgeCommandTimeout property.
	 * 
	 */
	public void setPurgeCommandTimeout(int value) {
		this.purgeCommandTimeout = value;
	}

	/**
	 * Gets the value of the purgeDataAndTestRetentionPeriod property.
	 * 
	 */
	public int getPurgeDataAndTestRetentionPeriod() {
		return purgeDataAndTestRetentionPeriod;
	}

	/**
	 * Sets the value of the purgeDataAndTestRetentionPeriod property.
	 * 
	 */
	public void setPurgeDataAndTestRetentionPeriod(int value) {
		this.purgeDataAndTestRetentionPeriod = value;
	}

	/**
	 * Gets the value of the purgePIDInterval property.
	 * 
	 */
	public int getPurgePIDInterval() {
		return purgePIDInterval;
	}

	/**
	 * Sets the value of the purgePIDInterval property.
	 * 
	 */
	public void setPurgePIDInterval(int value) {
		this.purgePIDInterval = value;
	}

	/**
	 * Gets the value of the purgeRuntimeRetentionPeriod property.
	 * 
	 */
	public int getPurgeRuntimeRetentionPeriod() {
		return purgeRuntimeRetentionPeriod;
	}

	/**
	 * Sets the value of the purgeRuntimeRetentionPeriod property.
	 * 
	 */
	public void setPurgeRuntimeRetentionPeriod(int value) {
		this.purgeRuntimeRetentionPeriod = value;
	}

	/**
	 * Gets the value of the purgeTrxRetentionPeriod property.
	 * 
	 */
	public int getPurgeTrxRetentionPeriod() {
		return purgeTrxRetentionPeriod;
	}

	/**
	 * Sets the value of the purgeTrxRetentionPeriod property.
	 * 
	 */
	public void setPurgeTrxRetentionPeriod(int value) {
		this.purgeTrxRetentionPeriod = value;
	}

	/**
	 * Gets the value of the purgeUpdateStatistics property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPurgeUpdateStatistics() {
		return purgeUpdateStatistics;
	}

	/**
	 * Sets the value of the purgeUpdateStatistics property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPurgeUpdateStatistics(String value) {
		this.purgeUpdateStatistics = value;
	}

	/**
	 * Gets the value of the pwdLowercaseLettersLength property.
	 * 
	 */
	public int getPwdLowercaseLettersLength() {
		return pwdLowercaseLettersLength;
	}

	/**
	 * Sets the value of the pwdLowercaseLettersLength property.
	 * 
	 */
	public void setPwdLowercaseLettersLength(int value) {
		this.pwdLowercaseLettersLength = value;
	}

	/**
	 * Gets the value of the pwdNumericCharactersLength property.
	 * 
	 */
	public int getPwdNumericCharactersLength() {
		return pwdNumericCharactersLength;
	}

	/**
	 * Sets the value of the pwdNumericCharactersLength property.
	 * 
	 */
	public void setPwdNumericCharactersLength(int value) {
		this.pwdNumericCharactersLength = value;
	}

	/**
	 * Gets the value of the pwdSpecialCharactersLength property.
	 * 
	 */
	public int getPwdSpecialCharactersLength() {
		return pwdSpecialCharactersLength;
	}

	/**
	 * Sets the value of the pwdSpecialCharactersLength property.
	 * 
	 */
	public void setPwdSpecialCharactersLength(int value) {
		this.pwdSpecialCharactersLength = value;
	}

	/**
	 * Gets the value of the pwdUppercaseLettersLength property.
	 * 
	 */
	public int getPwdUppercaseLettersLength() {
		return pwdUppercaseLettersLength;
	}

	/**
	 * Sets the value of the pwdUppercaseLettersLength property.
	 * 
	 */
	public void setPwdUppercaseLettersLength(int value) {
		this.pwdUppercaseLettersLength = value;
	}

	/**
	 * Gets the value of the recordTrxForRTActivitySets property.
	 * 
	 */
	public boolean isRecordTrxForRTActivitySets() {
		return recordTrxForRTActivitySets;
	}

	/**
	 * Sets the value of the recordTrxForRTActivitySets property.
	 * 
	 */
	public void setRecordTrxForRTActivitySets(boolean value) {
		this.recordTrxForRTActivitySets = value;
	}

	/**
	 * Gets the value of the redoRetry property.
	 * 
	 */
	public int getRedoRetry() {
		return redoRetry;
	}

	/**
	 * Sets the value of the redoRetry property.
	 * 
	 */
	public void setRedoRetry(int value) {
		this.redoRetry = value;
	}

	/**
	 * Gets the value of the smtpFromAddress property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSMTPFromAddress() {
		return smtpFromAddress;
	}

	/**
	 * Sets the value of the smtpFromAddress property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSMTPFromAddress(String value) {
		this.smtpFromAddress = value;
	}

	/**
	 * Gets the value of the soapFailoverAllowed property.
	 * 
	 */
	public boolean isSOAPFailoverAllowed() {
		return soapFailoverAllowed;
	}

	/**
	 * Sets the value of the soapFailoverAllowed property.
	 * 
	 */
	public void setSOAPFailoverAllowed(boolean value) {
		this.soapFailoverAllowed = value;
	}

	/**
	 * Gets the value of the securityProviderIsDatasweep property.
	 * 
	 */
	public boolean isSecurityProviderIsDatasweep() {
		return securityProviderIsDatasweep;
	}

	/**
	 * Sets the value of the securityProviderIsDatasweep property.
	 * 
	 */
	public void setSecurityProviderIsDatasweep(boolean value) {
		this.securityProviderIsDatasweep = value;
	}

	/**
	 * Gets the value of the serverType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getServerType() {
		return serverType;
	}

	/**
	 * Sets the value of the serverType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setServerType(String value) {
		this.serverType = value;
	}

	/**
	 * Gets the value of the siteSMTPHostId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSiteSMTPHostId() {
		return siteSMTPHostId;
	}

	/**
	 * Sets the value of the siteSMTPHostId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSiteSMTPHostId(String value) {
		this.siteSMTPHostId = value;
	}

	/**
	 * Gets the value of the sosFailoverClusterTimeout property.
	 * 
	 */
	public int getSosFailoverClusterTimeout() {
		return sosFailoverClusterTimeout;
	}

	/**
	 * Sets the value of the sosFailoverClusterTimeout property.
	 * 
	 */
	public void setSosFailoverClusterTimeout(int value) {
		this.sosFailoverClusterTimeout = value;
	}

	/**
	 * Gets the value of the sosFailoverConnectionTimeout property.
	 * 
	 */
	public int getSosFailoverConnectionTimeout() {
		return sosFailoverConnectionTimeout;
	}

	/**
	 * Sets the value of the sosFailoverConnectionTimeout property.
	 * 
	 */
	public void setSosFailoverConnectionTimeout(int value) {
		this.sosFailoverConnectionTimeout = value;
	}

	/**
	 * Gets the value of the sosFailoverPingPeriod property.
	 * 
	 */
	public int getSosFailoverPingPeriod() {
		return sosFailoverPingPeriod;
	}

	/**
	 * Sets the value of the sosFailoverPingPeriod property.
	 * 
	 */
	public void setSosFailoverPingPeriod(int value) {
		this.sosFailoverPingPeriod = value;
	}

	/**
	 * Gets the value of the sublotQuantityConstraint property.
	 * 
	 */
	public int getSublotQuantityConstraint() {
		return sublotQuantityConstraint;
	}

	/**
	 * Sets the value of the sublotQuantityConstraint property.
	 * 
	 */
	public void setSublotQuantityConstraint(int value) {
		this.sublotQuantityConstraint = value;
	}

	/**
	 * Gets the value of the transactionLoggingLevel property.
	 * 
	 */
	public short getTransactionLoggingLevel() {
		return transactionLoggingLevel;
	}

	/**
	 * Sets the value of the transactionLoggingLevel property.
	 * 
	 */
	public void setTransactionLoggingLevel(short value) {
		this.transactionLoggingLevel = value;
	}

	/**
	 * Gets the value of the validateRowSizeLimitConfig property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getValidateRowSizeLimitConfig() {
		return validateRowSizeLimitConfig;
	}

	/**
	 * Sets the value of the validateRowSizeLimitConfig property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setValidateRowSizeLimitConfig(String value) {
		this.validateRowSizeLimitConfig = value;
	}

	/**
	 * Gets the value of the xfrBasePath property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXfrBasePath() {
		return xfrBasePath;
	}

	/**
	 * Sets the value of the xfrBasePath property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXfrBasePath(String value) {
		this.xfrBasePath = value;
	}

	/**
	 * Gets the value of the xfrDSMonitorEmail property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXfrDSMonitorEmail() {
		return xfrDSMonitorEmail;
	}

	/**
	 * Sets the value of the xfrDSMonitorEmail property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXfrDSMonitorEmail(String value) {
		this.xfrDSMonitorEmail = value;
	}

	/**
	 * Gets the value of the xfrFieldSepCmdLine property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXfrFieldSepCmdLine() {
		return xfrFieldSepCmdLine;
	}

	/**
	 * Sets the value of the xfrFieldSepCmdLine property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXfrFieldSepCmdLine(String value) {
		this.xfrFieldSepCmdLine = value;
	}

	/**
	 * Gets the value of the xfrFieldSepControlFile property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXfrFieldSepControlFile() {
		return xfrFieldSepControlFile;
	}

	/**
	 * Sets the value of the xfrFieldSepControlFile property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXfrFieldSepControlFile(String value) {
		this.xfrFieldSepControlFile = value;
	}

	/**
	 * Gets the value of the xfrFieldSepDataFile property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXfrFieldSepDataFile() {
		return xfrFieldSepDataFile;
	}

	/**
	 * Sets the value of the xfrFieldSepDataFile property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXfrFieldSepDataFile(String value) {
		this.xfrFieldSepDataFile = value;
	}

	/**
	 * Gets the value of the xfrLogLevel property.
	 * 
	 */
	public int getXfrLogLevel() {
		return xfrLogLevel;
	}

	/**
	 * Sets the value of the xfrLogLevel property.
	 * 
	 */
	public void setXfrLogLevel(int value) {
		this.xfrLogLevel = value;
	}

	/**
	 * Gets the value of the xfrMaxExtractInterval property.
	 * 
	 */
	public int getXfrMaxExtractInterval() {
		return xfrMaxExtractInterval;
	}

	/**
	 * Sets the value of the xfrMaxExtractInterval property.
	 * 
	 */
	public void setXfrMaxExtractInterval(int value) {
		this.xfrMaxExtractInterval = value;
	}

	/**
	 * Gets the value of the xfrMaxTableTimeout property.
	 * 
	 */
	public int getXfrMaxTableTimeout() {
		return xfrMaxTableTimeout;
	}

	/**
	 * Sets the value of the xfrMaxTableTimeout property.
	 * 
	 */
	public void setXfrMaxTableTimeout(int value) {
		this.xfrMaxTableTimeout = value;
	}

	/**
	 * Gets the value of the xfrPreProcess property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXfrPreProcess() {
		return xfrPreProcess;
	}

	/**
	 * Sets the value of the xfrPreProcess property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXfrPreProcess(String value) {
		this.xfrPreProcess = value;
	}

	/**
	 * Gets the value of the xfrRecSepCmdLine property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXfrRecSepCmdLine() {
		return xfrRecSepCmdLine;
	}

	/**
	 * Sets the value of the xfrRecSepCmdLine property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXfrRecSepCmdLine(String value) {
		this.xfrRecSepCmdLine = value;
	}

	/**
	 * Gets the value of the xfrRecSepControlFile property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXfrRecSepControlFile() {
		return xfrRecSepControlFile;
	}

	/**
	 * Sets the value of the xfrRecSepControlFile property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXfrRecSepControlFile(String value) {
		this.xfrRecSepControlFile = value;
	}

	/**
	 * Gets the value of the xfrRecSepDataFile property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXfrRecSepDataFile() {
		return xfrRecSepDataFile;
	}

	/**
	 * Sets the value of the xfrRecSepDataFile property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXfrRecSepDataFile(String value) {
		this.xfrRecSepDataFile = value;
	}

	/**
	 * Gets the value of the xfrSetDSMonitor property.
	 * 
	 */
	public int getXfrSetDSMonitor() {
		return xfrSetDSMonitor;
	}

	/**
	 * Sets the value of the xfrSetDSMonitor property.
	 * 
	 */
	public void setXfrSetDSMonitor(int value) {
		this.xfrSetDSMonitor = value;
	}

	/**
	 * Gets the value of the xfrUseFetchHint property.
	 * 
	 */
	public int getXfrUseFetchHint() {
		return xfrUseFetchHint;
	}

	/**
	 * Sets the value of the xfrUseFetchHint property.
	 * 
	 */
	public void setXfrUseFetchHint(int value) {
		this.xfrUseFetchHint = value;
	}

}
