
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
 *         &lt;element name="CountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityList" type="{http://TekTravel/HotelBookingApi}ArrayOfCityList" minOccurs="0"/>
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
    "countryName",
    "cityList"
})
@XmlRootElement(name = "DestinationCityListResponse")
public class DestinationCityListResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "CountryName")
    protected String countryName;
    @XmlElement(name = "CityList")
    protected ArrayOfCityList cityList;

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
     * Obtém o valor da propriedade countryName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Define o valor da propriedade countryName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

    /**
     * Obtém o valor da propriedade cityList.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCityList }
     *     
     */
    public ArrayOfCityList getCityList() {
        return cityList;
    }

    /**
     * Define o valor da propriedade cityList.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCityList }
     *     
     */
    public void setCityList(ArrayOfCityList value) {
        this.cityList = value;
    }

}
