
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
 *         &lt;element name="CityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsDetailedResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "cityCode",
    "isDetailedResponse"
})
@XmlRootElement(name = "TBOHotelCodesRequest")
public class TBOHotelCodesRequest {

    @XmlElement(name = "CityCode")
    protected String cityCode;
    @XmlElement(name = "IsDetailedResponse")
    protected String isDetailedResponse;

    /**
     * Obtém o valor da propriedade cityCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * Define o valor da propriedade cityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityCode(String value) {
        this.cityCode = value;
    }

    /**
     * Obtém o valor da propriedade isDetailedResponse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsDetailedResponse() {
        return isDetailedResponse;
    }

    /**
     * Define o valor da propriedade isDetailedResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsDetailedResponse(String value) {
        this.isDetailedResponse = value;
    }

}
