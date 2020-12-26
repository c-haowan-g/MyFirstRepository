package com.bluebirdme.mes.linglong.curing.entity;
/**
 * 查询所有换模计划
 * @author 赵怀浩
 * date:2018年12月25日 下午1:28:13
 */
public class MoldChangePlanAll extends MoldChangePlan {

	/**
	 * 胶囊
	 */
	private String capsule;
	public String getCapsuler() {
		return capsuler;
	}

	public void setCapsuler(String capsuler) {
		this.capsuler = capsuler;
	}

	private String capsuler;
	/**
	 * 色标线
	 */
	private String lineColor;
	private String lineColorr;

	public String getLineColorr() {
		return lineColorr;
	}

	public void setLineColorr(String lineColorr) {
		this.lineColorr = lineColorr;
	}

	public String getCapsule() {
		return capsule;
	}

	public void setCapsule(String capsule) {
		this.capsule = capsule;
	}

	public String getLineColor() {
		return lineColor;
	}

	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}
}
