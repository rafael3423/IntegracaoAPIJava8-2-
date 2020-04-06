
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="ClientReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GuestNationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Guests" type="{http://TekTravel/HotelBookingApi}ArrayOfGuest" minOccurs="0"/>
 *         &lt;element name="AddressInfo" type="{http://TekTravel/HotelBookingApi}AddressInfo" minOccurs="0"/>
 *         &lt;element name="PaymentInfo" type="{http://TekTravel/HotelBookingApi}PaymentInfo" minOccurs="0"/>
 *         &lt;element name="SessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FlightInfo" type="{http://TekTravel/HotelBookingApi}FlightInfo" minOccurs="0"/>
 *         &lt;element name="NoOfRooms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ResultIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelRooms" type="{http://TekTravel/HotelBookingApi}ArrayOfRequestedRooms" minOccurs="0"/>
 *         &lt;element name="SpecialRequests" type="{http://TekTravel/HotelBookingApi}ArrayOfSpecialRequest" minOccurs="0"/>
 *         &lt;element name="AgencyReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RestrictDuplicateBooking" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CheckInDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CheckOutDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
    "clientReferenceNumber",
    "guestNationality",
    "guests",
    "addressInfo",
    "paymentInfo",
    "sessionId",
    "flightInfo",
    "noOfRooms",
    "resultIndex",
    "hotelCode",
    "hotelName",
    "hotelRooms",
    "specialRequests",
    "agencyReferenceNumber",
    "restrictDuplicateBooking",
    "checkInDate",
    "checkOutDate"
})
@XmlRootElement(name = "HotelBookRequest")
public class HotelBookRequest {

    @XmlElement(name = "ClientReferenceNumber")
    protected String clientReferenceNumber;
    @XmlElement(name = "GuestNationality")
    protected String guestNationality;
    @XmlElement(name = "Guests")
    protected ArrayOfGuest guests;
    @XmlElement(name = "AddressInfo")
    protected AddressInfo addressInfo;
    @XmlElement(name = "PaymentInfo")
    protected PaymentInfo paymentInfo;
    @XmlElement(name = "SessionId")
    protected String sessionId;
    @XmlElement(name = "FlightInfo")
    protected FlightInfo flightInfo;
    @XmlElement(name = "NoOfRooms")
    protected int noOfRooms;
    @XmlElement(name = "ResultIndex")
    protected int resultIndex;
    @XmlElement(name = "HotelCode")
    protected String hotelCode;
    @XmlElement(name = "HotelName")
    protected String hotelName;
    @XmlElement(name = "HotelRooms")
    protected ArrayOfRequestedRooms hotelRooms;
    @XmlElement(name = "SpecialRequests")
    protected ArrayOfSpecialRequest specialRequests;
    @XmlElement(name = "AgencyReferenceNumber")
    protected String agencyReferenceNumber;
    @XmlElement(name = "RestrictDuplicateBooking")
    protected boolean restrictDuplicateBooking;
    @XmlElement(name = "CheckInDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkInDate;
    @XmlElement(name = "CheckOutDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkOutDate;

    /**
     * Obtém o valor da propriedade clientReferenceNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientReferenceNumber() {
        return clientReferenceNumber;
    }

    /**
     * Define o valor da propriedade clientReferenceNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientReferenceNumber(String value) {
        this.clientReferenceNumber = value;
    }

    /**
     * Obtém o valor da propriedade guestNationality.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuestNationality() {
        return guestNationality;
    }

    /**
     * Define o valor da propriedade guestNationality.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuestNationality(String value) {
        this.guestNationality = value;
    }

    /**
     * Obtém o valor da propriedade guests.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGuest }
     *     
     */
    public ArrayOfGuest getGuests() {
        return guests;
    }

    /**
     * Define o valor da propriedade guests.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGuest }
     *     
     */
    public void setGuests(ArrayOfGuest value) {
        this.guests = value;
    }

    /**
     * Obtém o valor da propriedade addressInfo.
     * 
     * @return
     *     possible object is
     *     {@link AddressInfo }
     *     
     */
    public AddressInfo getAddressInfo() {
        return addressInfo;
    }

    /**
     * Define o valor da propriedade addressInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressInfo }
     *     
     */
    public void setAddressInfo(AddressInfo value) {
        this.addressInfo = value;
    }

    /**
     * Obtém o valor da propriedade paymentInfo.
     * 
     * @return
     *     possible object is
     *     {@link PaymentInfo }
     *     
     */
    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    /**
     * Define o valor da propriedade paymentInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentInfo }
     *     
     */
    public void setPaymentInfo(PaymentInfo value) {
        this.paymentInfo = value;
    }

    /**
     * Obtém o valor da propriedade sessionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Define o valor da propriedade sessionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    /**
     * Obtém o valor da propriedade flightInfo.
     * 
     * @return
     *     possible object is
     *     {@link FlightInfo }
     *     
     */
    public FlightInfo getFlightInfo() {
        return flightInfo;
    }

    /**
     * Define o valor da propriedade flightInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link FlightInfo }
     *     
     */
    public void setFlightInfo(FlightInfo value) {
        this.flightInfo = value;
    }

    /**
     * Obtém o valor da propriedade noOfRooms.
     * 
     */
    public int getNoOfRooms() {
        return noOfRooms;
    }

    /**
     * Define o valor da propriedade noOfRooms.
     * 
     */
    public void setNoOfRooms(int value) {
        this.noOfRooms = value;
    }

    /**
     * Obtém o valor da propriedade resultIndex.
     * 
     */
    public int getResultIndex() {
        return resultIndex;
    }

    /**
     * Define o valor da propriedade resultIndex.
     * 
     */
    public void setResultIndex(int value) {
        this.resultIndex = value;
    }

    /**
     * Obtém o valor da propriedade hotelCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCode() {
        return hotelCode;
    }

    /**
     * Define o valor da propriedade hotelCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCode(String value) {
        this.hotelCode = value;
    }

    /**
     * Obtém o valor da propriedade hotelName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Define o valor da propriedade hotelName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelName(String value) {
        this.hotelName = value;
    }

    /**
     * Obtém o valor da propriedade hotelRooms.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRequestedRooms }
     *     
     */
    public ArrayOfRequestedRooms getHotelRooms() {
        return hotelRooms;
    }

    /**
     * Define o valor da propriedade hotelRooms.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRequestedRooms }
     *     
     */
    public void setHotelRooms(ArrayOfRequestedRooms value) {
        this.hotelRooms = value;
    }

    /**
     * Obtém o valor da propriedade specialRequests.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSpecialRequest }
     *     
     */
    public ArrayOfSpecialRequest getSpecialRequests() {
        return specialRequests;
    }

    /**
     * Define o valor da propriedade specialRequests.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSpecialRequest }
     *     
     */
    public void setSpecialRequests(ArrayOfSpecialRequest value) {
        this.specialRequests = value;
    }

    /**
     * Obtém o valor da propriedade agencyReferenceNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyReferenceNumber() {
        return agencyReferenceNumber;
    }

    /**
     * Define o valor da propriedade agencyReferenceNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyReferenceNumber(String value) {
        this.agencyReferenceNumber = value;
    }

    /**
     * Obtém o valor da propriedade restrictDuplicateBooking.
     * 
     */
    public boolean isRestrictDuplicateBooking() {
        return restrictDuplicateBooking;
    }

    /**
     * Define o valor da propriedade restrictDuplicateBooking.
     * 
     */
    public void setRestrictDuplicateBooking(boolean value) {
        this.restrictDuplicateBooking = value;
    }

    /**
     * Obtém o valor da propriedade checkInDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckInDate() {
        return checkInDate;
    }

    /**
     * Define o valor da propriedade checkInDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckInDate(XMLGregorianCalendar value) {
        this.checkInDate = value;
    }

    /**
     * Obtém o valor da propriedade checkOutDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Define o valor da propriedade checkOutDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckOutDate(XMLGregorianCalendar value) {
        this.checkOutDate = value;
    }

}
