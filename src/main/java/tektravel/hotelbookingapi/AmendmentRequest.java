
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Request" type="{http://TekTravel/HotelBookingApi}AmendmentRequestType" minOccurs="0"/>
 *         &lt;element name="BookingId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AmendInformation" type="{http://TekTravel/HotelBookingApi}AmendInformation" minOccurs="0"/>
 *         &lt;element name="ConfirmationNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "request",
    "bookingId",
    "amendInformation",
    "confirmationNo"
})
@XmlRootElement(name = "AmendmentRequest")
public class AmendmentRequest {

    @XmlElement(name = "Request")
    protected AmendmentRequestType request;
    @XmlElement(name = "BookingId")
    protected int bookingId;
    @XmlElement(name = "AmendInformation")
    protected AmendInformation amendInformation;
    @XmlElement(name = "ConfirmationNo")
    protected String confirmationNo;

    /**
     * Obtém o valor da propriedade request.
     * 
     * @return
     *     possible object is
     *     {@link AmendmentRequestType }
     *     
     */
    public AmendmentRequestType getRequest() {
        return request;
    }

    /**
     * Define o valor da propriedade request.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendmentRequestType }
     *     
     */
    public void setRequest(AmendmentRequestType value) {
        this.request = value;
    }

    /**
     * Obtém o valor da propriedade bookingId.
     * 
     */
    public int getBookingId() {
        return bookingId;
    }

    /**
     * Define o valor da propriedade bookingId.
     * 
     */
    public void setBookingId(int value) {
        this.bookingId = value;
    }

    /**
     * Obtém o valor da propriedade amendInformation.
     * 
     * @return
     *     possible object is
     *     {@link AmendInformation }
     *     
     */
    public AmendInformation getAmendInformation() {
        return amendInformation;
    }

    /**
     * Define o valor da propriedade amendInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendInformation }
     *     
     */
    public void setAmendInformation(AmendInformation value) {
        this.amendInformation = value;
    }

    /**
     * Obtém o valor da propriedade confirmationNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmationNo() {
        return confirmationNo;
    }

    /**
     * Define o valor da propriedade confirmationNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmationNo(String value) {
        this.confirmationNo = value;
    }

}
