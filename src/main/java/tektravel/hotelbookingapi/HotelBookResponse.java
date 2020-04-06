
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
 *         &lt;element name="Status" type="{http://TekTravel/HotelBookingApi}ResponseStatus" minOccurs="0"/>
 *         &lt;element name="BookingStatus" type="{http://TekTravel/HotelBookingApi}APIHotelBookingStatus"/>
 *         &lt;element name="BookingId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ConfirmationNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TripId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SupplierReferenceNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PriceChange" type="{http://TekTravel/HotelBookingApi}PriceChangeStatus" minOccurs="0"/>
 *         &lt;element name="SupplierConfirmationNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "status",
    "bookingStatus",
    "bookingId",
    "confirmationNo",
    "tripId",
    "supplierReferenceNo",
    "priceChange",
    "supplierConfirmationNo"
})
@XmlRootElement(name = "HotelBookResponse")
public class HotelBookResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "BookingStatus", required = true)
    protected APIHotelBookingStatus bookingStatus;
    @XmlElement(name = "BookingId")
    protected int bookingId;
    @XmlElement(name = "ConfirmationNo")
    protected String confirmationNo;
    @XmlElement(name = "TripId")
    protected int tripId;
    @XmlElement(name = "SupplierReferenceNo")
    protected String supplierReferenceNo;
    @XmlElement(name = "PriceChange")
    protected PriceChangeStatus priceChange;
    @XmlElement(name = "SupplierConfirmationNo")
    protected String supplierConfirmationNo;

    /**
     * Obtém o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link ResponseStatus }
     *     
     */
    public ResponseStatus getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseStatus }
     *     
     */
    public void setStatus(ResponseStatus value) {
        this.status = value;
    }

    /**
     * Obtém o valor da propriedade bookingStatus.
     * 
     * @return
     *     possible object is
     *     {@link APIHotelBookingStatus }
     *     
     */
    public APIHotelBookingStatus getBookingStatus() {
        return bookingStatus;
    }

    /**
     * Define o valor da propriedade bookingStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link APIHotelBookingStatus }
     *     
     */
    public void setBookingStatus(APIHotelBookingStatus value) {
        this.bookingStatus = value;
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

    /**
     * Obtém o valor da propriedade tripId.
     * 
     */
    public int getTripId() {
        return tripId;
    }

    /**
     * Define o valor da propriedade tripId.
     * 
     */
    public void setTripId(int value) {
        this.tripId = value;
    }

    /**
     * Obtém o valor da propriedade supplierReferenceNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierReferenceNo() {
        return supplierReferenceNo;
    }

    /**
     * Define o valor da propriedade supplierReferenceNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierReferenceNo(String value) {
        this.supplierReferenceNo = value;
    }

    /**
     * Obtém o valor da propriedade priceChange.
     * 
     * @return
     *     possible object is
     *     {@link PriceChangeStatus }
     *     
     */
    public PriceChangeStatus getPriceChange() {
        return priceChange;
    }

    /**
     * Define o valor da propriedade priceChange.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceChangeStatus }
     *     
     */
    public void setPriceChange(PriceChangeStatus value) {
        this.priceChange = value;
    }

    /**
     * Obtém o valor da propriedade supplierConfirmationNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierConfirmationNo() {
        return supplierConfirmationNo;
    }

    /**
     * Define o valor da propriedade supplierConfirmationNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierConfirmationNo(String value) {
        this.supplierConfirmationNo = value;
    }

}
