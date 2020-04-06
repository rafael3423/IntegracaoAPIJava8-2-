
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de PriceChangeStatus complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="PriceChangeStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelRooms" type="{http://TekTravel/HotelBookingApi}ArrayOfHotel_Room" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Status" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="AvailableOnNewPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="NewPrice" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceChangeStatus", propOrder = {
    "hotelRooms"
})
public class PriceChangeStatus {

    @XmlElement(name = "HotelRooms")
    protected ArrayOfHotelRoom hotelRooms;
    @XmlAttribute(name = "Status", required = true)
    protected boolean status;
    @XmlAttribute(name = "AvailableOnNewPrice", required = true)
    protected boolean availableOnNewPrice;
    @XmlAttribute(name = "NewPrice")
    protected String newPrice;
    @XmlAttribute(name = "Currency")
    protected String currency;

    /**
     * Obtém o valor da propriedade hotelRooms.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfHotelRoom }
     *     
     */
    public ArrayOfHotelRoom getHotelRooms() {
        return hotelRooms;
    }

    /**
     * Define o valor da propriedade hotelRooms.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfHotelRoom }
     *     
     */
    public void setHotelRooms(ArrayOfHotelRoom value) {
        this.hotelRooms = value;
    }

    /**
     * Obtém o valor da propriedade status.
     * 
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     */
    public void setStatus(boolean value) {
        this.status = value;
    }

    /**
     * Obtém o valor da propriedade availableOnNewPrice.
     * 
     */
    public boolean isAvailableOnNewPrice() {
        return availableOnNewPrice;
    }

    /**
     * Define o valor da propriedade availableOnNewPrice.
     * 
     */
    public void setAvailableOnNewPrice(boolean value) {
        this.availableOnNewPrice = value;
    }

    /**
     * Obtém o valor da propriedade newPrice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPrice() {
        return newPrice;
    }

    /**
     * Define o valor da propriedade newPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPrice(String value) {
        this.newPrice = value;
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

}
