
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
 *         &lt;element name="TagInfos" type="{http://TekTravel/HotelBookingApi}ArrayOfTagInfos" minOccurs="0"/>
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
    "tagInfos"
})
@XmlRootElement(name = "TagInfoResponse")
public class TagInfoResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "TagInfos")
    protected ArrayOfTagInfos tagInfos;

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
     * Obtém o valor da propriedade tagInfos.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTagInfos }
     *     
     */
    public ArrayOfTagInfos getTagInfos() {
        return tagInfos;
    }

    /**
     * Define o valor da propriedade tagInfos.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTagInfos }
     *     
     */
    public void setTagInfos(ArrayOfTagInfos value) {
        this.tagInfos = value;
    }

}
