
package tektravel.hotelbookingapi;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de HotelInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="HotelInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelPicture" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="HotelAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelContactNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Rating" type="{http://TekTravel/HotelBookingApi}HotelInfoHotelRating"/>
 *         &lt;element name="HotelPromotion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TripAdvisorRating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TripAdvisorReviewURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TagIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelInfo", propOrder = {
    "hotelCode",
    "hotelName",
    "hotelPicture",
    "hotelDescription",
    "latitude",
    "longitude",
    "hotelAddress",
    "hotelContactNo",
    "rating",
    "hotelPromotion",
    "tripAdvisorRating",
    "tripAdvisorReviewURL",
    "tagIds"
})
public class HotelInfo {

    @XmlElement(name = "HotelCode")
    protected String hotelCode;
    @XmlElement(name = "HotelName")
    protected String hotelName;
    @XmlElement(name = "HotelPicture")
    protected String hotelPicture;
    @XmlElement(name = "HotelDescription")
    protected String hotelDescription;
    @XmlElement(name = "Latitude", required = true, nillable = true)
    protected BigDecimal latitude;
    @XmlElement(name = "Longitude", required = true, nillable = true)
    protected BigDecimal longitude;
    @XmlElement(name = "HotelAddress")
    protected String hotelAddress;
    @XmlElement(name = "HotelContactNo")
    protected String hotelContactNo;
    @XmlElement(name = "Rating", required = true)
    protected HotelInfoHotelRating rating;
    @XmlElement(name = "HotelPromotion")
    protected String hotelPromotion;
    @XmlElement(name = "TripAdvisorRating")
    protected String tripAdvisorRating;
    @XmlElement(name = "TripAdvisorReviewURL")
    protected String tripAdvisorReviewURL;
    @XmlElement(name = "TagIds")
    protected String tagIds;

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
     * Obtém o valor da propriedade hotelPicture.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelPicture() {
        return hotelPicture;
    }

    /**
     * Define o valor da propriedade hotelPicture.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelPicture(String value) {
        this.hotelPicture = value;
    }

    /**
     * Obtém o valor da propriedade hotelDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelDescription() {
        return hotelDescription;
    }

    /**
     * Define o valor da propriedade hotelDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelDescription(String value) {
        this.hotelDescription = value;
    }

    /**
     * Obtém o valor da propriedade latitude.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * Define o valor da propriedade latitude.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLatitude(BigDecimal value) {
        this.latitude = value;
    }

    /**
     * Obtém o valor da propriedade longitude.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * Define o valor da propriedade longitude.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLongitude(BigDecimal value) {
        this.longitude = value;
    }

    /**
     * Obtém o valor da propriedade hotelAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelAddress() {
        return hotelAddress;
    }

    /**
     * Define o valor da propriedade hotelAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelAddress(String value) {
        this.hotelAddress = value;
    }

    /**
     * Obtém o valor da propriedade hotelContactNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelContactNo() {
        return hotelContactNo;
    }

    /**
     * Define o valor da propriedade hotelContactNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelContactNo(String value) {
        this.hotelContactNo = value;
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
     * Obtém o valor da propriedade hotelPromotion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelPromotion() {
        return hotelPromotion;
    }

    /**
     * Define o valor da propriedade hotelPromotion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelPromotion(String value) {
        this.hotelPromotion = value;
    }

    /**
     * Obtém o valor da propriedade tripAdvisorRating.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripAdvisorRating() {
        return tripAdvisorRating;
    }

    /**
     * Define o valor da propriedade tripAdvisorRating.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripAdvisorRating(String value) {
        this.tripAdvisorRating = value;
    }

    /**
     * Obtém o valor da propriedade tripAdvisorReviewURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripAdvisorReviewURL() {
        return tripAdvisorReviewURL;
    }

    /**
     * Define o valor da propriedade tripAdvisorReviewURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripAdvisorReviewURL(String value) {
        this.tripAdvisorReviewURL = value;
    }

    /**
     * Obtém o valor da propriedade tagIds.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTagIds() {
        return tagIds;
    }

    /**
     * Define o valor da propriedade tagIds.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTagIds(String value) {
        this.tagIds = value;
    }

}
