
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de CancellationChargeTypeForHotel.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="CancellationChargeTypeForHotel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fixed"/>
 *     &lt;enumeration value="Percentage"/>
 *     &lt;enumeration value="Night"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CancellationChargeTypeForHotel")
@XmlEnum
public enum CancellationChargeTypeForHotel {

    @XmlEnumValue("Fixed")
    FIXED("Fixed"),
    @XmlEnumValue("Percentage")
    PERCENTAGE("Percentage"),
    @XmlEnumValue("Night")
    NIGHT("Night");
    private final String value;

    CancellationChargeTypeForHotel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CancellationChargeTypeForHotel fromValue(String v) {
        for (CancellationChargeTypeForHotel c: CancellationChargeTypeForHotel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
