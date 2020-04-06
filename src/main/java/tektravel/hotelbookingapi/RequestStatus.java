
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de RequestStatus.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="RequestStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unprocessed"/>
 *     &lt;enumeration value="RequestSent"/>
 *     &lt;enumeration value="InProgress"/>
 *     &lt;enumeration value="AgentApprovalPending"/>
 *     &lt;enumeration value="PendingWithSupplier"/>
 *     &lt;enumeration value="Amended"/>
 *     &lt;enumeration value="Withdrawn"/>
 *     &lt;enumeration value="Rejected"/>
 *     &lt;enumeration value="Cancelled"/>
 *     &lt;enumeration value="NotRequested"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RequestStatus")
@XmlEnum
public enum RequestStatus {

    @XmlEnumValue("Unprocessed")
    UNPROCESSED("Unprocessed"),
    @XmlEnumValue("RequestSent")
    REQUEST_SENT("RequestSent"),
    @XmlEnumValue("InProgress")
    IN_PROGRESS("InProgress"),
    @XmlEnumValue("AgentApprovalPending")
    AGENT_APPROVAL_PENDING("AgentApprovalPending"),
    @XmlEnumValue("PendingWithSupplier")
    PENDING_WITH_SUPPLIER("PendingWithSupplier"),
    @XmlEnumValue("Amended")
    AMENDED("Amended"),
    @XmlEnumValue("Withdrawn")
    WITHDRAWN("Withdrawn"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected"),
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("NotRequested")
    NOT_REQUESTED("NotRequested");
    private final String value;

    RequestStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RequestStatus fromValue(String v) {
        for (RequestStatus c: RequestStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
