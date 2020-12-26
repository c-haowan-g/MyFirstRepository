package com.print.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WebPrintServiceService", targetNamespace = "http://webservice.print.com/", wsdlLocation = "http://192.168.169.44:8085/webPrintService?wsdl")
public class WebPrintServiceService extends Service {

	private static URL WEBPRINTSERVICESERVICE_WSDL_LOCATION;
	private final static WebServiceException WEBPRINTSERVICESERVICE_EXCEPTION;
	private final static QName WEBPRINTSERVICESERVICE_QNAME = new QName(
			"http://webservice.print.com/", "WebPrintServiceService");

	static {
		URL url = null;
		WebServiceException e = null;
		String sosurl = null;
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext
				.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
		try {
			sosurl = exportCombox.getDictname("309001");

			// http://192.168.169.44:8085/webPrintService?wsdl
			// http://192.168.2.117:10006/PrintWebService?wsdl
			url = new URL(sosurl);
		} catch (Exception ex) {
			e = new WebServiceException(ex);
		}
		System.out.println(sosurl);
		WEBPRINTSERVICESERVICE_WSDL_LOCATION = url;
		WEBPRINTSERVICESERVICE_EXCEPTION = e;
	}

	public WebPrintServiceService() {
		super(__getWsdlLocation(), WEBPRINTSERVICESERVICE_QNAME);
	}

	public WebPrintServiceService(WebServiceFeature... features) {
		super(__getWsdlLocation(), WEBPRINTSERVICESERVICE_QNAME, features);
	}

	public WebPrintServiceService(URL wsdlLocation) {
		super(wsdlLocation, WEBPRINTSERVICESERVICE_QNAME);
	}

	public WebPrintServiceService(URL wsdlLocation,
			WebServiceFeature... features) {
		super(wsdlLocation, WEBPRINTSERVICESERVICE_QNAME, features);
	}

	public WebPrintServiceService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public WebPrintServiceService(URL wsdlLocation, QName serviceName,
			WebServiceFeature... features) {
		super(wsdlLocation, serviceName, features);
	}

	/**
	 * 
	 * @return returns WebPrintService
	 */
	@WebEndpoint(name = "WebPrintServicePort")
	public WebPrintService getWebPrintServicePort() {
		return super.getPort(new QName("http://webservice.print.com/",
				"WebPrintServicePort"), WebPrintService.class);
	}

	/**
	 * 
	 * @param features
	 *            A list of {@link javax.xml.ws.WebServiceFeature} to configure
	 *            on the proxy. Supported features not in the
	 *            <code>features</code> parameter will have their default
	 *            values.
	 * @return returns WebPrintService
	 */
	@WebEndpoint(name = "WebPrintServicePort")
	public WebPrintService getWebPrintServicePort(WebServiceFeature... features) {
		return super.getPort(new QName("http://webservice.print.com/",
				"WebPrintServicePort"), WebPrintService.class, features);
	}

	private static URL __getWsdlLocation() {
		if (WEBPRINTSERVICESERVICE_EXCEPTION != null) {
			throw WEBPRINTSERVICESERVICE_EXCEPTION;
		}
		String sosurl = null;
		URL url = null;
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext
				.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
		try {
			sosurl = exportCombox.getDictname("309001");
			url = new URL(sosurl);
			WEBPRINTSERVICESERVICE_WSDL_LOCATION = url;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return WEBPRINTSERVICESERVICE_WSDL_LOCATION;
	}

}