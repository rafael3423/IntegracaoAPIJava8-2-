
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de DateActionRes.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="DateActionRes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Retained"/>
 *     &lt;enumeration value="Changed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DateActionRes")
@XmlEnum
public enum DateActionRes {

    @XmlEnumValue("Retained")
    RETAINED("Retained"),
    @XmlEnumValue("Changed")
    CHANGED("Changed");
    private final String value;

    DateActionRes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DateActionRes fromValue(String v) {
        for (DateActionRes c: DateActionRes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
