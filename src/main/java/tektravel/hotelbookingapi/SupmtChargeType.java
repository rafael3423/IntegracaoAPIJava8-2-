
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SupmtChargeType.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="SupmtChargeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Included"/>
 *     &lt;enumeration value="Addition"/>
 *     &lt;enumeration value="AtProperty"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SupmtChargeType")
@XmlEnum
public enum SupmtChargeType {

    @XmlEnumValue("Included")
    INCLUDED("Included"),
    @XmlEnumValue("Addition")
    ADDITION("Addition"),
    @XmlEnumValue("AtProperty")
    AT_PROPERTY("AtProperty");
    private final String value;

    SupmtChargeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SupmtChargeType fromValue(String v) {
        for (SupmtChargeType c: SupmtChargeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
