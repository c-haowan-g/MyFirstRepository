
package com.bglhqx;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSImplement", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://172.19.145.30:9999/PIDataRequest?wsdl")
public class WSImplement
    extends Service
{

    private final static URL WSIMPLEMENT_WSDL_LOCATION;
    private final static WebServiceException WSIMPLEMENT_EXCEPTION;
    private final static QName WSIMPLEMENT_QNAME = new QName("http://tempuri.org/", "WSImplement");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://172.19.145.30:9999/PIDataRequest?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSIMPLEMENT_WSDL_LOCATION = url;
        WSIMPLEMENT_EXCEPTION = e;
    }

    public WSImplement() {
        super(__getWsdlLocation(), WSIMPLEMENT_QNAME);
    }

    public WSImplement(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSIMPLEMENT_QNAME, features);
    }

    public WSImplement(URL wsdlLocation) {
        super(wsdlLocation, WSIMPLEMENT_QNAME);
    }

    public WSImplement(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSIMPLEMENT_QNAME, features);
    }

    public WSImplement(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSImplement(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSInterface
     */
    @WebEndpoint(name = "BasicHttpBinding_WSInterface")
    public WSInterface getBasicHttpBindingWSInterface() {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_WSInterface"), WSInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSInterface
     */
    @WebEndpoint(name = "BasicHttpBinding_WSInterface")
    public WSInterface getBasicHttpBindingWSInterface(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_WSInterface"), WSInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSIMPLEMENT_EXCEPTION!= null) {
            throw WSIMPLEMENT_EXCEPTION;
        }
        return WSIMPLEMENT_WSDL_LOCATION;
    }

}
