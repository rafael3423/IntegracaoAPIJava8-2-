
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
 *         &lt;element name="ResultIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AvailableForBook" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AvailableForConfirmBook" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CancellationPoliciesAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="HotelCancellationPolicies" type="{http://TekTravel/HotelBookingApi}HotelCancellationPolicies" minOccurs="0"/>
 *         &lt;element name="PriceVerification" type="{http://TekTravel/HotelBookingApi}PriceVerification" minOccurs="0"/>
 *         &lt;element name="AccountInfo" type="{http://TekTravel/HotelBookingApi}AccountInfo" minOccurs="0"/>
 *         &lt;element name="HotelDetailsVerification" type="{http://TekTravel/HotelBookingApi}HotelDetailsVerification" minOccurs="0"/>
 *         &lt;element name="HotelDetails" type="{http://TekTravel/HotelBookingApi}APIHotelDetails" minOccurs="0"/>
 *         &lt;element name="IsFlightDetailsMandatory" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "resultIndex",
    "availableForBook",
    "availableForConfirmBook",
    "cancellationPoliciesAvailable",
    "hotelCancellationPolicies",
    "priceVerification",
    "accountInfo",
    "hotelDetailsVerification",
    "hotelDetails",
    "isFlightDetailsMandatory"
})
@XmlRootElement(name = "AvailabilityAndPricingResponse")
public class AvailabilityAndPricingResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "ResultIndex")
    protected int resultIndex;
    @XmlElement(name = "AvailableForBook")
    protected boolean availableForBook;
    @XmlElement(name = "AvailableForConfirmBook")
    protected boolean availableForConfirmBook;
    @XmlElement(name = "CancellationPoliciesAvailable")
    protected boolean cancellationPoliciesAvailable;
    @XmlElement(name = "HotelCancellationPolicies")
    protected HotelCancellationPolicies hotelCancellationPolicies;
    @XmlElement(name = "PriceVerification")
    protected PriceVerification priceVerification;
    @XmlElement(name = "AccountInfo")
    protected AccountInfo accountInfo;
    @XmlElement(name = "HotelDetailsVerification")
    protected HotelDetailsVerification hotelDetailsVerification;
    @XmlElement(name = "HotelDetails")
    protected APIHotelDetails hotelDetails;
    @XmlElement(name = "IsFlightDetailsMandatory")
    protected boolean isFlightDetailsMandatory;

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
     * Obtém o valor da propriedade availableForBook.
     * 
     */
    public boolean isAvailableForBook() {
        return availableForBook;
    }

    /**
     * Define o valor da propriedade availableForBook.
     * 
     */
    public void setAvailableForBook(boolean value) {
        this.availableForBook = value;
    }

    /**
     * Obtém o valor da propriedade availableForConfirmBook.
     * 
     */
    public boolean isAvailableForConfirmBook() {
        return availableForConfirmBook;
    }

    /**
     * Define o valor da propriedade availableForConfirmBook.
     * 
     */
    public void setAvailableForConfirmBook(boolean value) {
        this.availableForConfirmBook = value;
    }

    /**
     * Obtém o valor da propriedade cancellationPoliciesAvailable.
     * 
     */
    public boolean isCancellationPoliciesAvailable() {
        return cancellationPoliciesAvailable;
    }

    /**
     * Define o valor da propriedade cancellationPoliciesAvailable.
     * 
     */
    public void setCancellationPoliciesAvailable(boolean value) {
        this.cancellationPoliciesAvailable = value;
    }

    /**
     * Obtém o valor da propriedade hotelCancellationPolicies.
     * 
     * @return
     *     possible object is
     *     {@link HotelCancellationPolicies }
     *     
     */
    public HotelCancellationPolicies getHotelCancellationPolicies() {
        return hotelCancellationPolicies;
    }

    /**
     * Define o valor da propriedade hotelCancellationPolicies.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelCancellationPolicies }
     *     
     */
    public void setHotelCancellationPolicies(HotelCancellationPolicies value) {
        this.hotelCancellationPolicies = value;
    }

    /**
     * Obtém o valor da propriedade priceVerification.
     * 
     * @return
     *     possible object is
     *     {@link PriceVerification }
     *     
     */
    public PriceVerification getPriceVerification() {
        return priceVerification;
    }

    /**
     * Define o valor da propriedade priceVerification.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceVerification }
     *     
     */
    public void setPriceVerification(PriceVerification value) {
        this.priceVerification = value;
    }

    /**
     * Obtém o valor da propriedade accountInfo.
     * 
     * @return
     *     possible object is
     *     {@link AccountInfo }
     *     
     */
    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    /**
     * Define o valor da propriedade accountInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountInfo }
     *     
     */
    public void setAccountInfo(AccountInfo value) {
        this.accountInfo = value;
    }

    /**
     * Obtém o valor da propriedade hotelDetailsVerification.
     * 
     * @return
     *     possible object is
     *     {@link HotelDetailsVerification }
     *     
     */
    public HotelDetailsVerification getHotelDetailsVerification() {
        return hotelDetailsVerification;
    }

    /**
     * Define o valor da propriedade hotelDetailsVerification.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelDetailsVerification }
     *     
     */
    public void setHotelDetailsVerification(HotelDetailsVerification value) {
        this.hotelDetailsVerification = value;
    }

    /**
     * Obtém o valor da propriedade hotelDetails.
     * 
     * @return
     *     possible object is
     *     {@link APIHotelDetails }
     *     
     */
    public APIHotelDetails getHotelDetails() {
        return hotelDetails;
    }

    /**
     * Define o valor da propriedade hotelDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link APIHotelDetails }
     *     
     */
    public void setHotelDetails(APIHotelDetails value) {
        this.hotelDetails = value;
    }

    /**
     * Obtém o valor da propriedade isFlightDetailsMandatory.
     * 
     */
    public boolean isIsFlightDetailsMandatory() {
        return isFlightDetailsMandatory;
    }

    /**
     * Define o valor da propriedade isFlightDetailsMandatory.
     * 
     */
    public void setIsFlightDetailsMandatory(boolean value) {
        this.isFlightDetailsMandatory = value;
    }

}
