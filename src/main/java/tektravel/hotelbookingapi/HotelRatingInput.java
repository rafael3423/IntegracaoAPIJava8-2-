
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de HotelRatingInput.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="HotelRatingInput">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="OneStarOrLess"/>
 *     &lt;enumeration value="TwoStarOrLess"/>
 *     &lt;enumeration value="ThreeStarOrLess"/>
 *     &lt;enumeration value="FourStarOrLess"/>
 *     &lt;enumeration value="FiveStarOrLess"/>
 *     &lt;enumeration value="OneStarOrMore"/>
 *     &lt;enumeration value="TwoStarOrMore"/>
 *     &lt;enumeration value="ThreeStarOrMore"/>
 *     &lt;enumeration value="FourStarOrMore"/>
 *     &lt;enumeration value="FiveStarOrMore"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HotelRatingInput")
@XmlEnum
public enum HotelRatingInput {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("OneStarOrLess")
    ONE_STAR_OR_LESS("OneStarOrLess"),
    @XmlEnumValue("TwoStarOrLess")
    TWO_STAR_OR_LESS("TwoStarOrLess"),
    @XmlEnumValue("ThreeStarOrLess")
    THREE_STAR_OR_LESS("ThreeStarOrLess"),
    @XmlEnumValue("FourStarOrLess")
    FOUR_STAR_OR_LESS("FourStarOrLess"),
    @XmlEnumValue("FiveStarOrLess")
    FIVE_STAR_OR_LESS("FiveStarOrLess"),
    @XmlEnumValue("OneStarOrMore")
    ONE_STAR_OR_MORE("OneStarOrMore"),
    @XmlEnumValue("TwoStarOrMore")
    TWO_STAR_OR_MORE("TwoStarOrMore"),
    @XmlEnumValue("ThreeStarOrMore")
    THREE_STAR_OR_MORE("ThreeStarOrMore"),
    @XmlEnumValue("FourStarOrMore")
    FOUR_STAR_OR_MORE("FourStarOrMore"),
    @XmlEnumValue("FiveStarOrMore")
    FIVE_STAR_OR_MORE("FiveStarOrMore");
    private final String value;

    HotelRatingInput(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HotelRatingInput fromValue(String v) {
        for (HotelRatingInput c: HotelRatingInput.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
