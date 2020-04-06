
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de PriceVerificationStatus.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="PriceVerificationStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Successful"/>
 *     &lt;enumeration value="Failed"/>
 *     &lt;enumeration value="NotAvailable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PriceVerificationStatus")
@XmlEnum
public enum PriceVerificationStatus {

    @XmlEnumValue("Successful")
    SUCCESSFUL("Successful"),
    @XmlEnumValue("Failed")
    FAILED("Failed"),
    @XmlEnumValue("NotAvailable")
    NOT_AVAILABLE("NotAvailable");
    private final String value;

    PriceVerificationStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PriceVerificationStatus fromValue(String v) {
        for (PriceVerificationStatus c: PriceVerificationStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
