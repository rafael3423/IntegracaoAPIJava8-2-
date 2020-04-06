
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de BookingsBasedOnDate complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="BookingsBasedOnDate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BookingId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConfirmationNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BookingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AgentMarkup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AgencyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BookingStatus" type="{http://TekTravel/HotelBookingApi}APIHotelBookingStatus"/>
 *         &lt;element name="BookingPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TripName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TBOHotelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BookingsBasedOnDate", propOrder = {
    "index",
    "bookingId",
    "confirmationNo",
    "bookingDate",
    "currency",
    "agentMarkup",
    "agencyName",
    "bookingStatus",
    "bookingPrice",
    "tripName",
    "tboHotelCode",
    "remarks"
})
public class BookingsBasedOnDate {

    @XmlElement(name = "Index")
    protected int index;
    @XmlElement(name = "BookingId")
    protected String bookingId;
    @XmlElement(name = "ConfirmationNo")
    protected String confirmationNo;
    @XmlElement(name = "BookingDate")
    protected String bookingDate;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "AgentMarkup")
    protected String agentMarkup;
    @XmlElement(name = "AgencyName")
    protected String agencyName;
    @XmlElement(name = "BookingStatus", required = true)
    protected APIHotelBookingStatus bookingStatus;
    @XmlElement(name = "BookingPrice")
    protected String bookingPrice;
    @XmlElement(name = "TripName")
    protected String tripName;
    @XmlElement(name = "TBOHotelCode")
    protected String tboHotelCode;
    @XmlElement(name = "Remarks")
    protected String remarks;

    /**
     * Obtém o valor da propriedade index.
     * 
     */
    public int getIndex() {
        return index;
    }

    /**
     * Define o valor da propriedade index.
     * 
     */
    public void setIndex(int value) {
        this.index = value;
    }

    /**
     * Obtém o valor da propriedade bookingId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Define o valor da propriedade bookingId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingId(String value) {
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
     * Obtém o valor da propriedade bookingDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingDate() {
        return bookingDate;
    }

    /**
     * Define o valor da propriedade bookingDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingDate(String value) {
        this.bookingDate = value;
    }

    /**
     * Obtém o valor da propriedade currency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Define o valor da propriedade currency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Obtém o valor da propriedade agentMarkup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentMarkup() {
        return agentMarkup;
    }

    /**
     * Define o valor da propriedade agentMarkup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentMarkup(String value) {
        this.agentMarkup = value;
    }

    /**
     * Obtém o valor da propriedade agencyName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyName() {
        return agencyName;
    }

    /**
     * Define o valor da propriedade agencyName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyName(String value) {
        this.agencyName = value;
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
     * Obtém o valor da propriedade bookingPrice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingPrice() {
        return bookingPrice;
    }

    /**
     * Define o valor da propriedade bookingPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingPrice(String value) {
        this.bookingPrice = value;
    }

    /**
     * Obtém o valor da propriedade tripName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripName() {
        return tripName;
    }

    /**
     * Define o valor da propriedade tripName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripName(String value) {
        this.tripName = value;
    }

    /**
     * Obtém o valor da propriedade tboHotelCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTBOHotelCode() {
        return tboHotelCode;
    }

    /**
     * Define o valor da propriedade tboHotelCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTBOHotelCode(String value) {
        this.tboHotelCode = value;
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

}
