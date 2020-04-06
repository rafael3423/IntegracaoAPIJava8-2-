
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de HotelSearchWithRoomsFilters complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="HotelSearchWithRoomsFilters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StarRating" type="{http://TekTravel/HotelBookingApi}HotelRatingInput"/>
 *         &lt;element name="OrderBy" type="{http://TekTravel/HotelBookingApi}OrderByFilter"/>
 *         &lt;element name="HotelCodeList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelSearchWithRoomsFilters", propOrder = {
    "hotelName",
    "starRating",
    "orderBy",
    "hotelCodeList"
})
public class HotelSearchWithRoomsFilters {

    @XmlElement(name = "HotelName")
    protected String hotelName;
    @XmlElement(name = "StarRating", required = true)
    protected HotelRatingInput starRating;
    @XmlElement(name = "OrderBy", required = true)
    protected OrderByFilter orderBy;
    @XmlElement(name = "HotelCodeList")
    protected String hotelCodeList;

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
     * Obtém o valor da propriedade starRating.
     * 
     * @return
     *     possible object is
     *     {@link HotelRatingInput }
     *     
     */
    public HotelRatingInput getStarRating() {
        return starRating;
    }

    /**
     * Define o valor da propriedade starRating.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelRatingInput }
     *     
     */
    public void setStarRating(HotelRatingInput value) {
        this.starRating = value;
    }

    /**
     * Obtém o valor da propriedade orderBy.
     * 
     * @return
     *     possible object is
     *     {@link OrderByFilter }
     *     
     */
    public OrderByFilter getOrderBy() {
        return orderBy;
    }

    /**
     * Define o valor da propriedade orderBy.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderByFilter }
     *     
     */
    public void setOrderBy(OrderByFilter value) {
        this.orderBy = value;
    }

    /**
     * Obtém o valor da propriedade hotelCodeList.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCodeList() {
        return hotelCodeList;
    }

    /**
     * Define o valor da propriedade hotelCodeList.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCodeList(String value) {
        this.hotelCodeList = value;
    }

}
