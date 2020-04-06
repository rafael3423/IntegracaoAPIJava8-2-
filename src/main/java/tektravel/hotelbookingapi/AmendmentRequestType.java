
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de AmendmentRequestType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="AmendmentRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Type" use="required" type="{http://TekTravel/HotelBookingApi}AmendmentType" />
 *       &lt;attribute name="PriceChange" use="required" type="{http://TekTravel/HotelBookingApi}PriceChange" />
 *       &lt;attribute name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmendmentRequestType")
public class AmendmentRequestType {

    @XmlAttribute(name = "Type", required = true)
    protected AmendmentType type;
    @XmlAttribute(name = "PriceChange", required = true)
    protected PriceChange priceChange;
    @XmlAttribute(name = "Remarks")
    protected String remarks;

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link AmendmentType }
     *     
     */
    public AmendmentType getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendmentType }
     *     
     */
    public void setType(AmendmentType value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade priceChange.
     * 
     * @return
     *     possible object is
     *     {@link PriceChange }
     *     
     */
    public PriceChange getPriceChange() {
        return priceChange;
    }

    /**
     * Define o valor da propriedade priceChange.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceChange }
     *     
     */
    public void setPriceChange(PriceChange value) {
        this.priceChange = value;
    }

    /**
     * Obtém o valor da propriedade remarks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Define o valor da propriedade remarks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

}
