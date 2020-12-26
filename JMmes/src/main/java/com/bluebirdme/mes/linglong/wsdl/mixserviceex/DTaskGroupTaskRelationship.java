package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTaskGroupTaskRelationship complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTaskGroupTaskRelationship">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="taskGroupKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="taskKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="taskOrder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="taskType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTaskGroupTaskRelationship", propOrder = { "taskGroupKey",
		"taskKey", "taskOrder", "taskType" })
public class DTaskGroupTaskRelationship extends DKeyed {

	protected long taskGroupKey;
	protected long taskKey;
	protected int taskOrder;
	protected short taskType;

	/**
	 * Gets the value of the taskGroupKey property.
	 * 
	 */
	public long getTaskGroupKey() {
		return taskGroupKey;
	}

	/**
	 * Sets the value of the taskGroupKey property.
	 * 
	 */
	public void setTaskGroupKey(long value) {
		this.taskGroupKey = value;
	}

	/**
	 * Gets the value of the taskKey property.
	 * 
	 */
	public long getTaskKey() {
		return taskKey;
	}

	/**
	 * Sets the value of the taskKey property.
	 * 
	 */
	public void setTaskKey(long value) {
		this.taskKey = value;
	}

	/**
	 * Gets the value of the taskOrder property.
	 * 
	 */
	public int getTaskOrder() {
		return taskOrder;
	}

	/**
	 * Sets the value of the taskOrder property.
	 * 
	 */
	public void setTaskOrder(int value) {
		this.taskOrder = value;
	}

	/**
	 * Gets the value of the taskType property.
	 * 
	 */
	public short getTaskType() {
		return taskType;
	}

	/**
	 * Sets the value of the taskType property.
	 * 
	 */
	public void setTaskType(short value) {
		this.taskType = value;
	}

}
