
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de RoomRequested.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="RoomRequested">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FirstRoom"/>
 *     &lt;enumeration value="SecondRoom"/>
 *     &lt;enumeration value="ThirdRoom"/>
 *     &lt;enumeration value="FourthRoom"/>
 *     &lt;enumeration value="FifthRoom"/>
 *     &lt;enumeration value="SixthRoom"/>
 *     &lt;enumeration value="SeventhRoom"/>
 *     &lt;enumeration value="EighthRoom"/>
 *     &lt;enumeration value="NinthRoom"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoomRequested")
@XmlEnum
public enum RoomRequested {

    @XmlEnumValue("FirstRoom")
    FIRST_ROOM("FirstRoom"),
    @XmlEnumValue("SecondRoom")
    SECOND_ROOM("SecondRoom"),
    @XmlEnumValue("ThirdRoom")
    THIRD_ROOM("ThirdRoom"),
    @XmlEnumValue("FourthRoom")
    FOURTH_ROOM("FourthRoom"),
    @XmlEnumValue("FifthRoom")
    FIFTH_ROOM("FifthRoom"),
    @XmlEnumValue("SixthRoom")
    SIXTH_ROOM("SixthRoom"),
    @XmlEnumValue("SeventhRoom")
    SEVENTH_ROOM("SeventhRoom"),
    @XmlEnumValue("EighthRoom")
    EIGHTH_ROOM("EighthRoom"),
    @XmlEnumValue("NinthRoom")
    NINTH_ROOM("NinthRoom");
    private final String value;

    RoomRequested(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RoomRequested fromValue(String v) {
        for (RoomRequested c: RoomRequested.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
