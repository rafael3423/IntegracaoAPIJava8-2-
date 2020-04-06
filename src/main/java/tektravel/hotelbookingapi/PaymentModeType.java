
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de PaymentModeType.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentModeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Limit"/>
 *     &lt;enumeration value="CreditCard"/>
 *     &lt;enumeration value="Fawry"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentModeType")
@XmlEnum
public enum PaymentModeType {

    @XmlEnumValue("Limit")
    LIMIT("Limit"),
    @XmlEnumValue("CreditCard")
    CREDIT_CARD("CreditCard"),
    @XmlEnumValue("Fawry")
    FAWRY("Fawry");
    private final String value;

    PaymentModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaymentModeType fromValue(String v) {
        for (PaymentModeType c: PaymentModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
