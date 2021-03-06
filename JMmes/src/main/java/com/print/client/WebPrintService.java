
package com.print.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebPrintService", targetNamespace = "http://webservice.print.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebPrintService {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.print.client.PrintResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "printInvoke", targetNamespace = "http://webservice.print.com/", className = "com.print.client.PrintInvoke")
    @ResponseWrapper(localName = "printInvokeResponse", targetNamespace = "http://webservice.print.com/", className = "com.print.client.PrintInvokeResponse")
    public PrintResponse printInvoke(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

}
