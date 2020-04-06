
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
 *         &lt;element name="SessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResultIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResponseTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsCancellationPolicyRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "sessionId",
    "resultIndex",
    "hotelCode",
    "responseTime",
    "isCancellationPolicyRequired"
})
@XmlRootElement(name = "HotelRoomAvailabilityRequest")
public class HotelRoomAvailabilityRequest {

    @XmlElement(name = "SessionId")
    protected String sessionId;
    @XmlElement(name = "ResultIndex")
    protected int resultIndex;
    @XmlElement(name = "HotelCode")
    protected String hotelCode;
    @XmlElement(name = "ResponseTime")
    protected int responseTime;
    @XmlElement(name = "IsCancellationPolicyRequired")
    protected boolean isCancellationPolicyRequired;

    /**
     * Obtém o valor da propriedade sessionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Define o valor da propriedade sessionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
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
     * Obtém o valor da propriedade responseTime.
     * 
     */
    public int getResponseTime() {
        return responseTime;
    }

    /**
     * Define o valor da propriedade responseTime.
     * 
     */
    public void setResponseTime(int value) {
        this.responseTime = value;
    }

    /**
     * Obtém o valor da propriedade isCancellationPolicyRequired.
     * 
     */
    public boolean isIsCancellationPolicyRequired() {
        return isCancellationPolicyRequired;
    }

    /**
     * Define o valor da propriedade isCancellationPolicyRequired.
     * 
     */
    public void setIsCancellationPolicyRequired(boolean value) {
        this.isCancellationPolicyRequired = value;
    }

}
