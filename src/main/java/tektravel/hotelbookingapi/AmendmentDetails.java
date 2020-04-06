
package tektravel.hotelbookingapi;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de AmendmentDetails complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="AmendmentDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="BeforeAmendmentPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="AfterAmendmentPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="CreditNoteAmount" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="DebitNoteAmount" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmendmentDetails")
public class AmendmentDetails {

    @XmlAttribute(name = "BeforeAmendmentPrice", required = true)
    protected BigDecimal beforeAmendmentPrice;
    @XmlAttribute(name = "AfterAmendmentPrice", required = true)
    protected BigDecimal afterAmendmentPrice;
    @XmlAttribute(name = "CreditNoteAmount", required = true)
    protected BigDecimal creditNoteAmount;
    @XmlAttribute(name = "DebitNoteAmount", required = true)
    protected BigDecimal debitNoteAmount;

    /**
     * Obtém o valor da propriedade beforeAmendmentPrice.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBeforeAmendmentPrice() {
        return beforeAmendmentPrice;
    }

    /**
     * Define o valor da propriedade beforeAmendmentPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBeforeAmendmentPrice(BigDecimal value) {
        this.beforeAmendmentPrice = value;
    }

    /**
     * Obtém o valor da propriedade afterAmendmentPrice.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAfterAmendmentPrice() {
        return afterAmendmentPrice;
    }

    /**
     * Define o valor da propriedade afterAmendmentPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAfterAmendmentPrice(BigDecimal value) {
        this.afterAmendmentPrice = value;
    }

    /**
     * Obtém o valor da propriedade creditNoteAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCreditNoteAmount() {
        return creditNoteAmount;
    }

    /**
     * Define o valor da propriedade creditNoteAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCreditNoteAmount(BigDecimal value) {
        this.creditNoteAmount = value;
    }

    /**
     * Obtém o valor da propriedade debitNoteAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDebitNoteAmount() {
        return debitNoteAmount;
    }

    /**
     * Define o valor da propriedade debitNoteAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDebitNoteAmount(BigDecimal value) {
        this.debitNoteAmount = value;
    }

}
