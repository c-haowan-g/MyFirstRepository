/**
 * 
 */
package com.test;

/**
 * @author Administrator
 * Float ֵ����
 */
public class FloatValue {
	private Float value;

	/**
	 * ��ȡֵ
	 * @return the value
	 */
	public Float getValue() {
		return value;
	}

	/**
	 * ����ֵ
	 * @param value the value to set
	 */
	public void setValue(Float value) {
		this.value = value;
	}
	
	/**
	 * �Ƿ�����ɹ�
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * �Ƿ�����ɹ�
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * �����쳣��Ϣ
	 * @return the exceptionMessage
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * �����쳣��Ϣ
	 * @param exceptionMessage the exceptionMessage to set
	 */
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	private boolean success;
	
	private String exceptionMessage;
}