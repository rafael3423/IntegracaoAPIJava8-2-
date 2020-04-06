
package tektravel.hotelbookingapi;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de APIBookingDetail complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="APIBookingDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Rating" type="{http://TekTravel/HotelBookingApi}HotelInfoHotelRating"/>
 *         &lt;element name="AddressLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Map" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CheckInDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="CheckOutDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="BookingDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="HotelCancelPolicies" type="{http://TekTravel/HotelBookingApi}CancelPolicies" minOccurs="0"/>
 *         &lt;element name="HotelPolicyDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FlightInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecialRequest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Roomtype" type="{http://TekTravel/HotelBookingApi}ArrayOfRoomDetails" minOccurs="0"/>
 *         &lt;element name="AmendmentDetails" type="{http://TekTravel/HotelBookingApi}AmendmentDetails" minOccurs="0"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NoOfRooms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AgencyDetails" type="{http://TekTravel/HotelBookingApi}AgencyDetails" minOccurs="0"/>
 *         &lt;element name="AOTNumbers" type="{http://TekTravel/HotelBookingApi}AOTNumbers" minOccurs="0"/>
 *         &lt;element name="CityId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TripName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TBOHotelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentCancellationCharges" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AppliedCancellationCharges" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="BookingId" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="AmendmentStatus" use="required" type="{http://TekTravel/HotelBookingApi}RequestStatus" />
 *       &lt;attribute name="BookingStatus" use="required" type="{http://TekTravel/HotelBookingApi}APIHotelBookingStatus" />
 *       &lt;attribute name="VoucherStatus" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="InvoiceNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SupplierReferenceNo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ConfirmationNo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HotelConfirmationNo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APIBookingDetail", propOrder = {
    "hotelName",
    "rating",
    "addressLine1",
    "addressLine2",
    "map",
    "city",
    "checkInDate",
    "checkOutDate",
    "bookingDate",
    "hotelCancelPolicies",
    "hotelPolicyDetails",
    "flightInfo",
    "specialRequest",
    "roomtype",
    "amendmentDetails",
    "currency",
    "noOfRooms",
    "agencyDetails",
    "aotNumbers",
    "cityId",
    "tripName",
    "tboHotelCode",
    "currentCancellationCharges",
    "appliedCancellationCharges"
})
public class APIBookingDetail {

    @XmlElement(name = "HotelName")
    protected String hotelName;
    @XmlElement(name = "Rating", required = true)
    protected HotelInfoHotelRating rating;
    @XmlElement(name = "AddressLine1")
    protected String addressLine1;
    @XmlElement(name = "AddressLine2")
    protected String addressLine2;
    @XmlElement(name = "Map")
    protected String map;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "CheckInDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar checkInDate;
    @XmlElement(name = "CheckOutDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar checkOutDate;
    @XmlElement(name = "BookingDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar bookingDate;
    @XmlElement(name = "HotelCancelPolicies")
    protected CancelPolicies hotelCancelPolicies;
    @XmlElement(name = "HotelPolicyDetails")
    protected String hotelPolicyDetails;
    @XmlElement(name = "FlightInfo")
    protected String flightInfo;
    @XmlElement(name = "SpecialRequest")
    protected String specialRequest;
    @XmlElement(name = "Roomtype")
    protected ArrayOfRoomDetails roomtype;
    @XmlElement(name = "AmendmentDetails")
    protected AmendmentDetails amendmentDetails;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "NoOfRooms")
    protected int noOfRooms;
    @XmlElement(name = "AgencyDetails")
    protected AgencyDetails agencyDetails;
    @XmlElement(name = "AOTNumbers")
    protected AOTNumbers aotNumbers;
    @XmlElement(name = "CityId")
    protected int cityId;
    @XmlElement(name = "TripName")
    protected String tripName;
    @XmlElement(name = "TBOHotelCode")
    protected String tboHotelCode;
    @XmlElement(name = "CurrentCancellationCharges")
    protected BigDecimal currentCancellationCharges;
    @XmlElement(name = "AppliedCancellationCharges")
    protected BigDecimal appliedCancellationCharges;
    @XmlAttribute(name = "BookingId", required = true)
    protected int bookingId;
    @XmlAttribute(name = "AmendmentStatus", required = true)
    protected RequestStatus amendmentStatus;
    @XmlAttribute(name = "BookingStatus", required = true)
    protected APIHotelBookingStatus bookingStatus;
    @XmlAttribute(name = "VoucherStatus", required = true)
    protected boolean voucherStatus;
    @XmlAttribute(name = "InvoiceNumber")
    protected String invoiceNumber;
    @XmlAttribute(name = "SupplierReferenceNo")
    protected String supplierReferenceNo;
    @XmlAttribute(name = "ConfirmationNo")
    protected String confirmationNo;
    @XmlAttribute(name = "HotelConfirmationNo")
    protected String hotelConfirmationNo;

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
     * Obtém o valor da propriedade rating.
     * 
     * @return
     *     possible object is
     *     {@link HotelInfoHotelRating }
     *     
     */
    public HotelInfoHotelRating getRating() {
        return rating;
    }

    /**
     * Define o valor da propriedade rating.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelInfoHotelRating }
     *     
     */
    public void setRating(HotelInfoHotelRating value) {
        this.rating = value;
    }

    /**
     * Obtém o valor da propriedade addressLine1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Define o valor da propriedade addressLine1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine1(String value) {
        this.addressLine1 = value;
    }

    /**
     * Obtém o valor da propriedade addressLine2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Define o valor da propriedade addressLine2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine2(String value) {
        this.addressLine2 = value;
    }

    /**
     * Obtém o valor da propriedade map.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMap() {
        return map;
    }

    /**
     * Define o valor da propriedade map.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMap(String value) {
        this.map = value;
    }

    /**
     * Obtém o valor da propriedade city.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Define o valor da propriedade city.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
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

    /**
     * Obtém o valor da propriedade bookingDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBookingDate() {
        return bookingDate;
    }

    /**
     * Define o valor da propriedade bookingDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBookingDate(XMLGregorianCalendar value) {
        this.bookingDate = value;
    }

    /**
     * Obtém o valor da propriedade hotelCancelPolicies.
     * 
     * @return
     *     possible object is
     *     {@link CancelPolicies }
     *     
     */
    public CancelPolicies getHotelCancelPolicies() {
        return hotelCancelPolicies;
    }

    /**
     * Define o valor da propriedade hotelCancelPolicies.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelPolicies }
     *     
     */
    public void setHotelCancelPolicies(CancelPolicies value) {
        this.hotelCancelPolicies = value;
    }

    /**
     * Obtém o valor da propriedade hotelPolicyDetails.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelPolicyDetails() {
        return hotelPolicyDetails;
    }

    /**
     * Define o valor da propriedade hotelPolicyDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelPolicyDetails(String value) {
        this.hotelPolicyDetails = value;
    }

    /**
     * Obtém o valor da propriedade flightInfo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightInfo() {
        return flightInfo;
    }

    /**
     * Define o valor da propriedade flightInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightInfo(String value) {
        this.flightInfo = value;
    }

    /**
     * Obtém o valor da propriedade specialRequest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialRequest() {
        return specialRequest;
    }

    /**
     * Define o valor da propriedade specialRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialRequest(String value) {
        this.specialRequest = value;
    }

    /**
     * Obtém o valor da propriedade roomtype.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoomDetails }
     *     
     */
    public ArrayOfRoomDetails getRoomtype() {
        return roomtype;
    }

    /**
     * Define o valor da propriedade roomtype.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoomDetails }
     *     
     */
    public void setRoomtype(ArrayOfRoomDetails value) {
        this.roomtype = value;
    }

    /**
     * Obtém o valor da propriedade amendmentDetails.
     * 
     * @return
     *     possible object is
     *     {@link AmendmentDetails }
     *     
     */
    public AmendmentDetails getAmendmentDetails() {
        return amendmentDetails;
    }

    /**
     * Define o valor da propriedade amendmentDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendmentDetails }
     *     
     */
    public void setAmendmentDetails(AmendmentDetails value) {
        this.amendmentDetails = value;
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
     * Obtém o valor da propriedade agencyDetails.
     * 
     * @return
     *     possible object is
     *     {@link AgencyDetails }
     *     
     */
    public AgencyDetails getAgencyDetails() {
        return agencyDetails;
    }

    /**
     * Define o valor da propriedade agencyDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link AgencyDetails }
     *     
     */
    public void setAgencyDetails(AgencyDetails value) {
        this.agencyDetails = value;
    }

    /**
     * Obtém o valor da propriedade aotNumbers.
     * 
     * @return
     *     possible object is
     *     {@link AOTNumbers }
     *     
     */
    public AOTNumbers getAOTNumbers() {
        return aotNumbers;
    }

    /**
     * Define o valor da propriedade aotNumbers.
     * 
     * @param value
     *     allowed object is
     *     {@link AOTNumbers }
     *     
     */
    public void setAOTNumbers(AOTNumbers value) {
        this.aotNumbers = value;
    }

    /**
     * Obtém o valor da propriedade cityId.
     * 
     */
    public int getCityId() {
        return cityId;
    }

    /**
     * Define o valor da propriedade cityId.
     * 
     */
    public void setCityId(int value) {
        this.cityId = value;
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
     * Obtém o valor da propriedade currentCancellationCharges.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCurrentCancellationCharges() {
        return currentCancellationCharges;
    }

    /**
     * Define o valor da propriedade currentCancellationCharges.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCurrentCancellationCharges(BigDecimal value) {
        this.currentCancellationCharges = value;
    }

    /**
     * Obtém o valor da propriedade appliedCancellationCharges.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAppliedCancellationCharges() {
        return appliedCancellationCharges;
    }

    /**
     * Define o valor da propriedade appliedCancellationCharges.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAppliedCancellationCharges(BigDecimal value) {
        this.appliedCancellationCharges = value;
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
     * Obtém o valor da propriedade amendmentStatus.
     * 
     * @return
     *     possible object is
     *     {@link RequestStatus }
     *     
     */
    public RequestStatus getAmendmentStatus() {
        return amendmentStatus;
    }

    /**
     * Define o valor da propriedade amendmentStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestStatus }
     *     
     */
    public void setAmendmentStatus(RequestStatus value) {
        this.amendmentStatus = value;
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
     * Obtém o valor da propriedade voucherStatus.
     * 
     */
    public boolean isVoucherStatus() {
        return voucherStatus;
    }

    /**
     * Define o valor da propriedade voucherStatus.
     * 
     */
    public void setVoucherStatus(boolean value) {
        this.voucherStatus = value;
    }

    /**
     * Obtém o valor da propriedade invoiceNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Define o valor da propriedade invoiceNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceNumber(String value) {
        this.invoiceNumber = value;
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
     * Obtém o valor da propriedade hotelConfirmationNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelConfirmationNo() {
        return hotelConfirmationNo;
    }

    /**
     * Define o valor da propriedade hotelConfirmationNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelConfirmationNo(String value) {
        this.hotelConfirmationNo = value;
    }

}
