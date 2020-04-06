
package tektravel.hotelbookingapi;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de MinHotelPrice complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="MinHotelPrice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="PrefPrice" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PrefCurrency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TotalPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="B2CRates" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="OriginalPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MinHotelPrice")
public class MinHotelPrice {

    @XmlAttribute(name = "PrefPrice")
    protected String prefPrice;
    @XmlAttribute(name = "PrefCurrency")
    protected String prefCurrency;
    @XmlAttribute(name = "TotalPrice", required = true)
    protected BigDecimal totalPrice;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "B2CRates", required = true)
    protected boolean b2CRates;
    @XmlAttribute(name = "OriginalPrice", required = true)
    protected BigDecimal originalPrice;

    /**
     * Obtém o valor da propriedade prefPrice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefPrice() {
        return prefPrice;
    }

    /**
     * Define o valor da propriedade prefPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefPrice(String value) {
        this.prefPrice = value;
    }

    /**
     * Obtém o valor da propriedade prefCurrency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefCurrency() {
        return prefCurrency;
    }

    /**
     * Define o valor da propriedade prefCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefCurrency(String value) {
        this.prefCurrency = value;
    }

    /**
     * Obtém o valor da propriedade totalPrice.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Define o valor da propriedade totalPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalPrice(BigDecimal value) {
        this.totalPrice = value;
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

    /**
     * Obtém o valor da propriedade b2CRates.
     * 
     */
    public boolean isB2CRates() {
        return b2CRates;
    }

    /**
     * Define o valor da propriedade b2CRates.
     * 
     */
    public void setB2CRates(boolean value) {
        this.b2CRates = value;
    }

    /**
     * Obtém o valor da propriedade originalPrice.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * Define o valor da propriedade originalPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOriginalPrice(BigDecimal value) {
        this.originalPrice = value;
    }

}
