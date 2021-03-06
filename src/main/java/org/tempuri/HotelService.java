
package org.tempuri;

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
 * JAX-WS RI 2.2.6b21 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HotelService", targetNamespace = "http://tempuri.org/", wsdlLocation = "file:/home/rafael/NetBeansProjects/it-tboholiday/src/main/resources/br/com/infotera/it/tboholiday/wsdl/HotelService.wsdl")
public class HotelService
    extends Service
{

    private final static URL HOTELSERVICE_WSDL_LOCATION;
    private final static WebServiceException HOTELSERVICE_EXCEPTION;
    private final static QName HOTELSERVICE_QNAME = new QName("http://tempuri.org/", "HotelService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/home/rafael/NetBeansProjects/it-tboholiday/src/main/resources/br/com/infotera/it/tboholiday/wsdl/HotelService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HOTELSERVICE_WSDL_LOCATION = url;
        HOTELSERVICE_EXCEPTION = e;
    }

    public HotelService() {
        super(__getWsdlLocation(), HOTELSERVICE_QNAME);
    }

    public HotelService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HOTELSERVICE_QNAME, features);
    }

    public HotelService(URL wsdlLocation) {
        super(wsdlLocation, HOTELSERVICE_QNAME);
    }

    public HotelService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HOTELSERVICE_QNAME, features);
    }

    public HotelService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HotelService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IHotelService
     */
    @WebEndpoint(name = "WSHttpBinding_IHotelService")
    public IHotelService getWSHttpBindingIHotelService() {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_IHotelService"), IHotelService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IHotelService
     */
    @WebEndpoint(name = "WSHttpBinding_IHotelService")
    public IHotelService getWSHttpBindingIHotelService(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_IHotelService"), IHotelService.class, features);
    }

    /**
     * 
     * @return
     *     returns IHotelService
     */
    @WebEndpoint(name = "WSHttpBinding_IHotelService1")
    public IHotelService getWSHttpBindingIHotelService1() {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_IHotelService1"), IHotelService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IHotelService
     */
    @WebEndpoint(name = "WSHttpBinding_IHotelService1")
    public IHotelService getWSHttpBindingIHotelService1(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_IHotelService1"), IHotelService.class, features);
    }

    /**
     * 
     * @return
     *     returns IHotelService
     */
    @WebEndpoint(name = "BasicHttpBinding_IHotelService")
    public IHotelService getBasicHttpBindingIHotelService() {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IHotelService"), IHotelService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IHotelService
     */
    @WebEndpoint(name = "BasicHttpBinding_IHotelService")
    public IHotelService getBasicHttpBindingIHotelService(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IHotelService"), IHotelService.class, features);
    }

    /**
     * 
     * @return
     *     returns IHotelService
     */
    @WebEndpoint(name = "BasicHttpBinding_IHotelService1")
    public IHotelService getBasicHttpBindingIHotelService1() {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IHotelService1"), IHotelService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IHotelService
     */
    @WebEndpoint(name = "BasicHttpBinding_IHotelService1")
    public IHotelService getBasicHttpBindingIHotelService1(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IHotelService1"), IHotelService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HOTELSERVICE_EXCEPTION!= null) {
            throw HOTELSERVICE_EXCEPTION;
        }
        return HOTELSERVICE_WSDL_LOCATION;
    }

}
