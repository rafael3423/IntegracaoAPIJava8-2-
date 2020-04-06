
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de PolicyFormat.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="PolicyFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Text"/>
 *     &lt;enumeration value="Nodes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PolicyFormat")
@XmlEnum
public enum PolicyFormat {

    @XmlEnumValue("Text")
    TEXT("Text"),
    @XmlEnumValue("Nodes")
    NODES("Nodes");
    private final String value;

    PolicyFormat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PolicyFormat fromValue(String v) {
        for (PolicyFormat c: PolicyFormat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
