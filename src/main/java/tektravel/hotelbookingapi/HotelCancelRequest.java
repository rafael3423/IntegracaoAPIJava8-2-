
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
 *         &lt;element name="BookingId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RequestType" type="{http://TekTravel/HotelBookingApi}CancelRequestType"/>
 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "bookingId",
    "requestType",
    "remarks",
    "confirmationNo"
})
@XmlRootElement(name = "HotelCancelRequest")
public class HotelCancelRequest {

    @XmlElement(name = "BookingId")
    protected int bookingId;
    @XmlElement(name = "RequestType", required = true)
    protected CancelRequestType requestType;
    @XmlElement(name = "Remarks")
    protected String remarks;
    @XmlElement(name = "ConfirmationNo")
    protected String confirmationNo;

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
     * Obtém o valor da propriedade requestType.
     * 
     * @return
     *     possible object is
     *     {@link CancelRequestType }
     *     
     */
    public CancelRequestType getRequestType() {
        return requestType;
    }

    /**
     * Define o valor da propriedade requestType.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelRequestType }
     *     
     */
    public void setRequestType(CancelRequestType value) {
        this.requestType = value;
    }

    /**
     * Obtém o valor da propriedade remarks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Define o valor da propriedade remarks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
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
