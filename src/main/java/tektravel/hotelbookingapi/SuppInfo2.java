
package tektravel.hotelbookingapi;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Supp_info complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Supp_info">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Type" use="required" type="{http://TekTravel/HotelBookingApi}SupplementType" />
 *       &lt;attribute name="SuppName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SuppChargeType" use="required" type="{http://TekTravel/HotelBookingApi}SupmtChargeType" />
 *       &lt;attribute name="Price" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Supp_info")
public class SuppInfo2 {

    @XmlAttribute(name = "Type", required = true)
    protected SupplementType type;
    @XmlAttribute(name = "SuppName")
    protected String suppName;
    @XmlAttribute(name = "SuppChargeType", required = true)
    protected SupmtChargeType suppChargeType;
    @XmlAttribute(name = "Price", required = true)
    protected BigDecimal price;
    @XmlAttribute(name = "Currency")
    protected String currency;

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link SupplementType }
     *     
     */
    public SupplementType getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplementType }
     *     
     */
    public void setType(SupplementType value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade suppName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuppName() {
        return suppName;
    }

    /**
     * Define o valor da propriedade suppName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuppName(String value) {
        this.suppName = value;
    }

    /**
     * Obtém o valor da propriedade suppChargeType.
     * 
     * @return
     *     possible object is
     *     {@link SupmtChargeType }
     *     
     */
    public SupmtChargeType getSuppChargeType() {
        return suppChargeType;
    }

    /**
     * Define o valor da propriedade suppChargeType.
     * 
     * @param value
     *     allowed object is
     *     {@link SupmtChargeType }
     *     
     */
    public void setSuppChargeType(SupmtChargeType value) {
        this.suppChargeType = value;
    }

    /**
     * Obtém o valor da propriedade price.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Define o valor da propriedade price.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
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
