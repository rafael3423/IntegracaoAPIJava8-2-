
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de RoomGuest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RoomGuest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChildAge" type="{http://TekTravel/HotelBookingApi}ArrayOfInt" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AdultCount" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ChildCount" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomGuest", propOrder = {
    "childAge"
})
public class RoomGuest {

    @XmlElement(name = "ChildAge")
    protected ArrayOfInt childAge;
    @XmlAttribute(name = "AdultCount", required = true)
    protected int adultCount;
    @XmlAttribute(name = "ChildCount", required = true)
    protected int childCount;

    /**
     * Obtém o valor da propriedade childAge.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getChildAge() {
        return childAge;
    }

    /**
     * Define o valor da propriedade childAge.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setChildAge(ArrayOfInt value) {
        this.childAge = value;
    }

    /**
     * Obtém o valor da propriedade adultCount.
     * 
     */
    public int getAdultCount() {
        return adultCount;
    }

    /**
     * Define o valor da propriedade adultCount.
     * 
     */
    public void setAdultCount(int value) {
        this.adultCount = value;
    }

    /**
     * Obtém o valor da propriedade childCount.
     * 
     */
    public int getChildCount() {
        return childCount;
    }

    /**
     * Define o valor da propriedade childCount.
     * 
     */
    public void setChildCount(int value) {
        this.childCount = value;
    }

}
