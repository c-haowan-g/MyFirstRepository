package com.lhqx;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * <p>
 * An example of how this class may be used:
 * 
 * <pre>
 * WSImplement service = new WSImplement();
 * WSInterface portType = service.getBasicHttpBindingWSInterface();
 * portType.queryRealData(...);
 * </pre>
 * 
 * </p>
 * 
 */
@WebServiceClient(name = "WSImplement", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://172.19.145.23:9999/PIDataRequest?wsdl")
public class WSImplement extends Service {

	private final static URL WSIMPLEMENT_WSDL_LOCATION;
	private final static Logger logger = Logger.getLogger(com.lhqx.WSImplement.class
			.getName());

	static {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = com.lhqx.WSImplement.class.getResource(".");
			url = new URL(baseUrl,
					"http://172.19.145.23:9999/PIDataRequest?wsdl");
		} catch (MalformedURLException e) {
			logger.warning("Failed to create URL for the wsdl Location: 'http://172.19.145.23:9999/PIDataRequest?wsdl', retrying as a local file");
			logger.warning(e.getMessage());
		}
		WSIMPLEMENT_WSDL_LOCATION = url;
	}

	public WSImplement(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public WSImplement() {
		super(WSIMPLEMENT_WSDL_LOCATION, new QName("http://tempuri.org/",
				"WSImplement"));
	}

	/**
	 * 
	 * @return returns WSInterface
	 */
	@WebEndpoint(name = "BasicHttpBinding_WSInterface")
	public WSInterface getBasicHttpBindingWSInterface() {
		return super.getPort(new QName("http://tempuri.org/",
				"BasicHttpBinding_WSInterface"), WSInterface.class);
	}

}