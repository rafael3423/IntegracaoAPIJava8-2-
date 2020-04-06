
package tektravel.hotelbookingapi;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SuppInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SuppInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="SuppID" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="SuppChargeType" use="required" type="{http://TekTravel/HotelBookingApi}SuppChargeType" />
 *       &lt;attribute name="Price" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="SuppIsSelected" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SuppInfo")
public class SuppInfo {

    @XmlAttribute(name = "SuppID", required = true)
    protected int suppID;
    @XmlAttribute(name = "SuppChargeType", required = true)
    protected SuppChargeType suppChargeType;
    @XmlAttribute(name = "Price", required = true)
    protected BigDecimal price;
    @XmlAttribute(name = "SuppIsSelected", required = true)
    protected boolean suppIsSelected;

    /**
     * Obtém o valor da propriedade suppID.
     * 
     */
    public int getSuppID() {
        return suppID;
    }

    /**
     * Define o valor da propriedade suppID.
     * 
     */
    public void setSuppID(int value) {
        this.suppID = value;
    }

    /**
     * Obtém o valor da propriedade suppChargeType.
     * 
     * @return
     *     possible object is
     *     {@link SuppChargeType }
     *     
     */
    public SuppChargeType getSuppChargeType() {
        return suppChargeType;
    }

    /**
     * Define o valor da propriedade suppChargeType.
     * 
     * @param value
     *     allowed object is
     *     {@link SuppChargeType }
     *     
     */
    public void setSuppChargeType(SuppChargeType value) {
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
     * Obtém o valor da propriedade suppIsSelected.
     * 
     */
    public boolean isSuppIsSelected() {
        return suppIsSelected;
    }

    /**
     * Define o valor da propriedade suppIsSelected.
     * 
     */
    public void setSuppIsSelected(boolean value) {
        this.suppIsSelected = value;
    }

}
