package com.bluebirdme.mes.linglong.halfpart.entity;

import com.bluebird.common.StringHelper;

public class Stockmap {

	String s_imgsrc = "resources/images/car.png";
	String s_redimgsrc = "resources/images/redcar.png";

	public String geth(StockMapAll data) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("<div>");
		stringBuffer.append("<svg width=\"" + data.s_width + "\" height=\""
				+ data.s_height + "\" xmlns=\"" + data.s_xmlns
				+ "\"  xmlns:xlink=\"http://www.w3.org/1999/xlink\" >");
		if (!StringHelper.isNullOrEmpty(data.s_backcolor)) {
			stringBuffer.append("<rect fill=\"" + data.s_backcolor
					+ "\"  height=\"" + data.s_height + "\" width=\""
					+ data.s_width + "\"  />");
		}
		stringBuffer
				.append("<text xml:space=\"preserve\" text-anchor=\"start\" font-family=\"'Times New Roman', Times, serif\" font-size=\"12\"  y=\"20\" x=\"10\" stroke-width=\"0\" stroke=\"#000\" fill=\"#000000\">"
						+ data.getS_storeloc() + "</text>");
		stringBuffer
				.append("<text xml:space=\"preserve\" text-anchor=\"start\" font-family=\"'Times New Roman', Times, serif\" font-size=\"12\"  y=\"35\" x=\"10\" stroke-width=\"0\" stroke=\"#000\" fill=\"#000000\">"
						+ data.getS_storespec() + "</text>");
		stringBuffer
				.append("<text xml:space=\"preserve\" text-anchor=\"start\" font-family=\"'Times New Roman', Times, serif\" font-size=\"12\"  y=\"50\" x=\"10\" stroke-width=\"0\" stroke=\"#000\" fill=\"#000000\">"
						+ data.getS_storecarnum() + "</text>");
		if ((data.getCarsList() != null) && (data.getCarsList().size() > 0)) {
			for (int i = 0; i < data.getCarsList().size(); i++) {
				stringBuffer.append(" <g>");
				stringBuffer.append("<title>批次号"
						+ ((Carinfo) data.getCarsList().get(i)).batchno
						+ "</title>");
				if (!((Carinfo) data.getCarsList().get(i)).isoverdue
						.booleanValue()) {
					stringBuffer
							.append("<image id=\""
									+ i
									+ "\" xlink:href=\""
									+ this.s_imgsrc
									+ "\" x=\""
									+ (150 + i * data.s_imgdispaygap)
									+ "\" y=\"30\" height=\"30\" width=\"40\"  onclick=\"alert('批次号:"
									+ ((Carinfo) data.getCarsList().get(i)).batchno
									+ ",停放时间:"
									+ ((Carinfo) data.getCarsList().get(i)).waittime
									+ "小时')\"/> ");
				} else {
					stringBuffer
							.append("<image id=\""
									+ i
									+ "\" xlink:href=\""
									+ this.s_redimgsrc
									+ "\" x=\""
									+ (150 + i * data.s_imgdispaygap)
									+ "\" y=\"30\" height=\"30\" width=\"40\"  onclick=\"alert('"
									+ ((Carinfo) data.getCarsList().get(i)).batchno
									+ "')\"/> ");
				}
				stringBuffer.append(" </g>");
				if (!((Carinfo) data.getCarsList().get(i)).isoverdue
						.booleanValue()) {
					stringBuffer
							.append("<text xml:space=\"preserve\" text-anchor=\"start\" font-family=\"'Times New Roman', Times, serif\" font-size=\"12\"  y=\"10\" x=\""
									+ (150 + i * data.s_imgdispaygap)
									+ "\" stroke-width=\"0\" stroke=\"#000\" fill=\"#000000\">"
									+ ((Carinfo) data.getCarsList().get(i)).promachine
									+ ","
									+ ((Carinfo) data.getCarsList().get(i)).proworker
									+ "</text>");
					stringBuffer
							.append("<text xml:space=\"preserve\" text-anchor=\"start\" font-family=\"'Times New Roman', Times, serif\" font-size=\"12\"  y=\"20\" x=\""
									+ (150 + i * data.s_imgdispaygap)
									+ "\" stroke-width=\"0\" stroke=\"#000\" fill=\"#000000\">"
									+ ((Carinfo) data.getCarsList().get(i)).waittime
									+ ","
									+ ((Carinfo) data.getCarsList().get(i)).pronumber
									+ "</text>");
				} else {
					stringBuffer
							.append("<text font-weight=\"bold\" xml:space=\"preserve\" text-anchor=\"start\" font-family=\"'Times New Roman', Times, serif\" font-size=\"12\"  y=\"10\" x=\""
									+ (150 + i * data.s_imgdispaygap)
									+ "\" stroke-width=\"0\" stroke=\"#000\" fill=\"#bf0000\">"
									+ ((Carinfo) data.getCarsList().get(i)).promachine
									+ ","
									+ ((Carinfo) data.getCarsList().get(i)).proworker
									+ "</text>");
					stringBuffer
							.append("<text font-weight=\"bold\" xml:space=\"preserve\" text-anchor=\"start\" font-family=\"'Times New Roman', Times, serif\" font-size=\"12\"  y=\"20\" x=\""
									+ (150 + i * data.s_imgdispaygap)
									+ "\" stroke-width=\"0\" stroke=\"#000\" fill=\"#bf0000\">"
									+ ((Carinfo) data.getCarsList().get(i)).waittime
									+ ","
									+ ((Carinfo) data.getCarsList().get(i)).pronumber
									+ "</text>");
				}
			}
		}
		stringBuffer.append("<line id=\"a\" y2=\"60\" x2=\"150\" y1=\""
				+ data.s_height + "\" x1=\"" + data.s_width
				+ "\" stroke-width=\"2.5\" stroke=\"#000\" fill=\"none\"/>");

		stringBuffer.append("");
		stringBuffer.append("</>");
		stringBuffer.append("</div>");
		return stringBuffer.toString();
	}
}
