
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
 *         &lt;element name="CityWiseNotifications" type="{http://TekTravel/HotelBookingApi}ArrayOfCityWiseNotification" minOccurs="0"/>
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
    "cityWiseNotifications"
})
@XmlRootElement(name = "CityWiseNotificationResponse")
public class CityWiseNotificationResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "CityWiseNotifications")
    protected ArrayOfCityWiseNotification cityWiseNotifications;

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
     * Obtém o valor da propriedade cityWiseNotifications.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCityWiseNotification }
     *     
     */
    public ArrayOfCityWiseNotification getCityWiseNotifications() {
        return cityWiseNotifications;
    }

    /**
     * Define o valor da propriedade cityWiseNotifications.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCityWiseNotification }
     *     
     */
    public void setCityWiseNotifications(ArrayOfCityWiseNotification value) {
        this.cityWiseNotifications = value;
    }

}
