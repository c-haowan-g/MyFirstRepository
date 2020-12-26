package com.lhqx;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * 
 */
@WebService(name = "WSInterface", targetNamespace = "http://tempuri.org/")
public interface WSInterface {

	/**
	 * 
	 * @param endtime
	 * @param point
	 * @param machineid
	 * @param fromtime
	 * @return returns lh.PIReturnObject
	 */
	@WebMethod(operationName = "QueryRealData", action = "http://tempuri.org/WSInterface/QueryRealData")
	@WebResult(name = "QueryRealDataResult", targetNamespace = "http://tempuri.org/")
	@RequestWrapper(localName = "QueryRealData", targetNamespace = "http://tempuri.org/", className = "lh.QueryRealData")
	@ResponseWrapper(localName = "QueryRealDataResponse", targetNamespace = "http://tempuri.org/", className = "lh.QueryRealDataResponse")
	public PIReturnObject queryRealData(
			@WebParam(name = "machineid", targetNamespace = "http://tempuri.org/") String machineid,
			@WebParam(name = "point", targetNamespace = "http://tempuri.org/") String point,
			@WebParam(name = "fromtime", targetNamespace = "http://tempuri.org/") String fromtime,
			@WebParam(name = "endtime", targetNamespace = "http://tempuri.org/") String endtime);

	/**
	 * 
	 * @param endtime
	 * @param point
	 * @param machineid
	 * @param fromtime
	 * @return returns lh.PIReturnObject
	 */
	@WebMethod(operationName = "QueryRealData1", action = "http://tempuri.org/WSInterface/QueryRealData")
	@WebResult(name = "QueryRealDataResult", targetNamespace = "http://tempuri.org/")
	@RequestWrapper(localName = "QueryRealData", targetNamespace = "http://tempuri.org/", className = "lh.QueryRealData")
	@ResponseWrapper(localName = "QueryRealDataResponse", targetNamespace = "http://tempuri.org/", className = "lh.QueryRealDataResponse")
	public PIReturnObject queryRealData1(
			@WebParam(name = "machineid", targetNamespace = "http://tempuri.org/") String machineid,
			@WebParam(name = "point", targetNamespace = "http://tempuri.org/") String point,
			@WebParam(name = "fromtime", targetNamespace = "http://tempuri.org/") String fromtime,
			@WebParam(name = "endtime", targetNamespace = "http://tempuri.org/") String endtime);
}
