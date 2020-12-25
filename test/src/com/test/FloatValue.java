/**
 * 
 */
package com.test;

/**
 * @author Administrator
 * Float 值解析
 */
public class FloatValue {
	private Float value;

	/**
	 * 获取值
	 * @return the value
	 */
	public Float getValue() {
		return value;
	}

	/**
	 * 设置值
	 * @param value the value to set
	 */
	public void setValue(Float value) {
		this.value = value;
	}
	
	/**
	 * 是否解析成功
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * 是否解析成功
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * 解析异常信息
	 * @return the exceptionMessage
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * 解析异常信息
	 * @param exceptionMessage the exceptionMessage to set
	 */
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	private boolean success;
	
	private String exceptionMessage;
}