
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de GuestType.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="GuestType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Adult"/>
 *     &lt;enumeration value="Child"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GuestType")
@XmlEnum
public enum GuestType {

    @XmlEnumValue("Adult")
    ADULT("Adult"),
    @XmlEnumValue("Child")
    CHILD("Child");
    private final String value;

    GuestType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GuestType fromValue(String v) {
        for (GuestType c: GuestType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
