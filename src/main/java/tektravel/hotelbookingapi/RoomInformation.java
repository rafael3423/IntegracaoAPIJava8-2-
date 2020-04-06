
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de RoomInformation complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RoomInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ImageURLs" type="{http://TekTravel/HotelBookingApi}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="Amenities" type="{http://TekTravel/HotelBookingApi}ArrayOfString1" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="SmokingPref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MaxOccupancy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MaxAge" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MinAge" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MaxAdult" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MaxChild" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomInformation", propOrder = {
    "description",
    "imageURLs",
    "amenities"
})
public class RoomInformation {

    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "ImageURLs")
    protected ArrayOfString imageURLs;
    @XmlElement(name = "Amenities")
    protected ArrayOfString1 amenities;
    @XmlAttribute(name = "SmokingPref")
    protected String smokingPref;
    @XmlAttribute(name = "MaxOccupancy")
    protected String maxOccupancy;
    @XmlAttribute(name = "MaxAge")
    protected String maxAge;
    @XmlAttribute(name = "MinAge")
    protected String minAge;
    @XmlAttribute(name = "MaxAdult")
    protected String maxAdult;
    @XmlAttribute(name = "MaxChild")
    protected String maxChild;

    /**
     * Obtém o valor da propriedade description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define o valor da propriedade description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtém o valor da propriedade imageURLs.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getImageURLs() {
        return imageURLs;
    }

    /**
     * Define o valor da propriedade imageURLs.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setImageURLs(ArrayOfString value) {
        this.imageURLs = value;
    }

    /**
     * Obtém o valor da propriedade amenities.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString1 }
     *     
     */
    public ArrayOfString1 getAmenities() {
        return amenities;
    }

    /**
     * Define o valor da propriedade amenities.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString1 }
     *     
     */
    public void setAmenities(ArrayOfString1 value) {
        this.amenities = value;
    }

    /**
     * Obtém o valor da propriedade smokingPref.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmokingPref() {
        return smokingPref;
    }

    /**
     * Define o valor da propriedade smokingPref.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmokingPref(String value) {
        this.smokingPref = value;
    }

    /**
     * Obtém o valor da propriedade maxOccupancy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxOccupancy() {
        return maxOccupancy;
    }

    /**
     * Define o valor da propriedade maxOccupancy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxOccupancy(String value) {
        this.maxOccupancy = value;
    }

    /**
     * Obtém o valor da propriedade maxAge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxAge() {
        return maxAge;
    }

    /**
     * Define o valor da propriedade maxAge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxAge(String value) {
        this.maxAge = value;
    }

    /**
     * Obtém o valor da propriedade minAge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinAge() {
        return minAge;
    }

    /**
     * Define o valor da propriedade minAge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinAge(String value) {
        this.minAge = value;
    }

    /**
     * Obtém o valor da propriedade maxAdult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxAdult() {
        return maxAdult;
    }

    /**
     * Define o valor da propriedade maxAdult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxAdult(String value) {
        this.maxAdult = value;
    }

    /**
     * Obtém o valor da propriedade maxChild.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxChild() {
        return maxChild;
    }

    /**
     * Define o valor da propriedade maxChild.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxChild(String value) {
        this.maxChild = value;
    }

}
