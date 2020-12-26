package com.bluebirdme.mes.linglong.halfpart.entity;

import java.util.ArrayList;

public class StockMapAll {

	// 库位名称
	private String s_storeloc;
	// 物料名称
	private String s_storespec;
	private ArrayList<Carinfo> carsList;
	public int s_width = 1400;
	public int s_height = 60;
	public String s_xmlns = "http://www.w3.org/2000/svg";
	public String s_imgsrc = "/car.png";
	public int s_imgdispaygap = 70;
	private int s_storecarnum = 0;
	public boolean s_storefirstout = false;
	public String s_backcolor = "";

	public int getS_storecarnum() {
		return this.s_storecarnum;
	}

	public void setS_storecarnum(int s_storecarnum) {
		this.s_storecarnum = s_storecarnum;
	}

	public String getS_storeloc() {
		return this.s_storeloc;
	}

	public void setS_storeloc(String s_storeloc) {
		this.s_storeloc = s_storeloc;
	}

	public String getS_storespec() {
		return this.s_storespec;
	}

	public void setS_storespec(String s_storespec) {
		this.s_storespec = s_storespec;
	}

	public ArrayList<Carinfo> getCarsList() {
		return this.carsList;
	}

	public void setCarsList(ArrayList<Carinfo> carsList) {
		this.carsList = carsList;
	}
}
