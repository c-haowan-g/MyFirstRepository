
package com.print.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.print.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PrintInvoke_QNAME = new QName("http://webservice.print.com/", "printInvoke");
    private final static QName _PrintInvokeResponse_QNAME = new QName("http://webservice.print.com/", "printInvokeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.print.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PrintInvokeResponse }
     * 
     */
    public PrintInvokeResponse createPrintInvokeResponse() {
        return new PrintInvokeResponse();
    }

    /**
     * Create an instance of {@link PrintInvoke }
     * 
     */
    public PrintInvoke createPrintInvoke() {
        return new PrintInvoke();
    }

    /**
     * Create an instance of {@link PrintResponse }
     * 
     */
    public PrintResponse createPrintResponse() {
        return new PrintResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintInvoke }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.print.com/", name = "printInvoke")
    public JAXBElement<PrintInvoke> createPrintInvoke(PrintInvoke value) {
        return new JAXBElement<PrintInvoke>(_PrintInvoke_QNAME, PrintInvoke.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintInvokeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.print.com/", name = "printInvokeResponse")
    public JAXBElement<PrintInvokeResponse> createPrintInvokeResponse(PrintInvokeResponse value) {
        return new JAXBElement<PrintInvokeResponse>(_PrintInvokeResponse_QNAME, PrintInvokeResponse.class, null, value);
    }

}
